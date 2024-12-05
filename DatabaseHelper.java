package FProject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/userdata";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static int insertBookingDetails(java.sql.Date checkInDate, java.sql.Date checkOutDate, int numNights, int userId) {
        String query = "INSERT INTO bookings (check_in_date, check_out_date, num_nights, user_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = MySQLConnection.connect();
             PreparedStatement pstmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setDate(1, checkInDate);  // Set check-in date
            pstmt.setDate(2, checkOutDate); // Set check-out date
            pstmt.setInt(3, numNights);     // Set number of nights
            pstmt.setInt(4, userId);        // Set user ID

            pstmt.executeUpdate();

            // Get the generated booking ID
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int bookingId = generatedKeys.getInt(1);
                    System.out.println("Booking details saved successfully with booking ID: " + bookingId);
                    return bookingId;  // Return the generated booking ID
                } else {
                    throw new SQLException("Failed to obtain booking ID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // Return an invalid booking ID if error occurs
        }
    
    }

    
	public static void insertRates(int roomId, String roomType, int roomQuantity) {
	    String sql = "INSERT INTO rates (room_type, room_quantity) VALUES (?, ?)";

	    try (Connection conn = MySQLConnection.connect();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            // Print the SQL being executed for debugging
	            System.out.println("Executing SQL: " + sql);
	            
	            stmt.setString(1, roomType); // Room type: "Deluxe Room"
	            stmt.setInt(2, roomQuantity);    // Room count: 2

	            // Execute the update and log the number of affected rows
	            int rowsAffected = stmt.executeUpdate();
	            System.out.println("Rows affected: " + rowsAffected);

	            if (rowsAffected > 0) {
	                System.out.println("Room booking successfully inserted.");
	            } else {
	                System.out.println("Failed to insert room booking.");
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace(); // This will print any error message if it occurs
	        }
	}
}
