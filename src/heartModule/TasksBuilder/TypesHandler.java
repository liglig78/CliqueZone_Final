package heartModule.TasksBuilder;

import DB.Types.GeneralDBType;
import heartModule.GeneralTypes.CzGeneralType;
import heartModule.GeneralTypes.CzTask;

import java.util.List;
import java.util.Map;

/**
 * Created by Toshiba on 24/05/2016.
 */
public abstract class TypesHandler {
    protected List<? extends GeneralDBType> dbList;

    public TypesHandler(List<? extends GeneralDBType> dbList) {
        this.dbList = dbList;
    }

    public abstract Map<Integer, ? extends CzGeneralType> getAll();
    public abstract void sortAll(List<CzGeneralType> list);

}
