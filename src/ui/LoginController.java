package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class LoginController {
	@FXML
	private Label welcome;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Button signin;
	
	public void signin(ActionEvent event){
		loginMethod();
		   
		}
	public void loginMethod(){
		 try {
		        FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("/ui/Librarian.fxml"));
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
	
