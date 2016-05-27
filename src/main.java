import DB.Actions.ReadExcel;
import heartModule.TasksBuilder.TasksHandler;

import java.io.IOException;

/**
 * Created by Toshiba on 24/05/2016.
 */
public class main {
    public static void main(String[] args) throws IOException {

        ReadExcel readExcel = new ReadExcel();
        Thread readExcelThread = new Thread(readExcel);
        readExcelThread.start();

        TasksHandler th = new TasksHandler(readExcel.getTaskList());



    }


}
