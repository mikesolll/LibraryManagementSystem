package ui;


import java.io.IOException;



import java.util.HashMap;

import java.util.List;
import java.util.Map;
import business.PersonRole;
import business.User;
import dataaccess.DataAccessFactory;
import dataaccess.Session;
import dataaccess.VisibilityControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


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
			errorMessage.setText("Username or Password is Incorrect!!!");
		}else if(!user.getPassword().equals(password.getText())){
			errorMessage.setText("Username or Password is Incorrect!!!");
		}else {
			Session.currentLogin=user.getPerson().getPersonRole();
			VisibilityControl.navigate("AdminView");
		}
		}
	}
	
