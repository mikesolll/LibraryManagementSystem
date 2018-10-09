package dataaccess;





import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccessSystem<T> implements DataAccess<T> {
    private  String OUTPUT_DIR;
    FileOutputStream fileOutputStream;
    ObjectOutputStream outputStream;
    FileInputStream fileInputStream;
    ObjectInputStream input;
    List<T> lists= new ArrayList<>();

    DataAccessSystem(String directory){
        OUTPUT_DIR=System.getProperty("user.dir")
                +"\\src\\docs\\"+directory+".txt" ;


    }


    public boolean saveObject(T t)  {
        try{
            fileOutputStream= new FileOutputStream(OUTPUT_DIR);
            outputStream= new ObjectOutputStream(fileOutputStream);
            lists.add(t);
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
    /*public class AppendingObjectOutputStream extends ObjectOutputStream {

        public AppendingObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            // do not write a header, but reset:
            // this line added after another question
            // showed a problem with the original
            reset();
        }

    }*/
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
