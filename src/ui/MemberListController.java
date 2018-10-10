package ui;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import business.Person;
import dataaccess.DataAccessFactory;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
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
		
		//showPersonDetails(null);
		//personTable.setItems(getPeople());
	}
	public void handleEditPerson() {
		
		
		
	}
	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
//		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
//		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

		preJava8();
		// Clear person details.
		personTable.setItems(getPeople());
		//showPersonDetails(null);

		// Listen for selection changes and show the person details when
		// changed.
		personTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));

	}
	private void preJava8() {
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

			// TODO: We need a way to convert the birthday into a String!
			// birthdayLabel.setText(...);
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
	/**
     * Initializes the controller class.
     */
/*
    public void initialize() {
        //set up the columns in the table
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
       
        
        //load dummy data
        personTable.setItems(getPeople());
        
        //Update the table to allow for the first and last name fields
        //to be editable
        //personTable.setEditable(true);
        //firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //This will allow the table to select multiple rows at once
       // personTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        //Disable the detailed person view button until a row is selected
        //this.detailedPersonViewButton.setDisable(true);
    }*/
    public ObservableList<Person>  getPeople()
    {
        ObservableList<Person> people = FXCollections.observableArrayList();
        
        HashMap<String,Person> selected= DataAccessFactory.getAllObject("member");
        for(Person m:selected.values())
        people.add(m);
       // people.add(new Person("Frank","Sinatra",LocalDate.of(1915, Month.DECEMBER, 12), new Image("FrankSinatra.jpg")));
        //people.add(new Person("Rebecca","Fergusson",LocalDate.of(1986, Month.JULY, 21)));
        //people.add(new Person("Mr.","T",LocalDate.of(1952, Month.MAY, 21)));
        
        return people;
    }
	


}
