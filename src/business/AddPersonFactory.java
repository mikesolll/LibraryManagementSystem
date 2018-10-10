package business;


public class AddPersonFactory {

	private AddPersonFactory() {
		// TODO Auto-generated constructor stub
	}

	public static Person newMember(String firstName, String lastName,String phoneNumber,
			String street, String city, String state, String zip,String memberID) {
		Person person= createPerson(firstName, lastName, phoneNumber, street, city, state, zip);
		person.addPersonRole(new LibraryMember(memberID));
		return person;

	}
	public static Person newAdmin(String firstName, String lastName,String phoneNumber,
			String street, String city, String state, String zip) {
		Person person= createPerson(firstName, lastName, phoneNumber, street, city, state, zip);
		person.addPersonRole(new Adminstrator());
		return person;

	}
	public static Person newLibrarian(String firstName, String lastName,String phoneNumber,
			String street, String city, String state, String zip) {
		Person person= createPerson(firstName, lastName, phoneNumber, street, city, state, zip);
		person.addPersonRole(new Librarian());
		return person;

	}
	public static Person newLibrarianAndAdmin(String firstName, String lastName,String phoneNumber,
			String street, String city, String state, String zip) {
		Person person= createPerson(firstName, lastName, phoneNumber, street, city, state, zip);
		person.addPersonRole(new Librarian());
		person.addPersonRole(new Adminstrator());
		return person;

	}
	public static User createUser(Person person,String username,String password) {

		User user= new User(person,username,password);
		return user;

	}
	public static Author newAuthor(String firstName, String lastName,String phoneNumber,
			String street, String city, String state, String zip,String credential,String shortBio) {

		Author author= new Author(firstName, lastName, phoneNumber,credential,shortBio,new Address(street,city,state,zip));

		return author;
	}

	private static Person createPerson(String firstName, String lastName,String phoneNumber,String street, String city, String state, String zip) {

		return new Person(firstName,lastName,phoneNumber,new Address(street,city,state,zip));

	}

}
