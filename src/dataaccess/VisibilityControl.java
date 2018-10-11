package dataaccess;

import business.Adminstrator;
import business.Librarian;
import business.PersonRole;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class VisibilityControl {

    private static Stage currentStage=null;


    public static FXMLLoader navigate(String source){
        try{
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(new VisibilityControl().getClass().getResource("/ui/"+source+".fxml"));
            Parent root=loader.load();
            Scene scene= new Scene(root);
            Stage stage= new Stage();
            stage.setScene(scene);
            stage.show();
            if(currentStage !=null) currentStage.hide();
            currentStage=stage;
            return loader;

        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
