package FProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import java.util.Stack;

public class executiveUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField textField;
    private JLabel Tprice;
    private JLabel lblNewLabel_8_1;
    private JButton btnNewButton_5_2;
    private JButton btnNewButton_5_1;
    private JButton btnNewButton_5;
    private JButton Executive2;
    private double totalPrice;
    static JLabel LocalNumNights;
 
    

    private int numNights;
    
    private Map<JButton, Integer> buttonPriceMap;
    private Stack<List<Object[]>> tableHistory = new Stack<>();
    private Map<JButton, Stack<List<Object[]>>> buttonHistoryMap = new HashMap<>();
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					executiveUI frame = new executiveUI();
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
	public executiveUI() {
	
		
		JPanel panel_1 = new JPanel();
		
		JLabel NumNights = new JLabel("0");
		NumNights.setFont(new Font("SansSerif", Font.PLAIN, 20));
		NumNights.setBounds(479, 265, 233, 19);
		panel_1.add(NumNights);
		
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");

		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "password");

		    Statement st = con.createStatement();

		    String sql = "SELECT num_nights FROM bookings ORDER BY booking_id DESC LIMIT 1";

		    ResultSet rs = st.executeQuery(sql);

		    if (rs.next()) {
		        numNights = rs.getObject("num_nights") == null ? 0 : rs.getInt("num_nights");

		        System.out.println("Retrieved num_nights: " + numNights);

		        NumNights.setText(" " + numNights);              
		    } else {
		        System.out.println("No data returned from the query");
		    }

		} catch (SQLException ex) {
		    ex.printStackTrace();  
		} catch (Exception ex) {
		    ex.printStackTrace();  
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1290, 792);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 220));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        buttonPriceMap = new HashMap<>();
        		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1287, 76);
		panel.setLayout(null);
		panel.setBackground(new Color(247, 233, 98));
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Staycay Central PH");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(10, 11, 264, 54);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1_1 = new JButton("SIGN-OUT");
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userlogregUI newHomeFrame = new userlogregUI();
				newHomeFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(1162, 31, 104, 23);
		panel.add(btnNewButton_1_1);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userdashboardUI newHomeFrame = new userdashboardUI(getTitle());
				newHomeFrame.setVisible(true);
				dispose();
			}
		});
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHome.setBackground(new Color(255, 255, 255));
		btnHome.setBounds(284, 11, 104, 54);
		panel.add(btnHome);
		
		ImageIcon userImageIcon = new ImageIcon(executiveUI.class.getResource("/FProject/images/user-img.png"));
		Image userImage = userImageIcon.getImage().getScaledInstance(67, 54, Image.SCALE_SMOOTH);
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(userImage));
		lblNewLabel_4.setBounds(1085, 11, 67, 54);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Select Room(s)");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel_1.setBounds(10, 87, 203, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Php 15,000 per night");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(30, 403, 381, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("EXECUTIVE ROOM");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(new Color(155, 113, 7));
		lblNewLabel_2_2.setFont(new Font("Serif", Font.BOLD, 24));
		lblNewLabel_2_2.setBounds(30, 369, 381, 32);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Php 15,000 per night");
		lblNewLabel_3_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3_1.setBounds(448, 403, 381, 32);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("EXECUTIVE ROOM");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setForeground(new Color(155, 113, 7));
		lblNewLabel_2_2_1.setFont(new Font("Serif", Font.BOLD, 24));
		lblNewLabel_2_2_1.setBounds(448, 369, 381, 32);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Php 15,000 per night");
		lblNewLabel_3_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3_2.setBounds(868, 403, 381, 32);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("EXECUTIVE ROOM");
		lblNewLabel_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_2.setForeground(new Color(155, 113, 7));
		lblNewLabel_2_2_2.setFont(new Font("Serif", Font.BOLD, 24));
		lblNewLabel_2_2_2.setBounds(868, 369, 381, 32);
		contentPane.add(lblNewLabel_2_2_2);
		

		panel_1.setBackground(new Color(253, 231, 254));
		panel_1.setBounds(0, 446, 1274, 310);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("BOOKING SUMMARY");
		lblNewLabel_5.setFont(new Font("Serif", Font.BOLD, 24));
		lblNewLabel_5.setBounds(10, 11, 264, 40);
		panel_1.add(lblNewLabel_5);

		String[] columnNames = { "Selected Rooms", "Initial Price", "Quantity", "Updated Price" };
		tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);

		table.setFont(new Font("Serif", Font.PLAIN, 18));

		table.setRowHeight(25);

		table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));

		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		table.setBounds(20, 45, 374, 254);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 62, 1244, 134);
		panel_1.add(scrollPane);
		scrollPane.setVisible(false);
		
		JLabel lblNewLabel_6 = new JLabel("TOTAL PRICE:");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_6.setBounds(843, 215, 150, 35);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Promo Code:");
		lblNewLabel_7.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_7.setBounds(30, 207, 150, 32);
		panel_1.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textField.setBounds(40, 239, 183, 32);
		panel_1.add(textField);
		textField.setColumns(10);
		
		Tprice = new JLabel("0");
		Tprice.setFont(new Font("SansSerif", Font.PLAIN, 20));
		Tprice.setBounds(853, 251, 183, 33);
		panel_1.add(Tprice);
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_8_1.setBounds(853, 251, 183, 33);
		panel_1.add(lblNewLabel_8_1);
		
		JButton btnNewButton_3 = new JButton("SUBMIT");
		btnNewButton_3.setBackground(new Color(255, 255, 255));

		btnNewButton_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String enteredCode = textField.getText().trim();
		        String specialCode = "1puorG";

		        // Update and retrieve the total cost
		        int totalCost = updateTotalPrice();
		        double finalPrice = totalCost; // By default, it's the full price
		        boolean isDiscounted = false; // Default is not discounted

		        if (enteredCode.equalsIgnoreCase(specialCode)) {
		            // Apply 10% discount
		            double discount = 0.10;
		            finalPrice = totalCost - (totalCost * discount);
		            isDiscounted = true;

		            System.out.println("Total Discounted Price: Php " + finalPrice);

		            // Format the discounted price and display it
		            DecimalFormat formatter = new DecimalFormat("#,###");
		            String formattedDiscountedPrice = formatter.format(finalPrice);
		            Tprice.setText("Php " + formattedDiscountedPrice);

		            JOptionPane.showMessageDialog(null, "Discount applied! 10% off the total price.");
		        } else if (enteredCode.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter a promo code.", "Error", JOptionPane.ERROR_MESSAGE);
		        } else {
		            JOptionPane.showMessageDialog(null, "Wrong Promo Code or Promo Code doesn't exist.", "Invalid Promo Code", JOptionPane.ERROR_MESSAGE);

		            // Ensure the total price is recalculated and displayed without a discount
		            updateTotalPrice();
		        }

		        // Insert the final price into the database
		        saveTotalPriceToDatabase(finalPrice, isDiscounted);
		    }
		});

		btnNewButton_3.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnNewButton_3.setBounds(233, 238, 119, 34);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("CONTINUE");
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveRoomDetails(btnNewButton_4);
				paymentUI paymentWindow = new paymentUI("Executive"); 
				paymentWindow.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setFont(new Font("SansSerif", Font.BOLD, 24));
		btnNewButton_4.setBounds(1075, 244, 177, 40);
		panel_1.add(btnNewButton_4);
		
		JButton Executive3 = new JButton("");
		 buttonPriceMap.put(Executive3, 15000);
		
		Executive3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 saveCurrentState(Executive3);
				 undont(Executive3);
			        updateTotalPrice();
			        handleRoomSelection(Executive3, scrollPane);
			        Executive3.setEnabled(false);
			        scrollPane.setVisible(true);
				
			}
			
		});
		Executive3.setIcon(new ImageIcon(new ImageIcon(executiveUI.class.getResource("/FProject/images/executive-img.jpg"))
		.getImage().getScaledInstance(381, 241, Image.SCALE_SMOOTH)));
		Executive3.setBounds(868, 126, 381, 241);
		contentPane.add(Executive3);
		
		Executive2 = new JButton("");
		 buttonPriceMap.put(Executive2, 15000);

		
		
		
		
		 
		 
		 
		 
		 
		 
		
		Executive2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  saveCurrentState(Executive2);
				  undont(Executive2);
			        handleRoomSelection(Executive2, scrollPane);
			        updateTotalPrice();
			        Executive2.setEnabled(false);
			        scrollPane.setVisible(true);
				
			}
		});
		Executive2.setIcon(new ImageIcon(new ImageIcon(executiveUI.class.getResource("/FProject/images/executive-img.jpg"))
		.getImage().getScaledInstance(381, 241, Image.SCALE_SMOOTH)));
		Executive2.setBounds(448, 126, 381, 241);
		contentPane.add(Executive2);
		
		JButton Executive1 = new JButton("");
		   buttonPriceMap.put(Executive1, 15000);

		
		Executive1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveCurrentState(Executive1);
				undont(Executive1);
		        handleRoomSelection(Executive1, scrollPane);
		        updateTotalPrice();
		        Executive1.setEnabled(false);
		        scrollPane.setVisible(true);
		    }
		});
		Executive1.setIcon(new ImageIcon(new ImageIcon(executiveUI.class.getResource("/FProject/images/executive-img.jpg"))
		.getImage().getScaledInstance(381, 241, Image.SCALE_SMOOTH)));
		Executive1.setBounds(30, 126, 381, 241);
		contentPane.add(Executive1);


		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setForeground(new Color(253, 231, 254));
		btnNewButton_2.setBackground(new Color(253, 231, 254));
		btnNewButton_2.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
			        int selectedRow = table.getSelectedRow();
			        if (selectedRow != -1) {
			            int quantity = (int) tableModel.getValueAt(selectedRow, 2);
			            int pricePerNight = Integer.parseInt(
			                tableModel.getValueAt(selectedRow, 1).toString().replace("Php ", "").replace(",", "").trim()
			                
			            );

			            if (quantity > 1) {
			                quantity -= 1;
			                int updatedPrice = pricePerNight * quantity;
			                tableModel.setValueAt(quantity, selectedRow, 2);
			                tableModel.setValueAt("Php " + updatedPrice, selectedRow, 3);
			            } else {
			                tableModel.removeRow(selectedRow);
					        Executive1.setEnabled(true);
					        Executive2.setEnabled(true);		    
							Executive3.setEnabled(true);
			            }


			            

			            if (tableModel.getRowCount() == 0) {
			                scrollPane.setVisible(false); 
			                panel_1.revalidate(); 
			                panel_1.repaint(); 
			            }
			            updateTotalPrice();

			        }
			    }
			});


		ImageIcon trashBinImageIcon = new ImageIcon(executiveUI.class.getResource("/FProject/images/trashbin-img.png"));
		Image trashBinImage = trashBinImageIcon.getImage().getScaledInstance(45, 35, Image.SCALE_SMOOTH);
		btnNewButton_2.setIcon(new ImageIcon(trashBinImage));
		btnNewButton_2.setBounds(1219, 16, 45, 35);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_7_1 = new JLabel("Number of Nights:");
		lblNewLabel_7_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_7_1.setBounds(413, 222, 224, 32);
		panel_1.add(lblNewLabel_7_1);
		
		
		
		JButton btnNewButton_6 = new JButton("UNDON'T");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_6.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				    undoAllChanges();
			    }
			});
		btnNewButton_6.setBounds(1097, 25, 89, 23);
		panel_1.add(btnNewButton_6);
	}
	
	private void undoAllChanges() {
	    for (JButton button : buttonHistoryMap.keySet()) {
	        Stack<List<Object[]>> history = buttonHistoryMap.get(button);
	        if (history != null && !history.isEmpty()) {
	            undoLastChange(button);  // Undo last action for each button
	        }
	    }
	}
	 private void handleRoomSelection(JButton button, JScrollPane scrollPane) {
	        int pricePerNight = buttonPriceMap.get(button);
	        addToBookingSummary("Executive Room", pricePerNight);
	        button.setEnabled(false);
	        scrollPane.setVisible(true);
	    }
	 public void undont(JButton button) {
		  saveCurrentState(button);
	 }
	 public void saveRoomDetails(JButton button) {
		    saveCurrentState(button); // Save the current table state
		    
		    // Loop through all rows in the table and validate room details
		    for (int i = 0; i < tableModel.getRowCount(); i++) {
		        String roomType = (String) tableModel.getValueAt(i, 0);
		        Integer roomCount = (Integer) tableModel.getValueAt(i, 2);
		        
		        if (roomType == null || roomType.trim().isEmpty() || roomCount == null || roomCount <= 0) {
		            // Show an error message if any data is missing or invalid
		            JOptionPane.showMessageDialog(null, "Invalid room data at row " + (i + 1), "Error", JOptionPane.ERROR_MESSAGE);
		            continue;
		        }

		        int currentUserId = getCurrentUserId(); // Get the current user ID (implement this method to retrieve it)
		        
		        // Proceed to save data into the database
		        try (Connection connection = MySQLConnection.connect()) {
		            String sql = "INSERT INTO rates (room_type, room_quantity, user_id) VALUES (?, ?, ?) " +
		                         "ON DUPLICATE KEY UPDATE room_quantity = ?, user_id = ?";
		            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
		                stmt.setString(1, roomType);        // Set room type
		                stmt.setInt(2, roomCount);         // Set room quantity
		                stmt.setInt(3, currentUserId);     // Set user ID
		                stmt.setInt(4, roomCount);         // Update room quantity if duplicate
		                stmt.setInt(5, currentUserId);     // Update user ID if duplicate

		                stmt.executeUpdate(); // Execute the query
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error saving room details.", "Database Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		    button.setEnabled(false); // Disable the button once room is saved
		}
	 private void undoLastChange(JButton button) {
		    Stack<List<Object[]>> buttonHistory = buttonHistoryMap.get(button);
		    if (buttonHistory != null && !buttonHistory.isEmpty()) {
		        List<Object[]> previousState = buttonHistory.pop();
		        tableModel.setRowCount(0);  // Clear the table
		        for (Object[] row : previousState) {
		            tableModel.addRow(row); // Re-add the previous state
		        }
		        button.setEnabled(true); // Re-enable the button
		    }
		    updateTotalPrice();  // Recalculate total price after undo
		}
	 private void saveCurrentState(JButton button) {
		    List<Object[]> currentState = new ArrayList<>();

		    // Iterate through the rows in your table and save them to currentState
		    for (int i = 0; i < tableModel.getRowCount(); i++) {
		        Object[] row = new Object[tableModel.getColumnCount()];
		        for (int j = 0; j < tableModel.getColumnCount(); j++) {
		            row[j] = tableModel.getValueAt(i, j);
		        }
		        currentState.add(row);
		    }

		    // Push the current state to the button's history stack
		    buttonHistoryMap.computeIfAbsent(button, k -> new Stack<>()).push(currentState);
		}

	    private void addToBookingSummary(String roomName, int pricePerNight) {
	        boolean roomExists = false;
	        for (int i = 0; i < tableModel.getRowCount(); i++) {
	            if (tableModel.getValueAt(i, 0).equals(roomName)) {
	                int quantity = (int) tableModel.getValueAt(i, 2) + 1;
	                int updatedPrice = pricePerNight * quantity;
	                tableModel.setValueAt(quantity, i, 2);
	                tableModel.setValueAt("Php " + updatedPrice, i, 3);
	                roomExists = true;
	                break;
	            }
	        }

	        if (!roomExists) {
	            int updatedPrice = pricePerNight;
	            tableModel.addRow(new Object[] { roomName, "Php " + pricePerNight, 1, "Php " + updatedPrice });
	        }
 
	        updateTotalPrice();
	    }

	    private int updateTotalPrice() {
	    	int totalPrice = 0;
	    	for (int i = 0; i < tableModel.getRowCount(); i++) {
	    	    String updatedPriceString = tableModel.getValueAt(i, 3).toString();
	    	    int updatedPrice = Integer.parseInt(
	    	        updatedPriceString.replace("Php ", "").replace(",", "").trim()
	    	    );
	    	    totalPrice += updatedPrice;
	    	    
	    	}
	    	System.out.println("numNights: " + numNights);


	        int totalCost = totalPrice * numNights;
	        DecimalFormat formatter = new DecimalFormat("#,###");
	        String formattedTotalPrice = formatter.format(totalCost);

	        if (Tprice != null) {
	            Tprice.setText("Php " + formattedTotalPrice);
	            saveTotalPriceToDatabase(formattedTotalPrice);
	        } else {
	            System.err.println("Total price is null");
	        }
	        return totalCost;
	    }
	    private void saveTotalPriceToDatabase(String totalPrice) {
	        String dbURL = "jdbc:mysql://localhost:3306/userdata";
	        String username = "root";
	        String password = "password";

	        String query = "INSERT INTO TotalPrice (total_price) VALUES (?)";

	        try (Connection connection = DriverManager.getConnection(dbURL, username, password);
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            // Remove "Php " from the string and parse it as a double
	            double priceValue = Double.parseDouble(totalPrice.replace(",", "").trim());
	            
	            preparedStatement.setDouble(1, priceValue);

	            int rowsInserted = preparedStatement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("Total price saved to database successfully: Php " + totalPrice);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.err.println("Error inserting total price into the database.");
	        }
	    }
	    
	    private void saveTotalPriceToDatabase(double totalPrice, boolean isDiscounted) {
	        String dbURL = "jdbc:mysql://localhost:3306/userdata";
	        String username = "root";
	        String password = "password";

	        String query = "INSERT INTO TotalPrice (total_price, is_discounted) VALUES (?, ?)";

	        try (Connection connection = DriverManager.getConnection(dbURL, username, password);
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setDouble(1, totalPrice);
	            preparedStatement.setBoolean(2, isDiscounted);

	            int rowsInserted = preparedStatement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("Total price saved to database successfully: Php " + totalPrice + " (Discounted: " + isDiscounted + ")");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.err.println("Error inserting total price into the database.");
	        }
	    }
	    public static int getCurrentUserId() {
	        int userId = -1; // Default to an invalid ID
	        String loggedInEmail = SessionManager.getInstance().getLoggedInEmail();

	        if (loggedInEmail == null || loggedInEmail.isEmpty()) {
	            System.out.println("No user is logged in.");
	            return userId; // Return invalid ID if no user is logged in
	        }

	        String query = "SELECT id FROM users WHERE email = ?";
	        try (Connection connection = MySQLConnection.connect();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setString(1, loggedInEmail);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                userId = resultSet.getInt("id"); // Fetch the `id` from the result set
	            } else {
	                System.out.println("No user found with the email: " + loggedInEmail);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return userId;
	    }
	  
}
