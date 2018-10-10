package ui;

import java.io.IOException;

import dataaccess.VisibilityControl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LibrarianController {
	private Button bookCheckOut;
	private Button CheckOutRecord;
	
	public void bookCheckOut(){
		VisibilityControl.navigate("Checkout");
		
	}
}
