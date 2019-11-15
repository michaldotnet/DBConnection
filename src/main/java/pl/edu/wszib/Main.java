package pl.edu.wszib;

import pl.edu.wszib.db.DBConnector;
import pl.edu.wszib.model.User;

public class Main {
    public static void main(String[] args){
        DBConnector.connect();
        User user = new User();
        user.setId(1);
        user.setLogin("mojlogin");
        user.setPassword("mojehaslo");
        DBConnector.addUser(user);

    }
}
