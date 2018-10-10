package business;

import java.util.HashMap;
import java.util.List;

import dataaccess.DataAccess;
import dataaccess.DataAccessFactory;

public class AddBookFactory {
	
	private AddBookFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean addBook(String ISBN, String title,List<Author> author) {
		
		Book book= new Book(ISBN,title,author);
		
		return DataAccessFactory.saveData(book.getClass().getSimpleName(),book.getIsbn(), book);
		
		
	}

	public static boolean addCopy(String NoOfCopy,String ISBN){
		BookCopyEntity copyEntity;
		Integer noOfCopy=Integer.parseInt(NoOfCopy);
		HashMap<String,BookCopyEntity> copies= new HashMap<>();
		for (Integer i=1; i<=noOfCopy; i++){
			copyEntity=new BookCopyEntity(i.toString(),ISBN,true);
			copies.put(ISBN+"_"+i,copyEntity);
		}

		return DataAccessFactory.saveAllData("bookCopy",copies);

	}

}
