package ui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import business.*;
import dataaccess.DataAccess;
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
import util.ShowMessage;
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
	private TextField filterMemberId;

	@FXML
	private TableColumn<CheckOutEntry, String> title;

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
		title.setCellValueFactory(new Callback<CellDataFeatures<CheckOutEntry, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<CheckOutEntry, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().titleIdPropery();
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

	public void filterById(){
		if(filterMemberId.getText().length() == 0){
			ShowMessage.error("Invalid","Member ID can not be empty");
		}else {

		ObservableList<CheckOutEntry> allRows;
		allRows = tableView.getItems();
		List<CheckOutEntry> removableList= new ArrayList<>();
		for(CheckOutEntry entry:allRows ){
			if(!entry.getMemberId().equals(filterMemberId.getText())){
				removableList.add(entry);
			}
		}
		if(removableList.size()== allRows.size()){
			ShowMessage.warning("Invalid","Invalid Member Id");
		}else
		allRows.removeAll(removableList);
	}
	}


	public void newCheckOutEntry() {
		if(!checkMember()){
			ShowMessage.error("Member Not Found","The specific member can not be found");
		}else if(!checkBook()){
			ShowMessage.error("Book Not Available","The specific book can not be found or it is unavailable ");
		}
		else {
			HashMap<String ,BookCopyEntity> bookCopyEntityHashMap= DataAccessFactory.getAllObject("bookCopy");
			List<BookCopyEntity> copyEntities= new ArrayList<>(bookCopyEntityHashMap.values());
			String bookCopyId=null;
			for(BookCopyEntity copy: copyEntities){
				if(copy.getISBN().equals(bookIdTextField.getText())){
					if (copy.isAvailablity()){
						bookCopyId= copy.getCopyNo();
						copy.setAvailablity(false);
						bookCopyEntityHashMap.remove(copy.getCopyNo());
						bookCopyEntityHashMap.put(copy.getCopyNo(),copy);
						DataAccessFactory.replaceOnject("bookCopy",bookCopyEntityHashMap);

						break;
					}
				}
			}

			if(bookCopyId == null){
				ShowMessage.error("Book copy Not Found","This book copy is not Available now");

			}else {
				HashMap<String, Book> bookHasMap = DataAccessFactory.getAllObject("book");
				String title = bookHasMap.get(bookIdTextField.getText()).getTitle();
				CheckOutEntry newCheckOutEntry =CheckoutRecordFactory.createCheckoutRecord(memberIdTextField.getText(), bookCopyId,
						LocalDate.now(), LocalDate.now().plusDays(7),title);


				DataAccessFactory.saveData(Storage.CHECKOUTENTRY.getVal(), bookCopyId, newCheckOutEntry);
				memberIdTextField.setText("");
				bookIdTextField.setText("");
				ShowMessage.success("Checkout","Checkout Successfully");
				tableView.getItems().add(newCheckOutEntry);

			}

		}
	}

	private boolean checkBook(){
			HashMap<String , Book> bookHashMap= DataAccessFactory.getAllObject("book");
			Book book= bookHashMap.get(bookIdTextField.getText());
			if (book != null&& book.getNoOfAvailableCopy() > 0){
				book.setNoOfAvailableCopy(book.getNoOfAvailableCopy()-1);
				DataAccessFactory.replaceOnject("book",bookHashMap);
				return true;
			}else return false;

	}
	private boolean checkMember(){
		HashMap<String,Person> members= DataAccessFactory.getAllObject("member");
		Person person= members.get(memberIdTextField.getText());
		return person!=null;
	}
	public ObservableList<CheckOutEntry> getEntry() {
		ObservableList<CheckOutEntry> checkoutentry = FXCollections.observableArrayList();
		
		HashMap<String,CheckOutEntry> selected= DataAccessFactory.getAllObject("checkoutentry");
        for(CheckOutEntry m:selected.values())
        checkoutentry.add(m);

		return checkoutentry;
	}



}
