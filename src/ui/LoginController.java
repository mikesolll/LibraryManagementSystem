package ui;

import java.io.IOException;
import java.util.List;

import business.Adminstrator;
import business.Librarian;
import business.PersonRole;
import business.User;
import dataaccess.DataAccessFactory;
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
		List<User> users= DataAccessFactory.getAllObject(User.class.getSimpleName());
		User user= null;
		for (User u: users){
			if (u.getUsername().equals(username.getText())){
				user=u;
				break;
			}
		}
		if(user==null){
			errorMessage.setText("Username or Password is incorrect");
		}else if(!user.getPassword().equals(password.getText())){
			errorMessage.setText("Username or Password is incorrect");
		}else {
			List<PersonRole> personRoles= user.getPerson().getPersonRole();
			if(personRoles.size()==1){
				PersonRole personRole=personRoles.get(0).getPersonRole();
				if(personRole instanceof Adminstrator) {
					System.out.println("Adminstrator");
				}
				else if(personRole instanceof Librarian)loginMethod();
			} else if(personRoles.size() > 1){
				boolean isAdmin=false;
				boolean isLin=false;
				PersonRole personRole;
				for (PersonRole p: personRoles){
					personRole=p.getPersonRole();
					if(p.getPersonRole() instanceof Adminstrator) {
						isAdmin=true;
						continue;
					}
					if (personRole instanceof Librarian) isLin=true;

				}
				if(isAdmin && isLin) System.out.println("Both");
			}
		}

		   
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
	
