package FProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    public static Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  

            String url = "jdbc:mysql://localhost:3306/userdata";  
            String user = "root";  
            String password = "password";  

            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;  
        }
    }
}
