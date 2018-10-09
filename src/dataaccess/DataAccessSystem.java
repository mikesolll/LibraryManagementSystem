package dataaccess;





import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataAccessSystem<T> implements DataAccess<T> {
    private  String OUTPUT_DIR;
    FileOutputStream fileOutputStream;
    ObjectOutputStream outputStream;
    List<T> lists= new ArrayList<>();

    DataAccessSystem(String directory){
        OUTPUT_DIR=System.getProperty("user.dir")
                +"\\src\\docs\\"+directory+".txt" ;


    }


    public boolean saveObject(T t)  {
        List<T> list= new ArrayList<>();
        list.add(t);
        return saveAllObject(list);
    }

    public boolean saveAllObject(List<T>  tList){

        try{
            lists.addAll(tList);
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

    @Override
    public List<T> getAllObject() {
        List<T> objects= new ArrayList<>();
        boolean isEmpty=false;
               try{

                  FileInputStream fileInputStream= new FileInputStream(new File(OUTPUT_DIR));
                  ObjectInputStream input= new ObjectInputStream(fileInputStream);

                   objects=(List<T>) input.readObject();
               }catch (Exception e){
                   e.printStackTrace();
               }

               return objects;

    }
}
