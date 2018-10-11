package dataaccess;

import java.util.HashMap;

public class DataAccessFactory<T> {
    private DataAccessFactory(){}
    public static<T> boolean saveData(String directory, String key,T t){
        DataAccess<T> dataAccess= new DataAccessSystem<T>(directory);
        return dataAccess.saveObject(key,t);
    }

    public static<T> boolean saveAllData(String directory,HashMap<String,T> tList){
        DataAccess<T> dataAccess= new DataAccessSystem<>(directory);
        return dataAccess.saveAllObject(tList);

    }


    public static <T> HashMap<String,T> getAllObject(String directory){
        DataAccess<T> dataAccess= new DataAccessSystem<>(directory);
        return dataAccess.getAllObject();
    }

    public static <T> boolean replaceOnject(String directory,HashMap<String,T> tList){
        DataAccess<T> dataAccess= new DataAccessSystem<>(directory);
        return dataAccess.replaceObject(tList);
    }
}
