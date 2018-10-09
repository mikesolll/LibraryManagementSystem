package business;

import java.util.List;

public class Book {

	private String isbn;
	private String title;
	private List<Author> author;
	
	Book(String ISBN, String title){
		this.isbn = isbn;
		this.title = title;
		
		
	}
	public String getIsbn(){
		return isbn;
	}
	public void setIsbn(String isbn){
		this.isbn = isbn;
	}
	public String getTitle(){
		return title;
	}
	public String seTitle(){
		this.title = title;
	}
	public List<Author> getAuthor(){
		return author;
	}
	public void addAuthor(Author a){
		author.add(a);
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + "]";
	}
	
}
