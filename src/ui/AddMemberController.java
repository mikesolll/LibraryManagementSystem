package ui;



import java.util.List;

import business.AddPersonFactory;
import business.LibraryMember;
import business.Person;
import business.PersonRole;
import dataaccess.DataAccessFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.Storage;

public class AddMemberController {
	
	@FXML
	private Label addMemberlabel;
	@FXML
	private TextField fNameText;
	@FXML
	private TextField lNameText;
	@FXML
	private TextField phoneNumberText;
	@FXML
	private TextField memberIDText;
	@FXML
	private TextField streetText;
	@FXML
	private TextField cityText;
	@FXML
	private TextField stateText;
	@FXML
	private TextField zipText;
	
	
	@FXML
	private Button addMember;
	@FXML
	private Button updateMember; // used to edit members
	private Person person;
	
	/**
	 * Sets the person to be edited in the dialog.
	 *
	 * @param person
	 */
	public void setPerson(Person person) {
		this.person = person;

		fNameText.setText(person.getFirstName());
		lNameText.setText(person.getLastName());
		streetText.setText(person.getAddress().getStreet());
		phoneNumberText.setText(person.getPhoneNumber());
		cityText.setText(person.getAddress().getCity());
		stateText.setText(person.getAddress().getState());
		zipText.setText(person.getAddress().getZip());
		List<PersonRole> list= person.getPersonRole();
		for(PersonRole pr:list) {
			if(pr instanceof LibraryMember) {
				
				memberIDText.setText(((LibraryMember)pr).getMemberID());
				break;
			}
				
		}
		memberIDText.setEditable(false);
		
	}
	
	public void addMember(ActionEvent event) {
		
		Person person=AddPersonFactory.newMember(fNameText.getText(), lNameText.getText(),
				phoneNumberText.getText(), streetText.getText(),cityText.getText(), 
				stateText.getText(), zipText.getText(), memberIDText.getText());

		DataAccessFactory.saveData(Storage.MEMBER.getVal(),memberIDText.getText(),person);
	}
	public void updateMember(ActionEvent event) {

	}
	
	public void setUpdateVisible() {
		addMember.setVisible(false);
		updateMember.setVisible(true);
		addMemberlabel.setText("Edit Member");
	}
	public void addMemberVisible() {
		addMember.setVisible(true);
		updateMember.setVisible(false);
		addMemberlabel.setText("Add Member");
	}
	

}
