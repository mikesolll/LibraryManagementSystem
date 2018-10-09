package business;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable{

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

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
