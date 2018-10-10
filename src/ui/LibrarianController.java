package ui;

import java.io.IOException;


import dataaccess.VisibilityControl;
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
	
	public void checkOutRecord(){
		VisibilityControl.navigate("CheckOutRecord");
		
	}

	public void bookCheckOut() {
		VisibilityControl.navigate("ExampleOfTableView");

	}
	
	
	
}
