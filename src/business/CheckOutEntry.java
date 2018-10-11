package business;

import java.io.Serializable;
import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;


public class CheckOutEntry implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 414058464577082661L;
	private LocalDate checkOutDate;
	private LocalDate dueDate;
	private double fine;
	private LocalDate datePaid;
	private BookCopy book;
	private String memberId;
	private String bookId;
	private String bookTitle;

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	CheckOutEntry(String memberId, String bookId, LocalDate checkOutDate, LocalDate dueDate, String title) {
		this.bookId = bookId;
		this.memberId =  memberId;
		this.checkOutDate = checkOutDate;
		this.dueDate = dueDate;
		bookTitle = title;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutdate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public LocalDate getDatePaid() {
		return datePaid;
	}

	public void setDatePaid(LocalDate datePaid) {
		this.datePaid = datePaid;
	}

	public BookCopy getBook() {
		return book;
	}

	public void setBook(BookCopy book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "CheckOutEntry [dateIssued=" + checkOutDate + ", dueDate=" + dueDate + ", fine=" + fine + ", datePaid="
				+ datePaid + ", book=" + book + "]";
	}
	public ObservableValue<String> memberIdProperty() {
		return new SimpleStringProperty(memberId);
	}
	public ObservableValue<String> bookIdProperty() {
		return new SimpleStringProperty(bookId);
	}
	public ObservableValue<String> titleIdPropery(){
		return new SimpleStringProperty(bookTitle);
	}

}
