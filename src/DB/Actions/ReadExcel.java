package DB.Actions;

import DB.Types.*;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS-PC on 22/05/2016.
 */
public class ReadExcel implements Runnable {
    private List<Technician> techniciansList;
    private List<Task> taskList;

    public List<Technician> getTechniciansList() {
        return techniciansList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    String PROJECT_PATH = new File(".").getCanonicalPath();
    String fileNameAgents = "./resources/AgentsDB.csv";
    String fileNameTasks = "./resources/TaskDB33.csv";

    public ReadExcel() throws IOException {
        this.techniciansList = new ArrayList<Technician>();
        this.taskList = new ArrayList<Task>();

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

            System.out.println("technician = " + technician);
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
            task.setDecripation(nextLine[14]);

            System.out.println("task = " + task);
            taskList.add(task);
        }
    }

    @Override
    public void run() {
        try {
            readTechniciansExcelFile(fileNameAgents);
            readTasksExcelFile(fileNameTasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
