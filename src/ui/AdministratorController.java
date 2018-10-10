package ui;

import business.Adminstrator;
import business.Librarian;
import business.PersonRole;
import dataaccess.Session;
import dataaccess.VisibilityControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdministratorController implements Initializable{

	@FXML
	private Label adminLabel;
	@FXML
	private Button addMemberButton;
	@FXML
	private Button addBookButton;
	@FXML
	private Button editMemberButton;
	@FXML
	private Button checkoutBookButton;
	@FXML
	private Button checkoutRecordButton;

	@FXML
	private Button logout;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		navigateHome();
	}

	public void addMember(ActionEvent event) {

	}
	public void editMember(ActionEvent event) {

	}
	public void addBooks(ActionEvent event) {

	}
	public void checkoutBook(ActionEvent event) {

	}
	public void checkoutRecord(ActionEvent event) {

	}
	public void logout(ActionEvent event){
		VisibilityControl.navigate("login");
	}
	public void adminAndLibrarianVisible() {

		adminLabel.setText("Admin & Librarian ");
		addMemberButton.setVisible(true);
		addMemberButton.setVisible(true);
		editMemberButton.setVisible(true);
		checkoutBookButton.setVisible(true);
		


	}
	public void adminVisible() {

		adminLabel.setText("Administrator");
		addMemberButton.setVisible(true);
		addBookButton.setVisible(true);
		editMemberButton.setVisible(true);
		checkoutBookButton.setVisible(false);
		


	}
	public void LibrarianVisible() {

		adminLabel.setText("Librarian");
		addMemberButton.setVisible(false);
		addBookButton.setVisible(false);
		editMemberButton.setVisible(false);
		checkoutBookButton.setVisible(true);
		


	}

	public  void navigateHome(){
		boolean isAdmin=false;
		boolean isLib=false;
		List<PersonRole> personRoles= Session.currentLogin;
		for (PersonRole personRole: personRoles){
			if(personRoles.size()>1){
				if(personRole instanceof Adminstrator) isAdmin=true;
				else if(personRole instanceof Librarian) isLib=true;
			}
			else if(personRoles.size() == 1){
				if(personRole instanceof  Adminstrator) adminVisible();

				else  if(personRole instanceof Librarian)LibrarianVisible();
			}
		}
		if(isAdmin && isLib)adminAndLibrarianVisible();
	}


}
