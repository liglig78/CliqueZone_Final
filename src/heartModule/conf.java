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
    public static String timeFormat = "hh:mm";
}
