package FProject;

import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class admin_dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTable table_data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_dashboard frame = new admin_dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public admin_dashboard() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1252, 533);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton display = new JButton("Display Users");
		display.setBackground(new Color(255, 255, 255));
		display.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "password");
		            Statement st = con.createStatement();
		            String sql = "SELECT * FROM users";
		            ResultSet rs = st.executeQuery(sql);
		            ResultSetMetaData rsmd = rs.getMetaData();
		            DefaultTableModel model = (DefaultTableModel) table_data.getModel();

		            // Clear existing rows in the table
		            model.setRowCount(0);

		            // Get column names dynamically from the ResultSetMetaData
		            int cols = rsmd.getColumnCount();
		            String[] colName = new String[cols];
		            for (int i = 0; i < cols; i++) {
		                colName[i] = rsmd.getColumnName(i + 1); // Column indices start from 1
		            }
		            model.setColumnIdentifiers(colName); // Set column names in the table model

		            // Read rows dynamically based on the column count
		            while (rs.next()) {
		                String[] row = new String[cols];
		                for (int i = 0; i < cols; i++) {
		                    row[i] = rs.getString(i + 1); // Retrieve each column's value
		                }
		                model.addRow(row); // Add the row to the table model
		            }

		            st.close();
		            con.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});

		display.setFont(new Font("Tahoma", Font.BOLD, 15));
		display.setBounds(614, 441, 140, 27);
		contentPane.add(display);
		
		JButton clear = new JButton("Clear");
		clear.setBackground(new Color(255, 255, 255));
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_data.setModel(new DefaultTableModel());
			}
		});
		clear.setFont(new Font("Tahoma", Font.BOLD, 15));
		clear.setBounds(1088, 441, 82, 27);
		contentPane.add(clear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(269, 90, 934, 341);
		contentPane.add(scrollPane);
		
		table_data = new JTable();
		scrollPane.setViewportView(table_data);
		table_data.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(247, 233, 98));
		panel.setBounds(0, 0, 1238, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN DASHBOARD");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 20, 234, 13);
		panel.add(lblNewLabel_1);
		
		JButton btnDisplayRates = new JButton("Display Rates");
		btnDisplayRates.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "password");
		            Statement st = con.createStatement();
		            String sql = "SELECT * FROM rates";
		            ResultSet rs = st.executeQuery(sql);
		            ResultSetMetaData rsmd = rs.getMetaData();
		            DefaultTableModel model = (DefaultTableModel) table_data.getModel();

		            model.setRowCount(0); // Clear existing rows in the table

		            // Get column names dynamically from the ResultSetMetaData
		            int cols = rsmd.getColumnCount();
		            String[] colName = new String[cols];
		            for (int i = 0; i < cols; i++) {
		                colName[i] = rsmd.getColumnName(i + 1); // Column indices start from 1
		            }
		            model.setColumnIdentifiers(colName); // Set column names in the table model

		            // Read rows dynamically based on the column count
		            while (rs.next()) {
		                String[] row = new String[cols];
		                for (int i = 0; i < cols; i++) {
		                    row[i] = rs.getString(i + 1); // Retrieve each column's value
		                }
		                model.addRow(row); // Add the row to the table model
		            }

		            st.close();
		            con.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});


		btnDisplayRates.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDisplayRates.setBackground(Color.WHITE);
		btnDisplayRates.setBounds(464, 441, 140, 27);
		contentPane.add(btnDisplayRates);
		
		JButton btnDisplay = new JButton("Display Bookings");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "password");
		            Statement st = con.createStatement();
		            String sql = "SELECT * FROM bookings";
		            ResultSet rs = st.executeQuery(sql);
		            ResultSetMetaData rsmd = rs.getMetaData();
		            DefaultTableModel model = (DefaultTableModel) table_data.getModel();

		            model.setRowCount(0);

		            int cols = rsmd.getColumnCount();
		            String[] colName = new String[cols];
		            for (int i = 0; i < cols; i++)
		                colName[i] = rsmd.getColumnName(i + 1);
		            model.setColumnIdentifiers(colName);

		            String userID, username, password, Gmail, Address;
		            while (rs.next()) {
		                userID = rs.getString(1);
		                username = rs.getString(2);
		                password = rs.getString(3);
		                Gmail = rs.getString(4);
		                Address = rs.getString(5);		        
		                String[] row = {userID, username, password, Gmail, Address};
		                model.addRow(row);
		            }
		            st.close();
		            con.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			
		}
	});

		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDisplay.setBackground(Color.WHITE);
		btnDisplay.setBounds(292, 441, 162, 27);
		contentPane.add(btnDisplay);
		
		
		
		
		
		
		JButton add = new JButton("Add user");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JTextField tfEmail = new JTextField();
			        JTextField tfFirstName = new JTextField();
			        JTextField tfLastName = new JTextField();
			        JPasswordField tfPassword = new JPasswordField();
			        JTextField tfContactNumber = new JTextField();

			        // Create a panel to hold the input fields
			        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
			        inputPanel.add(new JLabel("Email:"));
			        inputPanel.add(tfEmail);
			        inputPanel.add(new JLabel("First Name:"));
			        inputPanel.add(tfFirstName);
			        inputPanel.add(new JLabel("Last Name:"));
			        inputPanel.add(tfLastName);
			        inputPanel.add(new JLabel("Password:"));
			        inputPanel.add(tfPassword);
			        inputPanel.add(new JLabel("Contact Number:"));
			        inputPanel.add(tfContactNumber);

			        // Show the dialog and get the result
			        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Add New User", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

			        if (result == JOptionPane.OK_OPTION) {
			            try {
			                // Get input from the fields
			                String email = tfEmail.getText();
			                String firstName = tfFirstName.getText();
			                String lastName = tfLastName.getText();
			                String password = new String(tfPassword.getPassword());
			                String contactNumber = tfContactNumber.getText();

			                // Validate required fields
			                if (email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || password.isEmpty() || contactNumber.isEmpty()) {
			                    JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
			                    return;
			                }

			                // Database connection and insertion
			                Class.forName("com.mysql.cj.jdbc.Driver");
			                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "password");
			                String sql = "INSERT INTO users (email, first_name, last_name, password, contact_number) VALUES (?, ?, ?, ?, ?)";
			                PreparedStatement pst = con.prepareStatement(sql);

			                pst.setString(1, email);
			                pst.setString(2, firstName);
			                pst.setString(3, lastName);
			                pst.setString(4, password);
			                pst.setString(5, contactNumber);

			                int rowsInserted = pst.executeUpdate();
			                if (rowsInserted > 0) {
			                    JOptionPane.showMessageDialog(null, "User added successfully!");
			                }

			                // Refresh table data
			                Statement st = con.createStatement();
			                ResultSet rs = st.executeQuery("SELECT * FROM users");
			                ResultSetMetaData rsmd = rs.getMetaData();
			                DefaultTableModel model = (DefaultTableModel) table_data.getModel();

			                model.setRowCount(0);

			                int cols = rsmd.getColumnCount();
			                String[] colName = new String[cols];
			                for (int i = 0; i < cols; i++)
			                    colName[i] = rsmd.getColumnName(i + 1);
			                model.setColumnIdentifiers(colName);

			                while (rs.next()) {
			                    String[] row = new String[cols];
			                    for (int i = 0; i < cols; i++)
			                        row[i] = rs.getString(i + 1);
			                    model.addRow(row);
			                }

			                st.close();
			                con.close();
			            } catch (Exception ex) {
			                ex.printStackTrace();
			            }
			        }
			    }
			});
		add.setFont(new Font("Tahoma", Font.BOLD, 15));
		add.setBounds(66, 126, 152, 23);
		contentPane.add(add);
		
		JButton Update = new JButton("Update user");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            String userId = JOptionPane.showInputDialog(null, "Enter the User ID to update:", "Update User", JOptionPane.QUESTION_MESSAGE);

		            if (userId == null || userId.trim().isEmpty()) {
		                JOptionPane.showMessageDialog(null, "User ID is required!", "Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }

		            // Database connection to fetch user data
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "password");
		            String fetchSql = "SELECT * FROM users WHERE id = ?";
		            PreparedStatement fetchPst = con.prepareStatement(fetchSql);
		            fetchPst.setString(1, userId);
		            ResultSet rs = fetchPst.executeQuery();

		            if (rs.next()) {
		                // Pre-fill user information
		                JTextField tfEmail = new JTextField(rs.getString("email"));
		                JTextField tfFirstName = new JTextField(rs.getString("first_name"));
		                JTextField tfLastName = new JTextField(rs.getString("last_name"));
		                JPasswordField tfPassword = new JPasswordField(rs.getString("password"));
		                JTextField tfContactNumber = new JTextField(rs.getString("contact_number"));

		                JPanel inputPanel = new JPanel(new GridLayout(5, 2));
		                inputPanel.add(new JLabel("Email:"));
		                inputPanel.add(tfEmail);
		                inputPanel.add(new JLabel("First Name:"));
		                inputPanel.add(tfFirstName);
		                inputPanel.add(new JLabel("Last Name:"));
		                inputPanel.add(tfLastName);
		                inputPanel.add(new JLabel("Password:"));
		                inputPanel.add(tfPassword);
		                inputPanel.add(new JLabel("Contact Number:"));
		                inputPanel.add(tfContactNumber);

		                int result = JOptionPane.showConfirmDialog(null, inputPanel, "Update User Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		                if (result == JOptionPane.OK_OPTION) {
		                    // Update user data in the database
		                    String updateSql = "UPDATE users SET email = ?, first_name = ?, last_name = ?, password = ?, contact_number = ? WHERE id = ?";
		                    PreparedStatement updatePst = con.prepareStatement(updateSql);

		                    updatePst.setString(1, tfEmail.getText());
		                    updatePst.setString(2, tfFirstName.getText());
		                    updatePst.setString(3, tfLastName.getText());
		                    updatePst.setString(4, new String(tfPassword.getPassword()));
		                    updatePst.setString(5, tfContactNumber.getText());
		                    updatePst.setString(6, userId);

		                    int rowsUpdated = updatePst.executeUpdate();
		                    if (rowsUpdated > 0) {
		                        JOptionPane.showMessageDialog(null, "User updated successfully!");
		                    }
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "User ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
		            }

		            fetchPst.close();
		            con.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		Update.setFont(new Font("Tahoma", Font.BOLD, 15));
		Update.setBounds(66, 173, 152, 23);
		contentPane.add(Update);
		
		JButton remove = new JButton("Remove user");
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
			            // Prompt admin to enter the User ID
			            String userId = JOptionPane.showInputDialog(null, "Enter the User ID to remove:", "Remove User", JOptionPane.QUESTION_MESSAGE);

			            if (userId == null || userId.trim().isEmpty()) {
			                JOptionPane.showMessageDialog(null, "User ID is required!", "Error", JOptionPane.ERROR_MESSAGE);
			                return;
			            }

			            // Database connection
			            Class.forName("com.mysql.cj.jdbc.Driver");
			            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "password");

			            // Check if user exists
			            String checkSql = "SELECT * FROM user WHERE id = ?";
			            PreparedStatement checkPst = con.prepareStatement(checkSql);
			            checkPst.setString(1, userId);
			            ResultSet rs = checkPst.executeQuery();

			            if (rs.next()) {
			                // Confirm deletion
			                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
			                if (confirm == JOptionPane.YES_OPTION) {
			                    // Delete user
			                    String deleteSql = "DELETE FROM users WHERE id = ?";
			                    PreparedStatement deletePst = con.prepareStatement(deleteSql);
			                    deletePst.setString(1, userId);

			                    int rowsDeleted = deletePst.executeUpdate();
			                    if (rowsDeleted > 0) {
			                        JOptionPane.showMessageDialog(null, "User deleted successfully!");
			                    }
			                    deletePst.close();
			                }
			            } else {
			                JOptionPane.showMessageDialog(null, "User ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
			            }

			            checkPst.close();
			            con.close();
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
			    }
			});
		remove.setFont(new Font("Tahoma", Font.BOLD, 15));
		remove.setBounds(66, 217, 152, 23);
		contentPane.add(remove);
		
		JButton Cancel = new JButton("Cancel booking");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try {
			            // Step 1: Prompt admin to enter the User ID
			            String userId = JOptionPane.showInputDialog(null, "Enter the User ID to remove:", "Remove User", JOptionPane.QUESTION_MESSAGE);

			            if (userId == null || userId.trim().isEmpty()) {
			                JOptionPane.showMessageDialog(null, "User ID is required!", "Error", JOptionPane.ERROR_MESSAGE);
			                return;
			            }

			            // Step 2: Database connection
			            Class.forName("com.mysql.cj.jdbc.Driver");
			            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "password");

			            // Step 3: Fetch user data from the bookings and rates tables
			            String bookingQuery = "SELECT * FROM bookings WHERE user_id = ?";
			            String ratesQuery = "SELECT * FROM rates WHERE user_id = ?";

			            // Fetch booking data
			            PreparedStatement bookingPst = con.prepareStatement(bookingQuery);
			            bookingPst.setString(1, userId);
			            ResultSet bookingRs = bookingPst.executeQuery();

			            // Fetch rates data
			            PreparedStatement ratesPst = con.prepareStatement(ratesQuery);
			            ratesPst.setString(1, userId);
			            ResultSet ratesRs = ratesPst.executeQuery();

			            // Step 4: Create lists for bookings and rates data
			            DefaultListModel<String> bookingListModel = new DefaultListModel<>();
			            DefaultListModel<String> rateListModel = new DefaultListModel<>();

			            // Booking data
			            while (bookingRs.next()) {
			                String bookingDetails = "Booking ID: " + bookingRs.getInt("booking_id") + 
			                                        ", Check-in: " + bookingRs.getDate("check_in_date") + 
			                                        ", Check-out: " + bookingRs.getDate("check_out_date") + 
			                                        ", Room Type: " + bookingRs.getString("room_type") + 
			                                        ", Nights: " + bookingRs.getInt("num_nights") +
			                                        ", Room Count: " + bookingRs.getInt("room_count");
			                bookingListModel.addElement(bookingDetails);
			            }

			            // Rates data
			            while (ratesRs.next()) {
			                String rateDetails = "Room ID: " + ratesRs.getInt("Room_ID") + 
			                                     ", Room Type: " + ratesRs.getString("Room_Type") + 
			                                     ", Quantity: " + ratesRs.getInt("Room_Quantity");
			                rateListModel.addElement(rateDetails);
			            }

			            if (bookingListModel.isEmpty() && rateListModel.isEmpty()) {
			                JOptionPane.showMessageDialog(null, "No data found for this User ID.", "Error", JOptionPane.ERROR_MESSAGE);
			                bookingPst.close();
			                ratesPst.close();
			                con.close();
			                return;
			            }

			            // Step 5: Create JLists for bookings and rates
			            JList<String> bookingList = new JList<>(bookingListModel);
			            JList<String> rateList = new JList<>(rateListModel);

			            // Step 6: Create ScrollPane for each list
			            JScrollPane bookingScroll = new JScrollPane(bookingList);
			            JScrollPane rateScroll = new JScrollPane(rateList);

			            // Adjust the preferred size of the booking column (Wider column)
			            bookingScroll.setPreferredSize(new java.awt.Dimension(500, 200));
			            rateScroll.setPreferredSize(new java.awt.Dimension(450, 200));
			            // You can adjust the width (500) to fit your needs

			            // Step 7: Use JSplitPane to show both lists side by side
			            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, bookingScroll, rateScroll);
			            splitPane.setDividerLocation(600); // Adjust the divider position to give more space to bookings (larger number = wider booking column)

			            // Step 8: Show a dialog with both lists
			            int option = JOptionPane.showConfirmDialog(null, splitPane, "Select Data to Delete", JOptionPane.OK_CANCEL_OPTION);

			            if (option == JOptionPane.OK_OPTION) {
			                // Step 9: Get the selected data from both lists
			                List<String> selectedBookingData = bookingList.getSelectedValuesList();
			                List<String> selectedRateData = rateList.getSelectedValuesList();

			                // Step 10: Confirm deletion
			                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected data?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
			                if (confirm == JOptionPane.YES_OPTION) {
			                    // Step 11: Delete selected data from both bookings and rates tables
			                    for (String data : selectedBookingData) {
			                        String[] parts = data.split(","); // Split by comma to get ID
			                        String bookingId = parts[0].split(":")[1].trim();
			                        String deleteBookingSql = "DELETE FROM bookings WHERE booking_id = ?";
			                        PreparedStatement deleteBookingPst = con.prepareStatement(deleteBookingSql);
			                        deleteBookingPst.setString(1, bookingId);
			                        deleteBookingPst.executeUpdate();
			                    }

			                    for (String data : selectedRateData) {
			                        String[] parts = data.split(","); // Split by comma to get Room ID
			                        String roomId = parts[0].split(":")[1].trim();
			                        String deleteRatesSql = "DELETE FROM rates WHERE Room_ID = ?";
			                        PreparedStatement deleteRatesPst = con.prepareStatement(deleteRatesSql);
			                        deleteRatesPst.setString(1, roomId);
			                        deleteRatesPst.executeUpdate();
			                    }

			                    JOptionPane.showMessageDialog(null, "Selected data deleted successfully.");
			                }
			            }

			            // Step 12: Close resources
			            bookingPst.close();
			            ratesPst.close();
			            con.close();
			        } catch (Exception ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			        }
			    }
			});
		Cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Cancel.setBounds(66, 258, 152, 23);
		contentPane.add(Cancel);
	
	}
}
