package ui;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import business.Adminstrator;
import business.Librarian;
import business.PersonRole;
import business.User;
import dataaccess.DataAccessFactory;
import dataaccess.Session;
import dataaccess.VisibilityControl;
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
	@FXML
	private Label errorMessage;
	
	public void signin(ActionEvent event){
		HashMap<String,User> users= DataAccessFactory.getAllObject(User.class.getSimpleName());
		User user= null;
		PersonRole personRole;
		user=users.get(username.getText());
		if(user==null){
			errorMessage.setText("Username or Password is incorrect");
		}else if(!user.getPassword().equals(password.getText())){
			errorMessage.setText("Username or Password is incorrect");
		}else {
			Session.currentLogin=user.getPerson().getPersonRole();
			VisibilityControl.navigate("AdminView");
		}

		   
		}
	public void loginMethod(){
		VisibilityControl.navigate("Librarian");
		 /*try {
		        FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("/ui/Librarian.fxml"));
		        *//*
		         * if "fx:controller" is not set in fxml
		         * fxmlLoader.setController(NewWindowController);
		         *//*
		        Scene scene = new Scene(fxmlLoader.load(), 487, 596);
		        Stage stage = new Stage();
		        stage.setTitle("New Window");
		        stage.setScene(scene);
		        stage.show();
		    } catch (IOException e) {
		       // Logger logger = Logger.getLogger(getClass().getName());
		        //logger.log(Level.SEVERE, "Failed to create new Window.", e);
		    }*/
		
	}
	}
	
