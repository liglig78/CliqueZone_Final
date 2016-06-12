package heartModule;

import com.google.maps.model.LatLng;
import heartModule.GeneralTypes.CzScheduleData;
import heartModule.GeneralTypes.CzTask;
import heartModule.GeneralTypes.CzTechnician;
import heartModule.GeneralTypes.CzTechnitionSchedule;
import heartModule.Geodesic.Distance;
import heartModule.Hungarian.Hungarian;
import heartModule.Hungarian.HungarianBipartiteMatching;
import heartModule.Hungarian.HungarianDouble;
import org.joda.time.DateTime;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Toshiba on 07/06/2016.
 */
public class Manager {


    private final List<CzTechnician> techniciansList;
    private List<CzTask> tasksList;
    private Map<Integer, CzTechnitionSchedule> tecSched;

    public Manager(List<CzTechnician> techniciansMap, List<CzTask> tasksList) {
        // getting all the technicions that cat work (in office)
        this.techniciansList = techniciansMap.stream().filter(t -> t.isInOffice()).collect(Collectors.toList());
        this.tasksList = tasksList;
        // ordering the tasks by TP
        // in decreasing order
        tasksList.sort((o1, o2) -> o2.getTp().compareTo(o1.getTp()));
        tecSched = new HashMap<>();
        techniciansList.forEach(t -> {
            tecSched.put(t.getId(), new CzTechnitionSchedule(t));
        });
    }

    public void setUpHungarian() {

        // getting the earlyest starting time of the technicions
        DateTime begginingTime = techniciansList.stream().min((o1, o2) ->
                o1.getBeginningTime().compareTo(o2.getBeginningTime())).get().getBeginningTime();

        // getting the time of the end of the work day.
        DateTime endOfWorkDay = techniciansList.stream().max((o1, o2) ->
                o1.getEndTime().compareTo(o2.getEndTime())).get().getEndTime();

        // running all over the sections of the schedule
        for (DateTime currentSection = begginingTime; currentSection.compareTo(endOfWorkDay) < 0; currentSection = currentSection.plusMinutes(Conf.scheduleSliceTime)) {

            // getting the available technicians
            final DateTime finalCurrentSection = currentSection;

            List<CzTechnician> tecInSection = techniciansList.stream().filter(t ->
                    t.getBeginningTime().compareTo(finalCurrentSection) <= 0 &&
                            t.getEndTime().compareTo(finalCurrentSection.plusMinutes(Conf.scheduleSliceTime)) >= 0).collect(Collectors.toList());


            // getting tasks in section, count = technicians size
            // TODO: check if the ordered tp is saved
            // TODO: take the technician
            List<CzTask> tasksInSection = tasksList.stream().filter(t ->
                    t.getDueDateTime().compareTo(finalCurrentSection) <= 0 &&
                            t.getEndTime().compareTo(finalCurrentSection.plus(Conf.scheduleSliceTime)) >= 0).collect(Collectors.toList());;
            // tacking amount of tasks according the amount of the technicians
            if(tasksInSection.size() < tecInSection.size())
            {
                tecInSection.sort((t1, t2)->
                {
                    int scheduleSizeDiff = tecSched.get(t1.getId()).getSchedule().size() -
                                            tecSched.get(t2.getId()).getSchedule().size();
                    if(scheduleSizeDiff != 0)
                        return scheduleSizeDiff;
                    return (int)(t1.getSeniority() - t2.getSeniority());
                });
                tecInSection = tecInSection.subList(0,tasksInSection.size());
            }
            else
                tasksInSection = tasksInSection.subList(0, tecInSection.size());

            if(tasksInSection.size() == 0)
                continue;

            double[][] hungarianMat = new double[tecInSection.size()][tasksInSection.size()];

           for (int tecI = 0; tecI < tecInSection.size(); tecI++) {
               for (int taskI = 0; taskI < tasksInSection.size(); taskI++) {

                   LatLng priviuseAddress = tecSched.get(tecInSection.get(tecI).getId()).getPrivuseAddress();
                   double distanse = Distance.getDistance(priviuseAddress, tasksInSection.get(taskI).getLatLngAddress())/1000;
                   double att = ATTFunc(true, distanse, tecInSection.get(tecI).getSpecialty(), tecInSection.get(tecI).getSeniority());
                   hungarianMat[tecI][taskI] = att;
               }
           }

            // After Hungarian
            //HungarianDouble hungarian = new HungarianDouble(hungarianMat);
            HungarianBipartiteMatching h = new HungarianBipartiteMatching(hungarianMat);

            int[] result = h.execute();//hungarian.getResult();


            System.out.println("=========round # "+ currentSection.getHourOfDay() + ":" + currentSection.getMinuteOfHour() +" ============");
            // printing the results
            for(int i = 0; i < result.length; i++)
                System.out.println("Row: "+ i +" => Col: "+ result[i] +" ("+hungarianMat[i][result[i]]+")"); // Rowi => Colj (value)

            // runnung all over the results and updating the schedule to each technician
            for (int i = 0; i < result.length; i++) {

                CzTask assignedTask = tasksInSection.get(result[i]);

                // filling the tecSched foreach technician
                CzTechnitionSchedule currTecSchedual = this.tecSched.get(tecInSection.get(i).getId());
                currTecSchedual.getSchedule().put(currentSection,
                        new CzScheduleData(hungarianMat[i][result[i]], assignedTask, 0));
                // updateing the "priviuseAddress" for the next round
                currTecSchedual.setPrivuseAddress(assignedTask.getLatLngAddress());

                // remove the task that we just assign
                tasksList.removeIf(t -> t.getIdTask() == assignedTask.getIdTask());
            }
        }
        System.out.print("");
    }

    private void afterHungarian() {

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
    public double ATTFunc(boolean isTimeFit, double distance, float specialty, float seniority) {
        int f = (isTimeFit) ? (100) : (Integer.MAX_VALUE);
        return /*(f / */(distance);//) + specialty + seniority));
    }

    public Map<Integer, CzTechnitionSchedule> getTechniciansSchedule() {
        return tecSched;
    }
}
