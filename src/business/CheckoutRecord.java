package business;
import java.util.*;

public class CheckoutRecord {
	private List<CheckOutEntry> entry;
	private LibraryMember member;
	public List<CheckOutEntry> getEntry() {
		return entry;
	}
	public void setEntry(List<CheckOutEntry> entry) {
		this.entry = entry;
	}
	public LibraryMember getMember() {
		return member;
	}
	public void setMember(LibraryMember member) {
		this.member = member;
	}
	
	
	
}
