package DB.Types;

import com.google.maps.model.LatLng;

/**
 * Created by ASUS-PC on 13/05/2016.
 */
public class Technician extends GeneralDBType {

    private int id;
    private String name;
    private String beginningTime;
    private float workHoures;
    private int specialty;
    private String homeLocation;
    private LatLng latLng;
    private int seniority;
    private boolean isInOffice;

    @Override
    public String toString() {
        return "Technician{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", beginningTime='" + beginningTime + '\'' +
                ", workHores=" + workHoures +
                ", specialty=" + specialty +
                ", homeLocation='" + homeLocation + '\'' +
                ", seniority=" + seniority +
                ", isInOffice=" + isInOffice +
                '}';
    }

    public boolean isInOffice() {
        return isInOffice;
    }

    public void setInOffice(boolean inOffice) {
        isInOffice = inOffice;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public String getHomeLocation() {
        return homeLocation;
    }

    public void setHomeLocation(String homeLocation) {
        this.homeLocation = homeLocation;
    }

    public int getSpecialty() {
        return specialty;
    }

    public void setSpecialty(int specialty) {
        this.specialty = specialty;
    }

    public float getWorkHoures() {
        return workHoures;
    }

    public void setWorkHoures(float workHoures) {
        this.workHoures = workHoures;
    }

    public String getBeginningTime() {
        return beginningTime;
    }

    public void setBeginningTime(String beginningTime) {
        this.beginningTime = beginningTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LatLng getLatLng() { return latLng; }

    public void setLatLng(LatLng latLng) { this.latLng = latLng;}
}
