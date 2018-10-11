package ui;




import java.util.List;


import business.AddPersonFactory;
import business.LibraryMember;
import business.Person;
import business.PersonRole;
import dataaccess.DataAccessFactory;
import dataaccess.VisibilityControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import util.ShowMessage;
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

		setUpdateVisible();

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

	public void homeButton(ActionEvent event) {
		VisibilityControl.navigate("AdminView");

	} 
	public void addMember(ActionEvent event) {

		if(isInputValid()) {
			Person person=AddPersonFactory.newMember(fNameText.getText(), lNameText.getText(),
					phoneNumberText.getText(), streetText.getText(),cityText.getText(), 
					stateText.getText(), zipText.getText(), memberIDText.getText());

			boolean memberAdded=
					DataAccessFactory.saveData(Storage.MEMBER.getVal(),memberIDText.getText(),person);
			if(memberAdded){
				ShowMessage.success("Member ","Member Added Successfully");
				clearValue();
			}else ShowMessage.error("Member ","There is an error while adding Member");
		}
			

	}




	public void setUpdateVisible() {
		addMember.setText("Update");;
		addMemberlabel.setText("Edit Member");
	}
	public void addMemberVisible() {
		addMember.setText("Add");
		addMemberlabel.setText("Add Member");
	}

	public void clearValue() {
		fNameText.setText("");
		lNameText.setText("");
		phoneNumberText.setText("");
		memberIDText.setText("");
		streetText.setText("");
		cityText.setText("");
		stateText.setText("");
		zipText.setText("");
	}
	private boolean isInputValid() {
		String errorMessage = "";

		if (fNameText.getText() == null || fNameText.getText().length() == 0) {
			errorMessage += "Not a valid first name!\n";
		}
		if (lNameText.getText() == null || lNameText.getText().length() == 0) {
			errorMessage += "Not a valid last name!\n";
		}
		if (streetText.getText() == null || streetText.getText().length() == 0) {
			errorMessage += "Not a valid street!\n";
		}

		if (phoneNumberText.getText() == null || phoneNumberText.getText().length() == 0) {
			errorMessage += "Not a valid Phone Number!\n";
		}
		if (cityText.getText() == null || cityText.getText().length() == 0) {
			errorMessage += "Not a valid city!\n";
		}

		if (stateText.getText() == null || stateText.getText().length() == 0) {
			errorMessage += "Not a valid state!\n";
		} 
		if (zipText.getText() == null || zipText.getText().length() == 0) {
			errorMessage += "Not a valid Zip!\n";
		} 

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			//alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}


}
