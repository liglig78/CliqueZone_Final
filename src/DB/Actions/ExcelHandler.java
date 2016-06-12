package DB.Actions;

import DB.Types.*;
import com.google.maps.model.LatLng;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by ASUS-PC on 22/05/2016.
 */
public class ExcelHandler implements Runnable {
    private List<Technician> techniciansList;
    private List<Task> taskList;
    boolean googleApi = true;
    AddressesConverter addressesConverter;

    public List<Technician> getTechniciansList() {
        return techniciansList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    String PROJECT_PATH = new File(".").getCanonicalPath();
    String fileNameAgents = "./resources/AgentsDB.csv";
    String fileNameTasks = "./resources/TaskDB33.csv";
    String fileNameAddresses = "./resources/AddressesDB.csv";

    /**
     * @param addressesConverter - can be null in case we whant to read the coordinates from the BD,
     *                           or not null in case we want to use googleAPI to convert addresses to coordinates.
     * @throws IOException
     */
    public ExcelHandler(AddressesConverter addressesConverter) throws IOException {
        this.techniciansList = new ArrayList<Technician>();
        this.taskList = new ArrayList<Task>();
        this.addressesConverter = addressesConverter;

    }

    private void readTechniciansExcelFile(String fileName) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(fileName));
        String[] nextLine;
        //id,name,Beginning time,work houres,specialty,HomeLocation,seniority,isInOffice

        reader.readNext();

        while ((nextLine = reader.readNext()) != null) {

            Technician technician = new Technician();

            technician.setId(Integer.parseInt(nextLine[0]));
            technician.setName(nextLine[1]);
            technician.setBeginningTime(nextLine[2]);
            technician.setWorkHoures(Float.parseFloat(nextLine[3]));
            technician.setSpecialty(Integer.parseInt(nextLine[4]));
            technician.setHomeLocation(nextLine[5]);
            technician.setSeniority(Integer.parseInt(nextLine[6]));
            technician.setInOffice(Boolean.parseBoolean(nextLine[7]));

            //  System.out.println("technician = " + technician);
            techniciansList.add(technician);
        }
    }

    private void readTasksExcelFile(String fileName) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(fileName));
        String[] nextLine;

        nextLine = reader.readNext();

        while ((nextLine = reader.readNext()) != null) {
            Task task = new Task();

            task.setIdTask(Integer.parseInt(nextLine[0]));
            task.setCoustumerName(nextLine[1]);
            task.setAddress(nextLine[2]);
            task.setTelephone(nextLine[3]);
            task.setCreatintionTime(nextLine[4]);
            task.setLevel(Float.parseFloat(nextLine[7]));
            task.setToolShed(Boolean.parseBoolean(nextLine[8]));
            task.setVipCustomer(Boolean.parseBoolean(nextLine[9]));
            task.setDueDate(nextLine[10]);
            task.setDueDateTime(nextLine[11]);
            task.setWindowToSupply(Integer.parseInt(nextLine[12]));
            task.setTimeToFix(Integer.parseInt(nextLine[13]));
            //task.setDecripation(nextLine[14]);

            //    System.out.println("task = " + task);
            taskList.add(task);
        }
    }


    private void creatAddressesDb(Map<String, LatLng> addressesMap, String addressesFileName) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(addressesFileName));
        writer.writeNext(new String[]{"address", "lat", "lng"});
        addressesMap.forEach((address, latlng) -> {
            String[] entry = new String[]{address, String.valueOf(latlng.lat), String.valueOf(latlng.lng)};
            writer.writeNext(entry);
        });
        writer.flush();
        writer.close();
    }


    @Override
    public void run() {
        try {
            readTechniciansExcelFile(fileNameAgents);
            readTasksExcelFile(fileNameTasks);
            Map<String, LatLng> addressesMap;
            if (addressesConverter != null) {

                addressesMap = gettingAllCoordinations(fileNameAddresses);

                taskList.forEach(task -> {
                    LatLng latLng = addressesMap.get(task.getAddress());
                    if (latLng == null) {
                        try {
                            latLng = addressesConverter.convertAddress(task.getAddress());
                            addressesMap.put(task.getAddress(), latLng);
                        } catch (Exception e) {
                            System.out.println("Error: problem with task #" + task.getIdTask() + " address");
                        }
                    }
                    task.setLatLng(latLng);
                });

                techniciansList.forEach(technician -> {

                    LatLng latLng = addressesMap.get(technician.getHomeLocation());
                    if (latLng == null) {
                        try {
                            latLng = addressesConverter.convertAddress(technician.getHomeLocation());
                            addressesMap.put(technician.getHomeLocation(), latLng);
                        } catch (Exception e) {

                            System.out.println("Error: problem with technician #" + technician.getId() + " address");
                        }
                    }
                    technician.setLatLng(latLng);
                });


                creatAddressesDb(addressesMap, fileNameAddresses);

            } else {
                addressesMap = gettingAllCoordinations(fileNameAddresses);
                techniciansList.forEach(technician -> {
                    technician.setLatLng(addressesMap.get(technician.getHomeLocation()));
                });

                taskList.forEach(task -> {
                    task.setLatLng(addressesMap.get(task.getAddress()));
                });

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, LatLng> gettingAllCoordinations(String fileName) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(fileName));
        Map<String, LatLng> addressesMap = new HashMap<>();
        String[] nextLine = reader.readNext();

        while ((nextLine = reader.readNext()) != null) {
            try {

                addressesMap.put(nextLine[0], new LatLng(Double.parseDouble(nextLine[1]), Double.parseDouble(nextLine[2])));
            } catch (Exception e) {
                System.out.println("somthing wrong!");
            }
        }
        return addressesMap;
    }
}