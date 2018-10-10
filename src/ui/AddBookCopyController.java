package ui;

import business.Book;
import dataaccess.DataAccess;
import dataaccess.DataAccessFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
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

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HashMap<String, Book> bookHashMap= DataAccessFactory.getAllObject(Storage.BOOK.getVal());
        List<Book> bookEntry= new ArrayList<>(bookHashMap.values());

        books.getItems().addAll(bookEntry);
    }
}
