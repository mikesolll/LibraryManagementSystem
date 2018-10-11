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



	public void changeScreenButtonPushed(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}


	public void initialize() {

		showData();
		checkOutDate.setCellValueFactory(new PropertyValueFactory<CheckOutEntry, LocalDate>("checkOutDate"));
		dueDate.setCellValueFactory(new PropertyValueFactory<CheckOutEntry, LocalDate>("dueDate"));
		tableView.setItems(getEntry());
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}
	private void showData() {
		MemberID.setCellValueFactory(new Callback<CellDataFeatures<CheckOutEntry, String>, ObservableValue<String>>() {

			

			@Override
			public ObservableValue<String> call(CellDataFeatures<CheckOutEntry, String> param) {
				return param.getValue().memberIdProperty();
			}
		});

		bookID.setCellValueFactory(new Callback<CellDataFeatures<CheckOutEntry, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<CheckOutEntry, String> param) {
				return param.getValue().bookIdProperty();
			}

			
		});
	}


	public void deleteButtonPushed() {
		ObservableList<CheckOutEntry> selectedRows, allentries;
		allentries = tableView.getItems();

		selectedRows = tableView.getSelectionModel().getSelectedItems();

		for (CheckOutEntry entry : selectedRows) {
			allentries.remove(entry);
		}
	}

	public void newCheckOutEntry() {
		CheckOutEntry newCheckOutEntry = new CheckOutEntry(memberIdTextField.getText(), bookIdTextField.getText(),
				LocalDate.now(), LocalDate.now().plusDays(7));
		

		DataAccessFactory.saveData(Storage.CHECKOUTENTRY.getVal(), bookIdTextField.getText(),newCheckOutEntry);

		tableView.getItems().add(newCheckOutEntry);
	}

	public ObservableList<CheckOutEntry> getEntry() {
		ObservableList<CheckOutEntry> checkoutentry = FXCollections.observableArrayList();
		
		HashMap<String,CheckOutEntry> selected= DataAccessFactory.getAllObject("checkoutentry");
        for(CheckOutEntry m:selected.values())
        checkoutentry.add(m);

		return checkoutentry;
	}

}
