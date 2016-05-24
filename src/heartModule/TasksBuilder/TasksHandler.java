package heartModule.TasksBuilder;

import DB.Types.GeneralDBType;
import heartModule.Conf;
import heartModule.GeneralTypes.CzGeneralType;
import heartModule.GeneralTypes.CzTask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Toshiba on 24/05/2016.
 */
public class TasksHandler extends TypesHandler{

    public TasksHandler(List<GeneralDBType> dbList) {
        super(dbList);
    }

    public List<CzTask> getAll() {

        List<CzTask> list = new ArrayList<CzTask>();

        return list;
    }

    @Override
    public void sortAll(List<CzGeneralType> list) {

    }


    /**
     * Task Priority function
     * @param level - קריטיות
     * @param dueDate - the date to visit the costumer
     * @param vipCustomer
     * @param creatintionTime - creation time of the task
     * @return - tasck Priority (TP)
     * @throws ParseException
     */
    public double TPFunction (float level, String dueDate, boolean vipCustomer, String creatintionTime) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = format.parse(dueDate);
        Date today = new Date();

        double tp = Math.max((int)level, Math.max((vipCustomer)?1:0, /*Today*/(d1 == today)?1:0)) * Conf.criticalFactor;
        // TODO: Ageing

        return tp;
    }

}
