package ui;

import business.AddBookFactory;
import business.Book;
import business.BookCopyEntity;
import dataaccess.DataAccess;
import dataaccess.DataAccessFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.ShowMessage;
import util.Storage;

import java.net.URL;
import java.util.*;

public class AddBookCopyController implements Initializable{

    @FXML
    private ComboBox books;

    @FXML
    private TextField CopyNo;

    @FXML
    private Button addCopy;

    public void addCopy(){
        Book book = (Book) books.getValue();
       boolean isAdded= AddBookFactory.addCopy(Integer.parseInt(CopyNo.getText()),book.getIsbn());
       if(isAdded){
           clearValue();
           ShowMessage.success("The copy is Added successfully");
       }else ShowMessage.error("The is error while Adding the book");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HashMap<String, Book> bookHashMap= DataAccessFactory.getAllObject(Storage.BOOK.getVal());
        List<Book> bookEntry= new ArrayList<>(bookHashMap.values());
        books.setPromptText("Select Book");
        books.getItems().addAll(bookEntry);
    }

    private void clearValue(){
       CopyNo.setText("");
    }


}