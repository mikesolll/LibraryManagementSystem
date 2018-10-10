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
		
		AddBookFactory.addBook(ISBNText.getText(), titleText.getText(),Integer.parseInt(noOfCopy.getText()), Arrays.asList(author));
		AddBookFactory.addCopy(noOfCopy.getText(),ISBNText.getText());
		
	}

}
