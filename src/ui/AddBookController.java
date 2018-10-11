package ui;

import java.util.Arrays;

import business.AddBookFactory;
import business.AddPersonFactory;
import business.Author;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
		
		Author author= AddPersonFactory.newAuthor(fNameText.getText(), lNameText.getText(), 
				phoneNumberText.getText(), streetText.getText(), cityText.getText(), 
				stateText.getText(), zipText.getText(), credentialText.getText(), 
				shortBioText.getText());
		
		boolean isBookAdded=AddBookFactory.addBook(ISBNText.getText(), titleText.getText(),Integer.parseInt(noOfCopy.getText()), Arrays.asList(author));
		boolean isCopyAdded=AddBookFactory.addCopy(noOfCopy.getText(),ISBNText.getText());

		if(isBookAdded && isCopyAdded){
			ShowMessage.success("Book and Book copy are Added Successfully");
			clearValue();
		}else ShowMessage.error("There is error while added ");
		
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
	}

}
