package dataaccess;

import business.User;

import java.util.List;

public class Test {

    public static void main(String [] args){


        DataAccess<User> userDataAccess= new DataAccessSystem<User>(User.class.getSimpleName().toLowerCase());
        userDataAccess.saveObject(new User("miek","mieksol"));
        userDataAccess.saveObject(new User("sol", "sol"));
        userDataAccess.saveObject(new User("sol2", "sol"));
        userDataAccess.saveObject(new User("sol3", "sol"));
        userDataAccess.saveObject(new User("sol4", "sol"));

        List<User> users=userDataAccess.getAllObject();
        for (User user: users){
            System.out.println(user.getUsername());
        }
      //  System.out.println(user.getPassword()+ " "+ user.getUsername());




    }
}
