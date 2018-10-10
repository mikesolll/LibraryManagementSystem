package business;

import java.io.Serializable;

public class Adminstrator extends PersonRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3111488006687553136L;

	public static  void addMember(Person person,String Id) {
		person.addPersonRole(new LibraryMember(Id));
	}
	public static void editMember(Person prevPerson, Person newPerson) {

		prevPerson.setFirstName(newPerson.getFirstName());
		prevPerson.setLastName(newPerson.getLastName());
		prevPerson.setPhoneNumber(newPerson.getPhoneNumber());

	}
	public static void addBooks() {
		
	}

	@Override
	public PersonRole getPersonRole() {
		// TODO Auto-generated method stub
		return this;
	}

}
