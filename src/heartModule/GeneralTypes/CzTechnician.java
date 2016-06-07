package heartModule.GeneralTypes;

import com.google.maps.model.LatLng;
import org.joda.time.DateTime;

/**
 * Created by ASUS-PC on 22/05/2016.
 */
public class CzTechnician extends CzGeneralType {
    int id;
    String name;
    DateTime beginningTime;
    float workHoures;
    LatLng homeLocation;
    // how much time in this subject
    float specialty;
    // how much time in company
    float seniority;
    boolean isInOffice;
}
