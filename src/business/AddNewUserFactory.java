package business;


import dataaccess.DataAccessFactory;


import java.util.ArrayList;
import java.util.List;

public class AddNewUserFactory {

    private AddNewUserFactory(){}

    public static void newUser(){

        Person person= new Person("Michael","Berhanu","3196140107");
        person.addPersonRole(new Adminstrator());
        person.setAddress(new Address("1000 N","fierfield","iwoa","23456"));
        User user= new User(person,"mike","mike");

        Person person1 = new Person("Andualem","Abebe","0987654321");
        person1.addPersonRole(new LibraryMember("ab123"));
        person1.setAddress(new Address("2000 N","fierfield","iwoa","23456"));
        User user1= new User(person1,"andu","andu");

        Person person2 = new Person("Kabinad","Melaku","78772987394");
        person2.addPersonRole(new Librarian());
        person2.setAddress(new Address("3000 N","fierfield","iwoa","23456"));
        User user2= new User(person2,"kab","kab");

        Person person3= new Person("Both","User","897898689698");
        person3.addPersonRole(new Adminstrator());
        person3.addPersonRole(new Librarian());
        person3.setAddress(new Address("4000 N","fierfield","iwoa","23456"));
        User user3= new User(person3,"both","both");

        List<User> users= new ArrayList<>();

        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        DataAccessFactory.saveAllData(User.class.getSimpleName(),users);

    }
}
