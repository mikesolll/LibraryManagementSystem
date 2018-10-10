package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LibrarianController {
	
	
	@FXML
	private Button bookCheckOutButton;
	@FXML
	private Button CheckOutRecordButton;
	
	public void checkOutRecord(ActionEvent event){
		
	}
	
	public void bookCheckOut(ActionEvent event){
		 try {
		        FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("/ui/CheckOut.fxml"));
		        /* 
		         * if "fx:controller" is not set in fxml
		         * fxmlLoader.setController(NewWindowController);
		         */
		        Scene scene = new Scene(fxmlLoader.load(), 487, 596);
		        Stage stage = new Stage();
		        stage.setTitle("New Window");
		        stage.setScene(scene);
		        stage.show();
		    } catch (IOException e) {
		       // Logger logger = Logger.getLogger(getClass().getName());
		        //logger.log(Level.SEVERE, "Failed to create new Window.", e);
		    }
		
	}
}
