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
		/*try {
			Parent root = FXMLLoader.load(getClass().getResource("/ui/Login.fxml"));
			Scene scene = new Scene(root,487,596);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
		//new ExistingUsers();
		VisibilityControl.navigate("AddBookCopy");
	}
	


    
	

}
