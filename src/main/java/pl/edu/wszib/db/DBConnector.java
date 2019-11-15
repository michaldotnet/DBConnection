package pl.edu.wszib.db;


import java.sql.Connection;
import java.sql.DriverManager;
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
}
