package pl.edu.wszib.db;


import pl.edu.wszib.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBConnector {
    public static Connection connection = null;
    public static void connect(){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            DBConnector.connection = DriverManager.
                    getConnection("jdbc:mysql://localhost/wszib?user=root&password=");
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void addUser(User user){
        String sql = "INSERT INTO user (id, login, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = DBConnector.connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

}
