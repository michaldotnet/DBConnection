package pl.edu.wszib.db;


import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.wszib.model.User;

import java.sql.*;


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
            preparedStatement.setString(3, DigestUtils.md5Hex(user.getPassword()));

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static User getUser(String login, String password){
        String sqlSelect = "SELECT * FROM user WHERE login = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = DBConnector.connection.prepareStatement(sqlSelect);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, DigestUtils.md5Hex(password));
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                User userFromDB = new User();
                userFromDB.setId(resultSet.getInt("id"));
                userFromDB.setLogin(resultSet.getString("login"));
                userFromDB.setPassword(resultSet.getString("password"));

                if(userFromDB.getPassword().equals(DigestUtils.md5Hex(password))){
                    return userFromDB;
                }


                return userFromDB;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

}
