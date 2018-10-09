package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CheckOutEntry implements Serializable {
	private LocalDate dateIssued;
	private LocalDate dueDate;
	private double fine;
	private LocalDate datePaid;
	private BookCopy book;

	CheckOutEntry(LocalDate dateIssued, LocalDate dueDate, double fine, LocalDate datePaid, BookCopy book) {
		
		this.dateIssued = dateIssued;
		this.dueDate = dueDate;
		this.fine = fine;
		this.datePaid = datePaid;
		this.book = book;
	}

	public LocalDate getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(LocalDate dateIssued) {
		this.dateIssued = dateIssued;
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
		return "CheckOutEntry [dateIssued=" + dateIssued + ", dueDate=" + dueDate + ", fine=" + fine + ", datePaid="
				+ datePaid + ", book=" + book + "]";
	}

}
