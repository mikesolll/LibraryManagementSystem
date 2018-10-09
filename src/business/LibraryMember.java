package business;

public class LibraryMember extends PersonRole{

	private String memberID;
	private CheckoutRecord checkoutPaper;
	public LibraryMember(String memberID) {
		// TODO Auto-generated constructor stub
		this.memberID=memberID;
	}
	public CheckoutRecord getCheckoutPaper() {
		return checkoutPaper;
	}
	public void setCheckoutPaper(CheckoutRecord checkoutPaper) {
		this.checkoutPaper = checkoutPaper;
	}
	public String getMemberID() {
		return memberID;
	}
	
	@Override
	public PersonRole getPersonRole() {
		// TODO Auto-generated method stub
		return this;
	}

}
