package dataaccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import business.AddPersonFactory;
import business.Person;
import business.User;

public class ExistingUsers {
	public ExistingUsers(){
        Person person= AddPersonFactory.newAdmin("Michael","Berhanu","3196140107","1000 N","fierfield","iwoa","23456");
        User user= AddPersonFactory.createUser(person,"mike","mike");

        person = AddPersonFactory.newMember("Andualem","Abebe","0987654321","2000 N","fierfield","iwoa","23456","ab123");
        User user1= AddPersonFactory.createUser(person,"andu","andu");

        person = AddPersonFactory.newLibrarian("Kabinad","Melaku","78772987394","3000 N","fierfield","iwoa","23456");
        User user2= AddPersonFactory.createUser(person,"kab","kab");

        Person person3= AddPersonFactory.newLibrarianAndAdmin("Neba","Girmachew","898689698","4000 N","fierfield","iwoa","23456");
        User user3= new User(person3,"both","both");

            HashMap<String, User> users= new HashMap<>();

        users.put(user.getUsername(),user);
        users.put(user1.getUsername(),user1);
        users.put(user2.getUsername(),user2);
        users.put(user3.getUsername(),user3);
        DataAccessFactory.saveAllData(User.class.getSimpleName(),users);
    }

}
