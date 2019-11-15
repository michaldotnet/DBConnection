package pl.edu.wszib;

import pl.edu.wszib.db.DBConnector;
import pl.edu.wszib.model.User;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args){
        DBConnector.connect();
        User user = new User();
        user.setId(2);
        user.setLogin("mojlogin2");
        user.setPassword("mojehaslo2");
        //DBConnector.addUser(user);

        User userFromDb = DBConnector.getUser("mojLogin2", "mojehaslo2");
        System.out.println(userFromDb);

    }
}
