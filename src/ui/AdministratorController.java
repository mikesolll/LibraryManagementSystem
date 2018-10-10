package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AdministratorController {

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
	public void adminAndLibrarianVisible() {

		adminLabel.setText("Admin & Librarian ");
		addMemberButton.setVisible(true);
		addMemberButton.setVisible(true);
		editMemberButton.setVisible(true);
		checkoutBookButton.setVisible(true);
		checkoutRecordButton.setVisible(true);


	}
	public void adminVisible() {

		adminLabel.setText("Administrator");
		addMemberButton.setVisible(true);
		addMemberButton.setVisible(true);
		editMemberButton.setVisible(true);
		checkoutBookButton.setVisible(false);
		checkoutRecordButton.setVisible(false);


	}
	public void LibrarianVisible() {

		adminLabel.setText("Librarian");
		addMemberButton.setVisible(false);
		addMemberButton.setVisible(false);
		editMemberButton.setVisible(false);
		checkoutBookButton.setVisible(true);
		checkoutRecordButton.setVisible(true);


	}
}
