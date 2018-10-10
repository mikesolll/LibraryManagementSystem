package business;

import java.io.Serializable;
import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;


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
	private SimpleStringProperty memberId;
	private SimpleStringProperty bookId;

	public CheckOutEntry(String memberId, String bookId,LocalDate checkOutDate, LocalDate dueDate, LocalDate datePaid, BookCopy book) {
		this.bookId = new SimpleStringProperty(bookId);
		this.memberId = new SimpleStringProperty (memberId);
		this.checkOutDate = checkOutDate;
		this.dueDate = dueDate;
		//this.fine = fine;
		this.datePaid = datePaid;
		this.book = book;
	}

	public CheckOutEntry(String memberId, String bookId, LocalDate checkOutDate, LocalDate dueDate) {
		this.bookId = new SimpleStringProperty(bookId);
		this.memberId = new SimpleStringProperty (memberId);
		this.checkOutDate = checkOutDate;
		this.dueDate = dueDate;
	}

	public String getMemberId() {
		return memberId.get();
	}

	public void setMemberId(SimpleStringProperty memberId) {
		this.memberId = memberId;
	}

	public String getBookId() {
		return bookId.get();
	}

	public void setBookId(SimpleStringProperty bookId) {
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

}
