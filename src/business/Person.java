package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3667918884957155950L;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Address address;
	private List<PersonRole> personRole;
	//Package level
	 Person(String firstName, String lastName,String phoneNumber,Address address) {
		// TODO Auto-generated constructor stub
		this.firstName=firstName;
		this.lastName=lastName;
		this.phoneNumber=phoneNumber;
		personRole= new ArrayList<>();
		this.address=address;
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Address getAddress() {
		return address;
	}
	public List<PersonRole> getPersonRole() {
		return personRole;
	}
	public void addPersonRole(PersonRole Role) {
		personRole.add(Role);
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + 
				", lastName=" + lastName +
				", phoneNumber=" + phoneNumber + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	public ObservableValue<String> firstNameProperty() {
		// TODO Auto-generated method stub
		return new SimpleStringProperty(firstName);
	}
	public ObservableValue<String> lastNameProperty() {
		// TODO Auto-generated method stub
		return new SimpleStringProperty(lastName);
	} 
	
}
