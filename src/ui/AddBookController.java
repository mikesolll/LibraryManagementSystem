package ui;

import java.util.Arrays;

import business.AddBookFactory;
import business.AddPersonFactory;
import business.Author;
import dataaccess.VisibilityControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import util.ShowMessage;

public class AddBookController {
	
	@FXML
	private TextField titleText;
	@FXML
	private TextField ISBNText;
	@FXML
	private TextField fNameText;
	@FXML
	private TextField lNameText;
	@FXML
	private TextField phoneNumberText;
	@FXML
	private TextField streetText;
	@FXML
	private TextField cityText;
	@FXML
	private TextField stateText;
	@FXML
	private TextField zipText;
	@FXML
	private TextField credentialText;
	@FXML
	private TextArea shortBioText;
	@FXML
	private Button addBookButton;

	@FXML TextField noOfCopy;
	
	public void addBook(ActionEvent event) {
		
		if(isInputValid()) {
			Author author= AddPersonFactory.newAuthor(fNameText.getText(), lNameText.getText(), 
					phoneNumberText.getText(), streetText.getText(), cityText.getText(), 
					stateText.getText(), zipText.getText(), credentialText.getText(), 
					shortBioText.getText());
			
			boolean isBookAdded=AddBookFactory.addBook(ISBNText.getText(), titleText.getText(),Integer.parseInt(noOfCopy.getText()), Arrays.asList(author));
			boolean isCopyAdded=AddBookFactory.addCopy(noOfCopy.getText(),ISBNText.getText());

			if(isBookAdded && isCopyAdded){
				ShowMessage.success("Book and BookCopy ","Book and Book copy are Added Successfully");
				clearValue();
			}else ShowMessage.error("Book and BookCopy ","There is error while adding");
		}
		
		
	}
	public void goHome(){
		VisibilityControl.navigate("AdminView");
	}

	public void clearValue() {
		lNameText.setText("");

		phoneNumberText.setText("");

		streetText.setText("");

		cityText.setText("");

		stateText.setText("");

		zipText.setText("");

		credentialText.setText("");

		shortBioText.setText("");
		titleText.setText("");
		ISBNText.setText("");
		noOfCopy.setText("");
		fNameText.setText("");
	}
	private boolean isInputValid() {
		String errorMessage = "";

		if (credentialText.getText() == null || credentialText.getText().length() == 0) {
			errorMessage += "Not a valid credential!\n";
		}
		if (shortBioText.getText() == null || shortBioText.getText().length() == 0) {
			errorMessage += "Not a valid shortBio!\n";
		}
		if (titleText.getText() == null || titleText.getText().length() == 0) {
			errorMessage += "Not a valid title!\n";
		}
		if (ISBNText.getText() == null || ISBNText.getText().length() == 0) {
			errorMessage += "Not a valid ISBN number!\n";
		}
		if (noOfCopy.getText() == null || noOfCopy.getText().length() == 0) {
			errorMessage += "Not a valid Number of copy!\n";
		}
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
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}

}
