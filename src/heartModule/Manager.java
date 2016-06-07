package heartModule;

import heartModule.GeneralTypes.CzTask;
import heartModule.GeneralTypes.CzTechnician;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Toshiba on 07/06/2016.
 */
public class Manager {


    private final Map<Integer, CzTechnician> techniciansMap;
    private Map<Integer, CzTechnician> availableTechMap;
    private List<CzTask> tasksList;


    public Manager(Map<Integer, CzTechnician> techniciansMap, List<CzTask> tasksList) {
        this.techniciansMap = techniciansMap;
        availableTechMap = getAllAvailableTechnitions();
        this.tasksList = tasksList;
        tasksList.sort((o1, o2) -> o1.getTp().compareTo(o2.getTp()));
    }

    private void setUpHungarian (){
        // getting sub tascks list according to the technitions amount
        List<CzTask> nextCriticalTasksList = tasksList.subList(0, availableTechMap.size());

       double[][] attArray = new double[availableTechMap.size()][availableTechMap.size()];

        List<List<Double>> hungarianMatrix = new ArrayList<>();

//        hungarianMatrix.forEach(technician -> {
//            technician.forEach(att -> att = ATTFunc(false){
//
//            });
//        });

    }

    private void afterHungarian (){

    }

    private  Map<Integer, CzTechnician> getAllAvailableTechnitions (){
        availableTechMap = new HashMap<>();

        techniciansMap.forEach((techId, technician) -> {
            if(technician.isInOffice()) {
                availableTechMap.put(techId, technician);
            }
        });

        return availableTechMap;
    }




    /**
     * this function calculate "agent to task (ATT)".
     *
     * @param isTimeFit
     * @param distance
     * @param specialty
     * @param seniority - how much time in company
     * @return: in case the result is close infinity - means thar task isn't fit to agent
     */
    public double ATTFunc(boolean isTimeFit, double distance, float specialty, float seniority){
        int f = (isTimeFit) ? (1) : (Integer.MAX_VALUE);
        return (f/(distance + specialty + seniority));
    }


}
