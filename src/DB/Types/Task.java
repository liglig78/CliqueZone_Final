package DB.Types;

import com.google.maps.model.LatLng;

/**
 * Created by ASUS-PC on 13/05/2016.
 */
public class Task extends GeneralDBType {
    private int idTask;
    private String coustumerName;
    private String address;
    private LatLng latLng;
    private String telephone;
    private String creatintionTime;
    private float level;
    private boolean toolShed;
    private boolean vipCustomer;
    private String dueDate;
    // when tecnition can visit (time in day)
    private String dueDateTime;
    // in houres
    private int windowToSupply;
    // in minuts
    private int timeToFix;
    private String decripation;

    @Override
    public String toString() {
        return "Task{" +
                "idTask=" + idTask +
                ", coustumerName='" + coustumerName + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", creatintionTime='" + creatintionTime + '\'' +
                ", level=" + level +
                ", toolShed=" + toolShed +
                ", vipCustomer=" + vipCustomer +
                ", dueDate='" + dueDate + '\'' +
                ", dueDateTime='" + dueDateTime + '\'' +
                ", windowToSupply=" + windowToSupply +
                ", timeToFix=" + timeToFix +
                ", decripation='" + decripation + '\'' +
                '}';
    }

    public String getCoustumerName() {
        return coustumerName;
    }

    public void setCoustumerName(String coustumerName) {
        this.coustumerName = coustumerName;
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCreatintionTime() {
        return creatintionTime;
    }

    public void setCreatintionTime(String creatintionTime) {
        this.creatintionTime = creatintionTime;
    }

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }

    public boolean isToolShed() {
        return toolShed;
    }

    public void setToolShed(boolean toolShed) {
        this.toolShed = toolShed;
    }

    public boolean isVipCustomer() {
        return vipCustomer;
    }

    public void setVipCustomer(boolean vipCustomer) {
        this.vipCustomer = vipCustomer;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDecripation() {
        return decripation;
    }

    public void setDecripation(String decripation) {
        this.decripation = decripation;
    }

    public String getDueDateTime() { return dueDateTime;}

    public void setDueDateTime(String dueDateTime) {this.dueDateTime = dueDateTime; }

    public int getWindowToSupply() { return windowToSupply; }

    public void setWindowToSupply(int windowToSupply) { this.windowToSupply = windowToSupply; }

    public int getTimeToFix() { return timeToFix; }

    public void setTimeToFix(int timeToFix) { this.timeToFix = timeToFix; }

    public LatLng getLatLng() { return latLng; }

    public void setLatLng(LatLng latLng) { this.latLng = latLng;}
}
