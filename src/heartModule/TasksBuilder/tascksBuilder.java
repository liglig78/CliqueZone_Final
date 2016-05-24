package heartModule.TasksBuilder;
import heartModule.Conf;
import heartModule.GeneralTypes.CzTask;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ASUS-PC on 22/05/2016.
 *
 * this class build list of tasked with calculate priority.
 * ### similar tasks combines to "one task"
 */
public class TascksBuilder {

    List<CzTask> taskList = new ArrayList<CzTask>();


    public void sort () {
        Collections.sort(taskList, (c1, c2) -> Double.compare(c1.getTp(), c2.getTp()));
    }
}
