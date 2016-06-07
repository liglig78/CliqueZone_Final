package heartModule.GeneralTypes;

import java.util.Map;

/**
 * Created by Toshiba on 30/05/2016.
 */
public class CzTechnitionSchedule extends CzGeneralType {
    CzTechnician tecnition;
    // <Time, CzScheduleData OnTime>
    Map<String, CzScheduleData> schedule;
}
