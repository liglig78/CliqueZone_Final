package DB.DBActions;

import DB.Types.GeneralDBType;
import DB.Types.Task;
import DB.Types.Technician;
import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Toshiba on 13/05/2016.
 */
public class ReadExcel {

   private static List<Technician> techniciansList;
   private static List<Task> taskList;

    public ReadExcel() {
        this.techniciansList = new ArrayList<Technician>();
        this.taskList = new ArrayList<Task>();
    }

    public static void main (String args[]) throws IOException {

        String PROJECT_PATH = new File(".").getCanonicalPath();
        String fileNameAgents = PROJECT_PATH  + "\\src\\resources\\files\\AgentsDB.csv";
        String fileNameTasks = PROJECT_PATH + "\\src\\resources\\files\\TasksDB.csv";

        readTechniciansExcelFile(fileNameAgents);
        readTasksExcelFile(fileNameTasks);
    }

    private static void readTechniciansExcelFile(String fileName) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(fileName));
        String [] nextLine;
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

            techniciansList.add(technician);
        }
    }

    private static void readTasksExcelFile(String fileName) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(fileName));
        String [] nextLine;
        //task number,coustumerName,address,telephone,creationTime,FRZ,כמות,level,toolshed,vipCustomer,due date,WindowToSupply,timeToFix,decripation
        reader.readNext();

        while ((nextLine = reader.readNext()) != null)
        {

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
            task.setWindowToSupply(nextLine[11]);
            task.setTimeToFix(nextLine[12]);
            task.setDecripation(nextLine[13]);

            taskList.add(task);
        }
    }

}
