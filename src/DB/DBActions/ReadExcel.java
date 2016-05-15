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

        readTechniciansExcelFile(fileNameAgents);
       // readTasksExcelFile(fileNameAgents);
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
            technician.setSpecialty(Int.parseFloat(nextLine[3]));



            techniciansList.add(technician);



            // nextLine[] is an array of values from the line
            System.out.println(nextLine[0] +", " + nextLine[1] +", " +  nextLine[1]);
            System.out.println(technician.toString());
        }
    }

    public static List<GeneralDBType> readExcelFile(String fileName) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(fileName));

        String [] nextLine;

        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            System.out.println(nextLine[0] + nextLine[1] + "סתיו...");
        }
        return null;
    }
}
