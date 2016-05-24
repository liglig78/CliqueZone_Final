package heartModule.TasksBuilder;
import heartModule.Conf;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ASUS-PC on 22/05/2016.
 *
 * this class build list of tasked with calculate priority.
 * ### similar tasks combines to "one task"
 */
public class tascksBuilder {

    public double TPFunction (float level, String dueDate, boolean vipCustomer, String creatintionTime) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = format.parse(dueDate);
        Date today = new Date();

        double tp = Math.max((int)level, Math.max((vipCustomer)?1:0, /*Today*/(d1 == today)?1:0)) * Conf.criticalFactor;
        // TODO: Ageing.bhsjhf

        DateTime testlig = new DateTime();


        return tp;
    }

}
