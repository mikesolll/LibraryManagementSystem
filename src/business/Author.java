package business;

public class Author extends Person{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 754302951007735550L;
	private String credential;
	private String shortBio;

	Author(String firstName, String lastName, String phoneNumber,String credentials,String shortBio) {
		super(firstName, lastName, phoneNumber);
		// TODO Auto-generated constructor stub
		this.credential=credentials;
		this.shortBio=shortBio;
	}
	public String getCredential() {
		return credential;
	}
	public String getShortBio() {
		return shortBio;
	}

}
