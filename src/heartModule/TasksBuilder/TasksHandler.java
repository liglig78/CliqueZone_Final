package heartModule.TasksBuilder;

import DB.Types.Task;
import heartModule.Conf;
import heartModule.GeneralTypes.CzGeneralType;
import heartModule.GeneralTypes.CzTask;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormat;
import org.joda.time.format.PeriodFormatter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toshiba on 24/05/2016.
 */
public class TasksHandler extends TypesHandler {

    public TasksHandler(List<Task> dbList) {
        super(dbList);
    }

    public List<CzTask> getAll() {

        List<CzTask> list = new ArrayList<CzTask>();
        DateTimeFormatter formatDate = DateTimeFormat.forPattern(Conf.dateFormat);
        PeriodFormatter formatTime;

        dbList.forEach((task) -> {
            Task dbTask = (Task) task;

            CzTask czTask = new CzTask();

            czTask.setIdTask(dbTask.getIdTask());
            czTask.setCoustumerName(dbTask.getCoustumerName());
            czTask.setAddress(dbTask.getAddress());
            czTask.setTelephone(dbTask.getTelephone());
            czTask.setLevel(dbTask.getLevel());
            czTask.setToolShed(dbTask.isToolShed());
            czTask.setVipCustomer(dbTask.isVipCustomer());
            czTask.setDecripation(dbTask.getDecripation());
            czTask.setCreatintionTime(formatDate.parseDateTime(dbTask.getCreatintionTime()));
            czTask.setTimeToFix(dbTask.getTimeToFix());
            czTask.setDueDate(formatDate.parseDateTime(dbTask.getDueDate()));


            //czTask.setDueDateTime();
            czTask.setWindowToSupply(dbTask.getWindowToSupply());
            czTask.setTp(this.TPFunction(czTask.getLevel(), czTask.getDueDate(), czTask.isVipCustomer(), czTask.getCreatintionTime()));

            System.out.println("czTask = " + czTask);
            
            list.add(czTask);
        });


        return list;
    }

    @Override
    public void sortAll(List<CzGeneralType> list) {
        
    }


    /**
     * Task Priority function
     *
     * @param level           - critical
     * @param dueDate         - the date to visit the costumer
     * @param vipCustomer
     * @param creatintionTime - creation time of the task
     * @return - tasck Priority (TP)
     * @throws ParseException
     */
    public double TPFunction(float level, DateTime dueDate, boolean vipCustomer, DateTime creatintionTime) {

        double tp = Math.max((int) level, Math.max((vipCustomer) ? 1 : 0, /*Today*/(dueDate == DateTime.now()) ? 1 : 0)) * Conf.criticalFactor;
        // TODO: Ageing

        return tp;
    }

}
