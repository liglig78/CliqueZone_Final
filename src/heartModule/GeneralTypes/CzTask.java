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
    private String creatintionTime;
    private float level;
    private boolean toolShed;
    private boolean vipCustomer;
    private DateTime dueDate;
    private String windowToSupply;
    private String timeToFix;
    private String decripation;
    private double tp;

    public Double getTp() {
        return tp;
    }
}
