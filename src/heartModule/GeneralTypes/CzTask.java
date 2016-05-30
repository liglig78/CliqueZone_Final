package heartModule.GeneralTypes;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * Created by ASUS-PC on 22/05/2016.
 */
public class CzTask extends CzGeneralType implements Serializable {
    private int idTask;
    private String coustumerName;
    private String address;
    private String telephone;
    private float level;
    private boolean toolShed;
    private boolean vipCustomer;
    private String decripation;
    private double tp;

    private DateTime creatintionTime;
    private DateTime dueDate;
    private DateTime dueDateTime;
    private int windowToSupply;
    private int timeToFix;

    private boolean isTaken = false;


    @Override
    public String toString() {
        return "CzTask{" +
                "idTask=" + idTask +
                ", coustumerName='" + coustumerName + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", level=" + level +
                ", toolShed=" + toolShed +
                ", vipCustomer=" + vipCustomer +
                ", decripation='" + decripation + '\'' +
                ", tp=" + tp +
                ", creatintionTime=" + creatintionTime +
                ", dueDate=" + dueDate +
                ", dueDateTime=" + dueDateTime +
                ", windowToSupply=" + windowToSupply +
                ", timeToFix=" + timeToFix +
                '}';
    }

    public Double getTp() { return tp; }

    public DateTime getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(DateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public String getCoustumerName() {
        return coustumerName;
    }

    public void setCoustumerName(String coustumerName) {
        this.coustumerName = coustumerName;
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

    public String getDecripation() {
        return decripation;
    }

    public void setDecripation(String decripation) {
        this.decripation = decripation;
    }

    public void setTp(double tp) {
        this.tp = tp;
    }

    public DateTime getCreatintionTime() {
        return creatintionTime;
    }

    public void setCreatintionTime(DateTime creatintionTime) {
        this.creatintionTime = creatintionTime;
    }

    public DateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(DateTime dueDate) {
        this.dueDate = dueDate;
    }

    public int getWindowToSupply() {
        return windowToSupply;
    }

    public void setWindowToSupply(int windowToSupply) {
        this.windowToSupply = windowToSupply;
    }

    public int getTimeToFix() {
        return timeToFix;
    }

    public void setTimeToFix(int timeToFix) {
        this.timeToFix = timeToFix;
    }
}
