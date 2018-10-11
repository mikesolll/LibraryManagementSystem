package ui;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import business.CheckOutEntry;
import business.Person;
import dataaccess.DataAccessFactory;
import dataaccess.VisibilityControl;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;





public class MemberListController{
	//configure the table
	@FXML
	private TableView<Person> personTable;
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;
	//These instance variables are used to create new Person objects
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label streetLabel;
	@FXML
	private Label cityLabel;
	@FXML
	private Label ZipLabel;
	@FXML
	private Label phoneNumberLabel;
	@FXML
	private Label stateLabel;

	public MemberListController(){

	}
	public void handleHomeButton() {
		VisibilityControl.navigate("AdminView");

	}
	public void handleEditPerson() {


		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
		if (selectedPerson != null) {
			AddMemberController controller= VisibilityControl.navigate("AddMemberView").getController();
			controller.setPerson(selectedPerson);

		}

		else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}

	}

	/**
	 * Initializes the controller class.
	 */
	@FXML
	private void initialize() {

		showTable();
		// Clear person details.
		showPersonDetails(null);
		personTable.setItems(getPeople());
		


		personTable.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
		
		
	}
	private void showTable() {
		firstNameColumn.setCellValueFactory(new Callback<CellDataFeatures<Person, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Person, String> param) {
				return param.getValue().firstNameProperty();
			}
		});

		lastNameColumn.setCellValueFactory(new Callback<CellDataFeatures<Person, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Person, String> param) {
				return param.getValue().lastNameProperty();
			}
		});
	}
	private void showPersonDetails(Person person) {
		if (person != null) {
			// Fill the labels with info from the person object.
			firstNameLabel.setText(person.getFirstName());
			lastNameLabel.setText(person.getLastName());
			phoneNumberLabel.setText(person.getPhoneNumber());
			streetLabel.setText(person.getAddress().getStreet());
			cityLabel.setText(person.getAddress().getCity());
			ZipLabel.setText(person.getAddress().getZip());
			stateLabel.setText(person.getAddress().getState());


		} else {
			// Person is null, remove all the text.
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			phoneNumberLabel.setText("");
			streetLabel.setText("");
			cityLabel.setText("");
			ZipLabel.setText("");
			stateLabel.setText("");



		}
	}


	public ObservableList<Person>  getPeople()
	{
		ObservableList<Person> people = FXCollections.observableArrayList();

		HashMap<String,Person> selected= DataAccessFactory.getAllObject("member");
		for(Person m:selected.values())
			people.add(m);


		return people;
	}



}
