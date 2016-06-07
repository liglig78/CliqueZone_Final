package heartModule.GeneralTypes;

import com.google.maps.model.LatLng;
import org.joda.time.DateTime;

/**
 * Created by ASUS-PC on 22/05/2016.
 */
public class CzTechnician extends CzGeneralType {
    private int id;
    private String name;
    private DateTime beginningTime;
    private float workHoures;
    private LatLng homeLocation;
    // how much time in this subject
    private float specialty;
    // how much time in company
    private float seniority;
    private boolean isInOffice;

    @Override
    public String toString() {
        return "CzTechnician{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", beginningTime=" + beginningTime +
                ", workHoures=" + workHoures +
                ", homeLocation=" + homeLocation +
                ", specialty=" + specialty +
                ", seniority=" + seniority +
                ", isInOffice=" + isInOffice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CzTechnician)) return false;

        CzTechnician that = (CzTechnician) o;

        if (id != that.id) return false;
        if (Float.compare(that.workHoures, workHoures) != 0) return false;
        if (Float.compare(that.specialty, specialty) != 0) return false;
        if (Float.compare(that.seniority, seniority) != 0) return false;
        if (isInOffice != that.isInOffice) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (beginningTime != null ? !beginningTime.equals(that.beginningTime) : that.beginningTime != null)
            return false;
        return homeLocation != null ? homeLocation.equals(that.homeLocation) : that.homeLocation == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (beginningTime != null ? beginningTime.hashCode() : 0);
        result = 31 * result + (workHoures != +0.0f ? Float.floatToIntBits(workHoures) : 0);
        result = 31 * result + (homeLocation != null ? homeLocation.hashCode() : 0);
        result = 31 * result + (specialty != +0.0f ? Float.floatToIntBits(specialty) : 0);
        result = 31 * result + (seniority != +0.0f ? Float.floatToIntBits(seniority) : 0);
        result = 31 * result + (isInOffice ? 1 : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getBeginningTime() {
        return beginningTime;
    }

    public void setBeginningTime(DateTime beginningTime) {
        this.beginningTime = beginningTime;
    }

    public float getWorkHoures() {
        return workHoures;
    }

    public void setWorkHoures(float workHoures) {
        this.workHoures = workHoures;
    }

    public LatLng getHomeLocation() {
        return homeLocation;
    }

    public void setHomeLocation(LatLng homeLocation) {
        this.homeLocation = homeLocation;
    }

    public float getSpecialty() {
        return specialty;
    }

    public void setSpecialty(float specialty) {
        this.specialty = specialty;
    }

    public float getSeniority() {
        return seniority;
    }

    public void setSeniority(float seniority) {
        this.seniority = seniority;
    }

    public boolean isInOffice() {
        return isInOffice;
    }

    public void setInOffice(boolean inOffice) {
        isInOffice = inOffice;
    }
}
