package FProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UserRegistration {

	public static boolean registerUser(String email, String firstName, String lastName, String passwordText, String contactNumber) {
        try (Connection connection = MySQLConnection.connect()) {
            String sql = "INSERT INTO users (email, first_name, last_name, password, contact_number) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                statement.setString(2, firstName);
                statement.setString(3, lastName);
                statement.setString(4, passwordText); 
                statement.setString(5, contactNumber);

                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    return true;  
                } else {
                    return false;  
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error while registering user: " + e.getMessage());
            return false;
        }
    }
    

    // Simple hashing method (you should use a stronger hash algorithm like BCrypt in production)
    private static String hashPassword(char[] password) {
        // Example using SHA-256 (it's better to use a stronger hash like BCrypt or Argon2 in production)
        StringBuilder sb = new StringBuilder();
        for (char c : password) {
            sb.append(Integer.toHexString((int) c));
        }
        return sb.toString();
    }
}
