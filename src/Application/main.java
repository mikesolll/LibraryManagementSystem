package Application;

import dataaccess.ExistingUsers;
import dataaccess.VisibilityControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// If the user is not unavailable uncomment the next line
		// It insert three main users
		//new ExistingUsers();
		VisibilityControl.navigate("Login");
	}
	


    
	

}
