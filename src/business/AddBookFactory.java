package business;

import java.util.List;

import dataaccess.DataAccessFactory;

public class AddBookFactory {
	
	private AddBookFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean addBook(String ISBN, String title,List<Author> author) {
		
		Book book= new Book(ISBN,title,author);
		
		return DataAccessFactory.saveData(book.getClass().getSimpleName(), book);
		
		
	}

}
