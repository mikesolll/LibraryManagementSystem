package business;

import java.io.Serializable;

public class BookCopy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1850632322493586658L;
	private String copyNo;
	private boolean availablity;
	private Book book;
	
	BookCopy(String copyNo, Book book) {

		this.copyNo = copyNo;
		this.book = book;
	}

	public String getCopyNo() {
		return copyNo;
	}

	public void setCopyNo(String copyNo) {
		this.copyNo = copyNo;
	}

	public boolean isAvailablity() {
		return availablity;
	}

	public void setAvailablity(boolean availablity) {
		this.availablity = availablity;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "BookCopy [copyNo=" + copyNo + ", availablity=" + availablity + ", book=" + book + "]";
	}
	
	
}
