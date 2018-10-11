package ui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;

import business.AddPersonFactory;
import business.BookCopy;
import business.CheckOutEntry;
import business.LibraryMember;
import business.Person;
import dataaccess.DataAccessFactory;
import dataaccess.VisibilityControl;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;
import util.Storage;

/**
 *
 */
public class CheckOutInController {

	// configure the table
	@FXML
	private TableView<CheckOutEntry> tableView;

	@FXML
	private TableColumn<CheckOutEntry, String> MemberID;
	@FXML
	private TableColumn<CheckOutEntry, String> bookID;
	@FXML
	private TableColumn<CheckOutEntry, LocalDate> checkOutDate;
	@FXML
	private TableColumn<CheckOutEntry, LocalDate> dueDate;

	// These instance variables are used to create new Person objects
	@FXML
	private TextField memberIdTextField;
	@FXML
	private TextField bookIdTextField;
	@FXML private Label l1;

	@FXML
	private Button detailedPersonViewButton;
	public void goHome(ActionEvent event){
		VisibilityControl.navigate("AdminView");
	}

	/**
	 * This method will allow the user to double click on a cell and update the
	 * first name of the person
	 */
	/*
	 * public void changeFirstNameCellEvent(CellEditEvent edittedCell) {
	 * CheckOutEntry personSelected =
	 * tableView.getSelectionModel().getSelectedItem();
	 * personSelected.setFirstName(edittedCell.getNewValue().toString()); } /**
	 * This method will allow the user to double click on a cell and update the
	 * first name of the person
	 */
	/*
	 * public void changeLastNameCellEvent(CellEditEvent edittedCell) { Person
	 * personSelected = tableView.getSelectionModel().getSelectedItem();
	 * personSelected.setLastName(edittedCell.getNewValue().toString()); }
	 * 
	 * 
	 * 
	 * /** This method will enable the detailed view button once a row in the
	 * table is selected
	 */
	//public void userClickedOnTable() {
		//this.detailedPersonViewButton.setDisable(false);
	//}

	/**
	 * When this method is called, it will change the Scene to a TableView
	 * example
	 */
	public void changeScreenButtonPushed(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

	/**
	 * When this method is called, it will pass the selected Person object to a
	 * the detailed view
	 */
	/*
	 * public void changeSceneToDetailedPersonView(ActionEvent event) throws
	 * IOException { FXMLLoader loader = new FXMLLoader();
	 * loader.setLocation(getClass().getResource("PersonView.fxml")); Parent
	 * tableViewParent = loader.load();
	 * 
	 * Scene tableViewScene = new Scene(tableViewParent);
	 * 
	 * //access the controller and call a method PersonViewController controller
	 * = loader.getController();
	 * controller.initData(tableView.getSelectionModel().getSelectedItem());
	 * 
	 * //This line gets the Stage information Stage window =
	 * (Stage)((Node)event.getSource()).getScene().getWindow();
	 * 
	 * window.setScene(tableViewScene); window.show(); }
	 */

	public void initialize() {
		// set up the columns in the table
		preJava8();
		//MemberID.setCellValueFactory(new PropertyValueFactory<CheckOutEntry, String>("MemberId"));
		//bookID.setCellValueFactory(new PropertyValueFactory<CheckOutEntry, String>("bookId"));
		checkOutDate.setCellValueFactory(new PropertyValueFactory<CheckOutEntry, LocalDate>("checkOutDate"));
		dueDate.setCellValueFactory(new PropertyValueFactory<CheckOutEntry, LocalDate>("dueDate"));

		// load dummy data
		tableView.setItems(getEntry());

		// Update the table to allow for the first and last name fields
		// to be editable
		// tableView.setEditable(true);
		// firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		// lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		// This will allow the table to select multiple rows at once
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		// Disable the detailed person view button until a row is selected
		// this.detailedPersonViewButton.setDisable(true);
	}
	private void preJava8() {
		MemberID.setCellValueFactory(new Callback<CellDataFeatures<CheckOutEntry, String>, ObservableValue<String>>() {

			

			@Override
			public ObservableValue<String> call(CellDataFeatures<CheckOutEntry, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().memberIdProperty();
			}
		});

		bookID.setCellValueFactory(new Callback<CellDataFeatures<CheckOutEntry, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<CheckOutEntry, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().bookIdProperty();
			}

			
		});
	}

	/**
	 * This method will remove the selected row(s) from the table
	 */
	public void deleteButtonPushed() {
		ObservableList<CheckOutEntry> selectedRows, allentries;
		allentries = tableView.getItems();

		// this gives us the rows that were selected
		selectedRows = tableView.getSelectionModel().getSelectedItems();

		// loop over the selected rows and remove the Person objects from the
		// table
		for (CheckOutEntry entry : selectedRows) {
			allentries.remove(entry);
		}
	}

	/**
	 * This method will create a new Person object and add it to the table
	 */
	public void newCheckOutEntry() {
		CheckOutEntry newCheckOutEntry = new CheckOutEntry(memberIdTextField.getText(), bookIdTextField.getText(),
				LocalDate.now(), LocalDate.now().plusDays(7));
		

		DataAccessFactory.saveData(Storage.CHECKOUTENTRY.getVal(), bookIdTextField.getText(),newCheckOutEntry);

		tableView.getItems().add(newCheckOutEntry);
	}

	/**
	 * This method will return an ObservableList of People objects
	 */
	public ObservableList<CheckOutEntry> getEntry() {
		ObservableList<CheckOutEntry> checkoutentry = FXCollections.observableArrayList();
		
		HashMap<String,CheckOutEntry> selected= DataAccessFactory.getAllObject("checkoutentry");
        for(CheckOutEntry m:selected.values())
        checkoutentry.add(m);

		return checkoutentry;
	}

}
