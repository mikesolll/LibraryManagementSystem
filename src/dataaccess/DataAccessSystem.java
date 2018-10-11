package dataaccess;





import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DataAccessSystem<T> implements DataAccess<T> {
    private  String OUTPUT_DIR;
    FileOutputStream fileOutputStream;
    ObjectOutputStream outputStream;
    HashMap<String,T> lists= new HashMap<>();

    DataAccessSystem(String directory){
        OUTPUT_DIR=getClass().getClassLoader().getResource("docs/"+directory+".txt").getPath();
    }


    public boolean saveObject(String key,T t)  {
        HashMap<String,T> value= new HashMap<>();
        value.put(key,t);
        return saveAllObject(value);
    }

    public boolean saveAllObject(HashMap<String,T>  tList){

        lists=getAllObject();
        lists.putAll(tList);
        return replaceObject(tList);


    }

    @Override
    public HashMap<String,T> getAllObject() {
        HashMap<String,T> values= new HashMap<>();
        boolean isEmpty=false;
               try{

                  FileInputStream fileInputStream= new FileInputStream(new File(OUTPUT_DIR));
                  ObjectInputStream input= new ObjectInputStream(fileInputStream);

                   values=(HashMap<String,T>) input.readObject();
               }catch (Exception e){
                   e.printStackTrace();
               }

               return values;

    }

    @Override
    public boolean replaceObject(HashMap<String, T> t) {
        try{
            lists.putAll(t);
            fileOutputStream= new FileOutputStream(OUTPUT_DIR);
            outputStream= new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(lists);
            outputStream.close();
            return true;

        }catch (FileNotFoundException e){
            e.printStackTrace();
            return false;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }

    }
}
