package business;

import java.util.HashMap;
import java.util.List;


import dataaccess.DataAccessFactory;
import util.Storage;

public class AddBookFactory {
	
	private AddBookFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean addBook(String ISBN, String title,Integer NoOfAvailableCopy,List<Author> author) {
		
		Book book= new Book(ISBN,title,NoOfAvailableCopy,author);
		
		return DataAccessFactory.saveData(Storage.BOOK.getVal(),book.getIsbn(), book);
		
		
	}

	public static boolean addCopy(String NoOfCopy,String ISBN){
		BookCopyEntity copyEntity;
		Integer noOfCopy=Integer.parseInt(NoOfCopy);
		HashMap<String,BookCopyEntity> copies= new HashMap<>();
		for (Integer i=1; i<=noOfCopy; i++){
			copyEntity=new BookCopyEntity(ISBN+"_"+i.toString(),ISBN,true);
			copies.put(ISBN+"_"+i,copyEntity);
		}

		return DataAccessFactory.saveAllData(Storage.BOOKCOPY.getVal(),copies);

	}

	public static boolean addCopy(Integer copyNo,String ISBN){
		BookCopyEntity copyEntity;
		HashMap<String,Book> books = DataAccessFactory.getAllObject(Storage.BOOK.getVal());
		Book book= books.get(ISBN);
		if(book != null){
			book.setNoOfAvailableCopy(book.getNoOfAvailableCopy()+1);
			copyEntity= new BookCopyEntity(ISBN+"_"+copyNo,ISBN,true);
			books.remove(ISBN);
			books.put(ISBN,book);
			DataAccessFactory.replaceOnject(Storage.BOOK.getVal(),books);
		return 	DataAccessFactory.saveData(Storage.BOOKCOPY.getVal(),ISBN+"_"+copyNo,copyEntity);
		}
		return false;
	}

}
