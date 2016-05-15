package DB.DBActions;

import DB.GeneralDBType;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Toshiba on 13/05/2016.
 */
public class ReadExcel {
    private static String fileNameAgents = "C:\\Users\\Toshiba\\Google Drive\\המכללה למנהל\\שנה שלישית\\פרוייקט גמר\\כליקשטח\\איפיון\\DB\\תיקיה חדשה\\AgentsDB.csv";

    public static void main (String args[]) {
        try {
            readExcelFile(fileNameAgents);
        } catch (IOException e) {
            e.printStackTrace();
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
