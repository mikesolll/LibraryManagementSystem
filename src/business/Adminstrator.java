package business;

public class Adminstrator extends PersonRole{

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
