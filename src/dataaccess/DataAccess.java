package dataaccess;


import java.util.List;

public interface DataAccess<T> {

    boolean saveObject(T t);

    List<T> getAllObject();

    boolean saveAllObject(List<T> t);

}
