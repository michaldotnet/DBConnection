package pl.edu.wszib;

import pl.edu.wszib.db.DBConnector;
import pl.edu.wszib.model.User;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args){
        DBConnector.connect();
        User user = new User();
        user.setId(1);
        user.setLogin("mojlogin");
        user.setPassword("mojehaslo");
       // DBConnector.addUser(user);

        User userFromDb = DBConnector.getUser("mojLogin", "mojeHaslo");
        System.out.println(userFromDb);

    }
}
