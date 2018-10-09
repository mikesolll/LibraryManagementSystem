package dataaccess;

import java.util.List;

public interface DataAccess<T> {

    boolean saveObject(T t);

    T getObject();

    List<T> getAllObject();

}
