package heartModule;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by Toshiba on 20/05/2016.
 */
public class Conf {

    public static double criticalFactor = 0.7;
    public static double ageingFactor = 1-criticalFactor;
    //for technicians schedule
    public static double scheduleSliceTime  = 1;
    public static String dateFormat = "dd/MM/yyyy";
    public static String timeFormat = "HH:mm";
    public static String dateTimeFormat = dateFormat+"-"+timeFormat;
    public static String today = "30/05/2016";
    public static String googleApiKey = "AIzaSyBF-s6KlxslCKL1eDDXSWi0-0-d64RGQuY";

}
