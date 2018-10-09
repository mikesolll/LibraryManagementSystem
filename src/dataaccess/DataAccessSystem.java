package dataaccess;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccessSystem<T> implements DataAccess<T> {
    private  String OUTPUT_DIR;
    DataAccessSystem(String directory){
        OUTPUT_DIR=System.getProperty("user.dir")
                +"\\src\\docs\\"+directory+".txt" ;
    }


    public boolean saveObject(T t){
        try{
            FileOutputStream fileOutputStream= new FileOutputStream(OUTPUT_DIR);
            ObjectOutputStream output= new ObjectOutputStream(fileOutputStream);
            output.writeObject(t);
            output.close();
            return true;

        }catch (FileNotFoundException e){
            e.printStackTrace();
            return false;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }


    }

    public T getObject(){
        try {
            FileInputStream fileInputStream= new FileInputStream(new File(OUTPUT_DIR));
            ObjectInputStream input= new ObjectInputStream(fileInputStream);
            T obj= (T) input.readObject();
            input.close();
            return obj;

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> getAllObject() {
        List<T> objects;
        try {
            FileInputStream fileInputStream= new FileInputStream(new File(OUTPUT_DIR));
            ObjectInputStream input= new ObjectInputStream(fileInputStream);


            objects= (List<T>) input.readObject();
            input.close();
            return objects;

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
