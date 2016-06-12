package heartModule.GeneralTypes;

/**
 * Created by Toshiba on 30/05/2016.
 */
public class CzScheduleData extends CzGeneralType{
    double ATT;
    CzTask task;
    int drivingTime;

    public CzScheduleData(double ATT, CzTask task, int drivingTime) {
        this.ATT = ATT;
        this.task = task;
        this.drivingTime = drivingTime;
    }

    public double getATT() {
        return ATT;
    }

    public CzTask getTask() {
        return task;
    }

    public int getDrivingTime() {
        return drivingTime;
    }
}
