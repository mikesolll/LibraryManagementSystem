package ui;

import business.CheckOutEntry;
import business.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class CheckOutRecordController {
	@FXML
	private TableView<CheckOutEntry> checkOutTable;
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;

	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label title;
	@FXML
	private Label checkoutDate;
	@FXML
	private Label DueDate;
	@FXML
	private Label Fine;


}
