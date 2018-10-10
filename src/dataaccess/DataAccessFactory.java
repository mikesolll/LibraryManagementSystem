package dataaccess;

import javax.xml.crypto.Data;
import java.util.List;

public class DataAccessFactory<T> {
    private DataAccessFactory(){}
    public static<T> boolean saveData(String directory,T t){
        DataAccess<T> dataAccess= new DataAccessSystem<T>(directory);
        return dataAccess.saveObject(t);
    }

    public static<T> boolean saveAllData(String directory,List<T> tList){
        DataAccess<T> dataAccess= new DataAccessSystem<>(directory);
        return dataAccess.saveAllObject(tList);

    }


    public static <T> List<T> getAllObject(String directory){
        DataAccess<T> dataAccess= new DataAccessSystem<>(directory);
        return dataAccess.getAllObject();
    }
}
