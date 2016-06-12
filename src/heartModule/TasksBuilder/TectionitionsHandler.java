package heartModule.TasksBuilder;

import DB.Types.Task;
import DB.Types.Technician;
import heartModule.Conf;
import heartModule.GeneralTypes.CzGeneralType;
import heartModule.GeneralTypes.CzTask;
import heartModule.GeneralTypes.CzTechnician;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ligal on 22/05/2016.
 * <p>
 * this class build list of tasked with calculate priority.
 * ### similar tasks combines to "one task"
 */
public class TectionitionsHandler extends TypesHandler {

    public TectionitionsHandler(List<Technician> dbList) {
        super(dbList);
    }

    public List<CzTechnician> getAll() {

        List<CzTechnician> tecnitionMap = new ArrayList<>();
        DateTimeFormatter formatDate = DateTimeFormat.forPattern(Conf.dateFormat);
        DateTimeFormatter formatTime = DateTimeFormat.forPattern(Conf.timeFormat);
        DateTimeFormatter formatDateTime = DateTimeFormat.forPattern(Conf.dateTimeFormat);

        //PeriodFormatter formatTime;


        dbList.forEach((tecnition) -> {
            Technician dbTecnition = (Technician) tecnition;

            CzTechnician czTechnician = new CzTechnician();
            czTechnician.setId(dbTecnition.getId());
            czTechnician.setBeginningTime((formatTime.parseDateTime(dbTecnition.getBeginningTime())));
            czTechnician.setHomeLocation(dbTecnition.getHomeLocation());
            czTechnician.setInOffice(dbTecnition.isInOffice());
            czTechnician.setName(dbTecnition.getName());
            czTechnician.setSeniority(dbTecnition.getSeniority());
            czTechnician.setSpecialty(dbTecnition.getSpecialty());
            czTechnician.setWorkHoures(dbTecnition.getWorkHoures());
            czTechnician.setLatLngAddress(dbTecnition.getLatLng());
            tecnitionMap.add(czTechnician);
        });

        return tecnitionMap;
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

        double tp = Math.max((int) level, Math.max((vipCustomer) ? 1 : 0, /*Today*/(Days.daysBetween(DateTime.now(), dueDate).getDays() == 0) ? 1 : 0)); /* Conf.criticalFactor;*/
        // TODO: Ageing

        return tp;
    }

}
