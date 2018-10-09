package dataaccess;

import java.util.HashMap;

public class HashMapStorage<T> {
    private   HashMap<String,T> value;


     HashMapStorage(){
         value= new HashMap<>();
     }

     public T put(String key, T t){
         return value.put(key,t);
     }

     public T get(String key){
         return value.get(key);
     }


}
