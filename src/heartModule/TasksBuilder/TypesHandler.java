package heartModule.TasksBuilder;

import DB.Types.GeneralDBType;
import heartModule.GeneralTypes.CzGeneralType;
import heartModule.GeneralTypes.CzTask;

import java.util.List;

/**
 * Created by Toshiba on 24/05/2016.
 */
public abstract class TypesHandler {
    protected List<GeneralDBType> dbList;

    public TypesHandler(List<? extends GeneralDBType> dbList) {
        this.dbList = (List<GeneralDBType>) dbList;
    }

    public abstract List<CzTask> getAll();
    public abstract void sortAll(List<CzGeneralType> list);

}
