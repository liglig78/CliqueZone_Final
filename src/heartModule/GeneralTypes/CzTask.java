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
    private int windowToSupply;
    private int timeToFix;

    public Double getTp() { return tp; }

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
                ", windowToSupply=" + windowToSupply +
                ", timeToFix=" + timeToFix +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CzTask)) return false;

        CzTask czTask = (CzTask) o;

        if (idTask != czTask.idTask) return false;
        if (Float.compare(czTask.level, level) != 0) return false;
        if (toolShed != czTask.toolShed) return false;
        if (vipCustomer != czTask.vipCustomer) return false;
        if (Double.compare(czTask.tp, tp) != 0) return false;
        if (windowToSupply != czTask.windowToSupply) return false;
        if (timeToFix != czTask.timeToFix) return false;
        if (coustumerName != null ? !coustumerName.equals(czTask.coustumerName) : czTask.coustumerName != null)
            return false;
        if (address != null ? !address.equals(czTask.address) : czTask.address != null) return false;
        if (telephone != null ? !telephone.equals(czTask.telephone) : czTask.telephone != null) return false;
        if (decripation != null ? !decripation.equals(czTask.decripation) : czTask.decripation != null) return false;
        if (creatintionTime != null ? !creatintionTime.equals(czTask.creatintionTime) : czTask.creatintionTime != null)
            return false;
        return dueDate != null ? dueDate.equals(czTask.dueDate) : czTask.dueDate == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idTask;
        result = 31 * result + (coustumerName != null ? coustumerName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (level != +0.0f ? Float.floatToIntBits(level) : 0);
        result = 31 * result + (toolShed ? 1 : 0);
        result = 31 * result + (vipCustomer ? 1 : 0);
        result = 31 * result + (decripation != null ? decripation.hashCode() : 0);
        temp = Double.doubleToLongBits(tp);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (creatintionTime != null ? creatintionTime.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        result = 31 * result + windowToSupply;
        result = 31 * result + timeToFix;
        return result;
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
