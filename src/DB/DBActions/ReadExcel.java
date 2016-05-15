package DB.DBActions;

import DB.Types.GeneralDBType;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by Toshiba on 13/05/2016.
 */
public class ReadExcel {


    public static void main (String args[]) throws IOException {
        String PROJECT_PATH = new File(".").getCanonicalPath();
        String fileNameAgents = PROJECT_PATH  + "\\src\\resources\\files\\AgentsDB.csv";

        System.out.println(fileNameAgents);
        readExcelFile(fileNameAgents);
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
