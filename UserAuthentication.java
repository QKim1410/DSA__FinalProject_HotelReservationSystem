package FProject;

import java.sql.*;

public class UserAuthentication {

    public static boolean authenticate(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ?";
        
        try (Connection connection = MySQLConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            // If a user with the email is found
            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");

                // Compare the stored hashed password with the entered password
                if (storedPassword.equals(hashPassword(password))) {
                    return true; // Authentication successful
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Authentication failed
    }

    // Simple hashing method (using SHA-256 or any method you're using)
    private static String hashPassword(String password) {
        // Implement your password hashing logic here (e.g., SHA-256 or bcrypt)
        return password;  // Use proper hashing algorithm here
    }
}
