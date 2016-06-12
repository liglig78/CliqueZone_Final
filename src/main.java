import DB.Actions.AddressesConverter;
import DB.Actions.ExcelHandler;
import DB.Actions.ExcelResutWriter;
import heartModule.Conf;
import heartModule.GeneralTypes.CzTask;
import heartModule.GeneralTypes.CzTechnician;
import heartModule.Manager;
import heartModule.TasksBuilder.TasksHandler;
import heartModule.TasksBuilder.TectionitionsHandler;

import java.io.IOException;
import java.util.List;

/**
 * Created by Toshiba on 24/05/2016.
 */
public class main {
    public static void main(String[] args) throws IOException, InterruptedException {

        ExcelHandler readExcel = new ExcelHandler(new AddressesConverter(Conf.googleApiKey));
        Thread readExcelThread = new Thread(readExcel);
        readExcelThread.run();

        readExcelThread.join();

        TasksHandler tasksHandler = new TasksHandler(readExcel.getTaskList());
        List<CzTask> tasks = tasksHandler.getAll();
        TectionitionsHandler tectionitionsHandler = new TectionitionsHandler(readExcel.getTechniciansList());
        List<CzTechnician> technician = tectionitionsHandler.getAll();

        Manager manager = new Manager(technician, tasks);
        manager.setUpHungarian();

        ExcelResutWriter excelResutWriter= new ExcelResutWriter(manager.getTechniciansSchedule());


    }


}
