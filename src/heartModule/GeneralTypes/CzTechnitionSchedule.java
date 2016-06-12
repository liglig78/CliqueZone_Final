package heartModule.GeneralTypes;

import com.google.maps.model.LatLng;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Toshiba on 30/05/2016.
 */
public class CzTechnitionSchedule extends CzGeneralType {
    private CzTechnician tecnition;
    private LatLng privuseAddress;
    // <Time, CzScheduleData OnTime>
    private Map<DateTime, CzScheduleData> schedule;

    public CzTechnitionSchedule(CzTechnician technician) {
        super();
        schedule = new HashMap<>();
        this.tecnition = technician;
        privuseAddress = technician.getLatLngAddress();
    }


    public CzTechnician getTecnition() {
        return tecnition;
    }

    public void setTecnition(CzTechnician tecnition) {
        this.tecnition = tecnition;
    }

    public Map<DateTime, CzScheduleData> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DateTime, CzScheduleData> schedule) {
        this.schedule = schedule;
    }

    public LatLng getPrivuseAddress() {
        return privuseAddress;
    }

    public void setPrivuseAddress(LatLng privuseAddress) {
        this.privuseAddress = privuseAddress;
    }
}
