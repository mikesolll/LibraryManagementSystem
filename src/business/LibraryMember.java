package business;

import java.io.Serializable;

public class LibraryMember extends PersonRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7159469442297205352L;
	private String memberID;
	private CheckoutRecord checkoutPaper;
	//package level
	 LibraryMember(String memberID) {
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
