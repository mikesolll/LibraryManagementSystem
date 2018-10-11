package dataaccess;


import java.util.HashMap;
import java.util.List;

public interface DataAccess<T> {

    boolean saveObject(String key,T t);

    HashMap<String,T> getAllObject();

    boolean saveAllObject(HashMap<String,T> t);

    boolean replaceObject(HashMap<String,T> t);

}
