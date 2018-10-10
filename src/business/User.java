package business;

import java.io.Serializable;

public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1002319741773225608L;
	private Person person;
    private String username;

    private String password;

    public User(Person person,String username, String password){
        this.person=person;
        this.username=username;
        this.password=password;

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
