package dataaccess;

import java.util.ArrayList;
import java.util.List;
import business.AddPersonFactory;
import business.Person;
import business.User;

public class ExistingUsers {
	ExistingUsers(){
        Person person= AddPersonFactory.newAdmin("Michael","Berhanu","3196140107","1000 N","fierfield","iwoa","23456");
        User user= AddPersonFactory.createUser(person,"mike","mike");

        person = AddPersonFactory.newMember("Andualem","Abebe","0987654321","2000 N","fierfield","iwoa","23456","ab123");
        User user1= AddPersonFactory.createUser(person,"andu","andu");

        person = AddPersonFactory.newLibrarian("Kabinad","Melaku","78772987394","3000 N","fierfield","iwoa","23456");
        User user2= AddPersonFactory.createUser(person,"kab","kab");

        Person person3= AddPersonFactory.newLibrarianAndAdmin("Neba","Girmachew","898689698","4000 N","fierfield","iwoa","23456");
        User user3= new User(person3,"both","both");

        List<User> users= new ArrayList<>();

        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        DataAccessFactory.saveAllData(User.class.getSimpleName(),users);
    }

}
