package DB.Actions;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import heartModule.Conf;
import heartModule.GeneralTypes.CzScheduleData;
import heartModule.GeneralTypes.CzTechnitionSchedule;
import org.joda.time.DateTime;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Toshiba on 11/06/2016.
 */
public class ExcelResutWriter {
    String resultFileNAme = "./resources/result.csv";
    private final int begginingHour = 6;
    private final int endingHour = 16;


    public ExcelResutWriter(Map<Integer, CzTechnitionSchedule> tecSced) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(resultFileNAme));
        DateTime tmpTime = new DateTime();
        DateTime begginingTime = new DateTime(1970, 1, 1,begginingHour,0,0);
        DateTime endOfWorkDay = new DateTime(1970, 1, 1,endingHour,0,0);

        String[][] title = new String[tecSced.size()+1][(endingHour - begginingHour) * 60 / Conf.scheduleSliceTime +1];
        int i = 1;
        // printing the titles
        int j = 1;
        for(Map.Entry<Integer, CzTechnitionSchedule> e : tecSced.entrySet())
        {
            title[j++][0] = e.getKey().toString();
        }

        for (DateTime currentSection = begginingTime; currentSection.compareTo(endOfWorkDay) < 0; currentSection = currentSection.plusMinutes(Conf.scheduleSliceTime)) {

            title[0][i] = (currentSection.getHourOfDay() + ":" + currentSection.getMinuteOfHour());
            for (int k = 1; k <= tecSced.size(); k++) {

                CzScheduleData sd = tecSced.get(Integer.parseInt(title[k][0])).getSchedule().get(currentSection);
                if(sd != null)
                    title[k][i] = sd.getTask().getIdTask() + "";
            }
            i++;
        }
        for (int k = 0; k < tecSced.size() + 1; k++) {

            writer.writeNext(title[k]);
        }

        writer.flush();
        writer.close();
    }
}
