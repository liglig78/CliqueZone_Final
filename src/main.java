import DB.Actions.AddressesConverter;
import DB.Actions.ExcelHandler;
import heartModule.Conf;
import heartModule.TasksBuilder.TasksHandler;
import heartModule.TasksBuilder.TectionitionsHandler;

import java.io.IOException;

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
        tasksHandler.getAll();
        TectionitionsHandler tectionitionsHandler = new TectionitionsHandler(readExcel.getTechniciansList());
        tectionitionsHandler.getAll();



    }


}
