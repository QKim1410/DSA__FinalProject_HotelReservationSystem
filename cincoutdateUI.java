package FProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;

@SuppressWarnings("unused")
public class cincoutdateUI extends JFrame {
  private static final long serialVersionUID = 1L;
protected static final String String = null;
  private JPanel contentPane;
  private JTable checkin;
  private JButton SelectDateCI; 
  private JButton SelectDateCO; 
  private JDialog datePickerDialog;
  private boolean isCheckIn = true;
  private JLabel monthDisplayCI;
  private JTable tabledays;
  private JTable checkoutheader;
  private JLabel numNights;
  private LocalDate selectedCheckInDate = null;
  private LocalDate selectedCheckOutDate = null;
  private JTable calendarTable = new JTable();
  private String roomType;

  
  
  public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                // Pass a specific room type as a string (e.g., "Deluxe")
	                cincoutdateUI frame = new cincoutdateUI("Deluxe");  // Example: Pass "Deluxe"
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
  
  public cincoutdateUI(String roomType) {
	  this.roomType = roomType;
	  String loggedInEmail = SessionManager.getInstance().getLoggedInEmail();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 608, 796);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(255, 245, 220));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      JPanel panel = new JPanel();
      panel.setBounds(-2, 0, 1272, 76);
      panel.setLayout(null);
      panel.setBackground(new Color(255, 239, 184));
      contentPane.add(panel);
      JLabel lblNewLabel = new JLabel("Staycay Center PH");
      lblNewLabel.setForeground(Color.BLACK);
      lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 24));
      lblNewLabel.setBounds(10, 11, 264, 54);
      panel.add(lblNewLabel);
      
        ImageIcon userIcon = new ImageIcon("D:\\2nd Year\\1S\\CS\\FProject\\FProject\\images\\user-img.png");
		Image userImg = userIcon.getImage().getScaledInstance(69, 54, Image.SCALE_SMOOTH);
		JLabel lblUserImage = new JLabel(new ImageIcon(userImg));
		lblUserImage.setBounds(1064, 11, 69, 54);
		panel.add(lblUserImage);
      
      JButton btnNewButton_1_1 = new JButton("SIGN-OUT");
      btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userlogregUI newHomeFrame = new userlogregUI();
				newHomeFrame.setVisible(true);
				dispose();
			}
		});
      btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
      btnNewButton_1_1.setBounds(440, 31, 104, 23);
      panel.add(btnNewButton_1_1);
      JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userdashboardUI newHomeFrame = new userdashboardUI(loggedInEmail);
				newHomeFrame.setVisible(true);
				dispose();
			}
		});
      btnHome.setBackground(new Color(255, 239, 184));
      btnHome.setFont(new Font("Tahoma", Font.BOLD, 20));
      btnHome.setBounds(284, 12, 104, 54);
      panel.add(btnHome);
      JLabel lblNewLabel_7 = new JLabel("Check-in 2:00 PM of");
      lblNewLabel_7.setBounds(8, 87, 185, 20);
      lblNewLabel_7.setForeground(Color.BLACK);
      lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
      lblNewLabel_7.setBackground(Color.WHITE);
      contentPane.add(lblNewLabel_7);

      SelectDateCI = new JButton("- Select Date -");
      SelectDateCI.setBounds(20, 111, 195, 43);
      SelectDateCI.setFont(new Font("Tahoma", Font.BOLD, 16));
      contentPane.add(SelectDateCI);

      SelectDateCI.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        isCheckIn = true; // Set flag to check-in
    	        showDatePicker(true);

    	        // Parse the selected date
    	        String selectedCheckInDate = SelectDateCI.getText();
    	        LocalDate checkInDate = LocalDate.parse(selectedCheckInDate, DateTimeFormatter.ofPattern("d M yyyy"));

    	        updateTableHighlighting(checkin, checkInDate, null); // No check-out date yet
    	    }
    	});

      contentPane.add(SelectDateCI);

      JLabel lblNewLabel_7_1 = new JLabel("Check-out 12:00 PM of");
      lblNewLabel_7_1.setBounds(302, 88, 208, 20);
      lblNewLabel_7_1.setForeground(Color.BLACK);
      lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 18));
      lblNewLabel_7_1.setBackground(Color.WHITE);
      contentPane.add(lblNewLabel_7_1);
      SelectDateCO = new JButton("- Select Date -");
      SelectDateCO.setBounds(312, 111, 195, 43);
      SelectDateCO.setFont(new Font("Tahoma", Font.BOLD, 16));
      contentPane.add(SelectDateCO);
    
      SelectDateCO.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        isCheckIn = false; // Set flag to check-out
    	        showDatePicker(false);

    	        // Parse the selected dates
    	        String selectedCheckInDate = SelectDateCI.getText();
    	        String selectedCheckOutDate = SelectDateCO.getText();
    	        LocalDate checkInDate = LocalDate.parse(selectedCheckInDate, DateTimeFormatter.ofPattern("d M yyyy"));
    	        LocalDate checkOutDate = LocalDate.parse(selectedCheckOutDate, DateTimeFormatter.ofPattern("d M yyyy"));

    	        updateTableHighlighting(checkin, checkInDate, checkOutDate);
    	    }
    	});
      JLabel lblNewLabel_7_1_1_1 = new JLabel("Number of night(s)");
      lblNewLabel_7_1_1_1.setBounds(198, 700, 184, 20);
      lblNewLabel_7_1_1_1.setForeground(Color.BLACK);
      lblNewLabel_7_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
      contentPane.add(lblNewLabel_7_1_1_1);
      
      
      numNights = new JLabel("0"); 
      numNights.setBounds(275, 714, 195, 45);
      numNights.setFont(new Font("Tahoma", Font.PLAIN, 16));
      contentPane.add(numNights);

      checkin = new JTable();
      checkin.setBounds(40, 205, 530, 489);
      contentPane.add(checkin);
  
      tabledays = new JTable();
      tabledays.setBounds(40, 180, 530, 32);
      contentPane.add(tabledays);
   
      String[] columnNames = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0); 
      tabledays.setModel(tableModel);
      Object[] daysRow = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      tableModel.addRow(daysRow);
      contentPane.add(tabledays);
      contentPane.revalidate();
      contentPane.repaint();  
     
      monthDisplayCI = new JLabel("CheckIn");
      monthDisplayCI.setBounds(225, 151, 157, 32);
      monthDisplayCI.setFont(new Font("Tahoma", Font.PLAIN, 20));
      contentPane.add(monthDisplayCI);

      String[] columnNames1 = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      DefaultTableModel checkoutHeaderModel = new DefaultTableModel(columnNames1, 0);


      Object[] daysRow1 = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      checkoutHeaderModel.addRow(daysRow1);
      
      JButton btnNewButton = new JButton("Proceed");
      btnNewButton.setBounds(480, 727, 89, 23);
      btnNewButton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JFrame nextFrame;

    	        if ("Deluxe".equals(roomType)) {
    	            nextFrame = new deluxeUI();
    	        } else if ("Premier".equals(roomType)) {
    	            nextFrame = new premierUI();
    	        } else if ("Executive".equals(roomType)) {
    	            nextFrame = new executiveUI();
    	        } else {
    	            nextFrame = null; // Handle invalid roomType, if necessary
    	        }

    	        if (nextFrame != null) {
    	            nextFrame.setVisible(true);
    	            dispose();
    	        }
    	    }
    	});
      contentPane.add(btnNewButton);
      contentPane.revalidate();
      contentPane.repaint();
  }

  private void updateCalendar(JPanel calendarPanel, String month, int year) {
      for (Component component : calendarPanel.getComponents()) {
          if (component instanceof JPanel && ((JPanel) component).getLayout() instanceof GridLayout) {
              calendarPanel.remove(component); 
          }
      }

      int monthIndex = getMonthIndex(month);
      updateCheckInTable(monthIndex, year);

      Calendar calendar = Calendar.getInstance();
      calendar.set(year, monthIndex, 1); 

      int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
      int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
     
      JPanel daysPanel = new JPanel();
      daysPanel.setLayout(new GridLayout(0, 7)); 
   
      for (int i = 1; i < firstDayOfWeek; i++) {
          daysPanel.add(new JLabel("")); 
      }
   
      for (int day = 1; day <= daysInMonth; day++) {
          JButton dayButton = new JButton(String.valueOf(day));
          dayButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String selectedDate = dayButton.getText() + " " + (monthIndex + 1) + " " + year; 
        	        if (isCheckIn) {
        	            SelectDateCI.setText(selectedDate); 
        	            monthDisplayCI.setText(month + " " + year);
        	        } else {
        	            SelectDateCO.setText(selectedDate); 
        	        }
        	        calculateNights(); // Calculate nights after each selection
        	        datePickerDialog.dispose(); 
        	    }
        	});
          
          daysPanel.add(dayButton);
      }
      calendarPanel.add(daysPanel, BorderLayout.CENTER); 
      calendarPanel.revalidate(); 
      calendarPanel.repaint(); 
   
      datePickerDialog.setTitle("Select Date - " + month + " " + year); 
  }
  private void showDatePicker(boolean b) {

      datePickerDialog = new JDialog(this, "Select Date", true);
     
      datePickerDialog.setSize(400, 400);
      datePickerDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

      JPanel calendarPanel = new JPanel();
      calendarPanel.setLayout(new BorderLayout());

      JPanel topPanel = new JPanel();
      JComboBox<String> monthComboBox = new JComboBox<>(new String[]{
              "January", "February", "March", "April", "May", "June",
              "July", "August", "September", "October", "November", "December"
      });
      JTextField yearField = new JTextField(4); 
      yearField.setText(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));  
      monthComboBox.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
              if (e.getStateChange() == ItemEvent.SELECTED) {
                  String selectedMonth = (String) monthComboBox.getSelectedItem();
                  int selectedYear = Integer.parseInt(yearField.getText());
                  updateCalendar(calendarPanel, selectedMonth, selectedYear); 
              }
          }
      });
    
      yearField.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              String selectedMonth = (String) monthComboBox.getSelectedItem();
              int selectedYear = Integer.parseInt(yearField.getText());
              updateCalendar(calendarPanel, selectedMonth, selectedYear); 
          }
      });
      topPanel.add(monthComboBox);
      topPanel.add(yearField);
      calendarPanel.add(topPanel, BorderLayout.NORTH);
      
      updateCalendar(calendarPanel, monthComboBox.getSelectedItem().toString(), Integer.parseInt(yearField.getText()));
      datePickerDialog.getContentPane().add(calendarPanel); 
      datePickerDialog.setVisible(true);
  }
  
  
  private void updateTableHighlighting(JTable table, LocalDate checkInDate, LocalDate checkOutDate) {
	    table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
	        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

	            if (value != null && !value.toString().isEmpty()) {
	                try {
	                    int day = Integer.parseInt(value.toString());
	                    DefaultTableModel model = (DefaultTableModel) table.getModel();
	                    String monthYear = monthDisplayCI.getText(); // Get the displayed month and year
	                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
	                    LocalDate cellDate = LocalDate.parse(day + " " + monthYear, DateTimeFormatter.ofPattern("d MMMM yyyy"));

	                    // Highlight logic
	                    if (checkInDate != null && cellDate.equals(checkInDate)) {
	                        cell.setBackground(Color.GREEN); // Check-in date
	                        cell.setForeground(Color.WHITE);
	                    } else if (checkOutDate != null && checkInDate != null &&
	                               (cellDate.isAfter(checkInDate) && cellDate.isBefore(checkOutDate))) {
	                        cell.setBackground(Color.YELLOW); // In-between dates
	                        cell.setForeground(Color.BLACK);
	                    } else if (checkOutDate != null && cellDate.equals(checkOutDate)) {
	                        cell.setBackground(Color.RED); // Check-out date
	                        cell.setForeground(Color.WHITE);
	                    } else {
	                        cell.setBackground(Color.WHITE); // Default background
	                        cell.setForeground(Color.BLACK);
	                    }
	                } catch (DateTimeParseException | ArrayIndexOutOfBoundsException ex) {
	                    // Handle parsing or table index errors gracefully
	                    cell.setBackground(Color.WHITE);
	                    cell.setForeground(Color.BLACK);
	                }
	            } else {
	                cell.setBackground(Color.WHITE);
	                cell.setForeground(Color.BLACK);
	            }

	            return cell;
	        }
	    });
	    table.repaint();
	}

private int getMonthIndex(String month) {
  switch (month) {
      case "January": return 0;
      case "February": return 1;
      case "March": return 2;
      case "April": return 3;
      case "May": return 4;
      case "June": return 5;
      case "July": return 6;
      case "August": return 7;
      case "September": return 8;
      case "October": return 9;
      case "November": return 10;
      case "December": return 11;
      default: return -1; 
  }
}

private void updateCheckInTable(int month, int year) {
    DefaultTableModel model = new DefaultTableModel() {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    String[] columnNames = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    model.setColumnIdentifiers(columnNames);

    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, 1);
    int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;

    Object[] daysRow = new Object[7];

    for (int i = 0; i < firstDayOfWeek; i++) {
        daysRow[i] = ""; 
    }

    for (int day = 1; day <= daysInMonth; day++) {
        daysRow[(firstDayOfWeek + day - 1) % 7] = day;

        if ((firstDayOfWeek + day) % 7 == 0 || day == daysInMonth) {
            model.addRow(daysRow);
            daysRow = new Object[7];
        }
    }

    while (model.getRowCount() < 6) { 
        model.addRow(new Object[]{"", "", "", "", "", "", ""});
    }

    checkin.setModel(model);
    checkin.setRowHeight(83);

    checkin.setDefaultRenderer(Object.class, new DateCellRenderer()); 

    monthDisplayCI.setText(new String[]{"January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"}[month] + " " + year);
    
   
    checkin.setPreferredScrollableViewportSize(checkin.getPreferredSize());
    checkin.setFillsViewportHeight(true); 
}

class DateCellRenderer extends DefaultTableCellRenderer {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value != null && !value.toString().isEmpty()) {
            int day = Integer.parseInt(value.toString());
            String selectedDate = SelectDateCI.getText(); 
            String[] parts = selectedDate.split(" ");
            if (parts.length == 3) {
                int selectedDay = Integer.parseInt(parts[0]);
                int selectedMonth = Integer.parseInt(parts[1]);
                int selectedYear = Integer.parseInt(parts[2]);

                Calendar calendar = Calendar.getInstance();
                calendar.set(selectedYear, selectedMonth - 1, selectedDay);
                if (calendar.get(Calendar.DAY_OF_MONTH) == day) {
                    cell.setBackground(Color.CYAN); 
                } else {
                    cell.setBackground(Color.WHITE); 
                }
            } else {
                cell.setBackground(Color.WHITE); 
            }
        } else {
            cell.setBackground(Color.WHITE); 
        }
        return cell;
    }
}

private void updateCheckoutTable(int month, int year) {
 
    DefaultTableModel model = new DefaultTableModel(){
        private static final long serialVersionUID = 1L;
        
        @Override
    	public boolean isCellEditable(int row, int column) {
            return false; 
        }
    };


    String[] columnNames = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    model.setColumnIdentifiers(columnNames);


    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, 1);
    int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1; 

    Object[] daysRow = new Object[7];
    int dayCounter = 1;

    for (int i = 0; i < firstDayOfWeek; i++) {
        daysRow[i] = ""; 
    }
  
    for (int i = firstDayOfWeek; i < 7; i++) {
        daysRow[i] = dayCounter++;
    }
    model.addRow(daysRow);

    while (dayCounter <= daysInMonth) {
        daysRow = new Object[7];
        for (int i = 0; i < 7; i++) {
            if (dayCounter <= daysInMonth) {
                daysRow[i] = dayCounter++;
            } else {
                daysRow[i] = ""; 
            }
        }
        model.addRow(daysRow);
    }

    while (model.getRowCount() < 6) {
        model.addRow(new Object[]{"", "", "", "", "", "", ""});
    }
}

private void showCheckoutDatePicker() {

    datePickerDialog = new JDialog(this, "Select Checkout Date", true);
    datePickerDialog.setSize(400, 400);
    datePickerDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    JPanel calendarPanel = new JPanel();
    calendarPanel.setLayout(new BorderLayout());


    JPanel topPanel = new JPanel();
    JComboBox<String> monthComboBox = new JComboBox<>(new String[]{
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    });
    JTextField yearField = new JTextField(4);
    yearField.setText(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
   
    monthComboBox.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedMonth = (String) monthComboBox.getSelectedItem();
                int selectedYear = Integer.parseInt(yearField.getText());
                updateCheckoutCalendar(calendarPanel, selectedMonth, selectedYear); 
            }
        }
    });

    yearField.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String selectedMonth = (String) monthComboBox.getSelectedItem();
            int selectedYear = Integer.parseInt(yearField.getText());
            updateCheckoutCalendar(calendarPanel, selectedMonth, selectedYear); 
        }
    });

    topPanel.add(monthComboBox);
    topPanel.add(yearField);
    calendarPanel.add(topPanel, BorderLayout.NORTH);

    updateCheckoutCalendar(calendarPanel, monthComboBox.getSelectedItem().toString(), Integer.parseInt(yearField.getText()));
    datePickerDialog.getContentPane().add(calendarPanel); 
    datePickerDialog.setVisible(true);
}

private void updateCheckoutCalendar(JPanel calendarPanel, String month, int year) {
   
    for (Component component : calendarPanel.getComponents()) {
        if (component instanceof JPanel && ((JPanel) component).getLayout() instanceof GridLayout) {
            calendarPanel.remove(component); 
        }
    }

    int monthIndex = getMonthIndex(month);
    updateCheckoutTable(monthIndex, year);
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, monthIndex, 1); 
    int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    JPanel daysPanel = new JPanel();
    daysPanel.setLayout(new GridLayout(0, 7)); 
    for (int i = 1; i < firstDayOfWeek; i++) {
        daysPanel.add(new JLabel("")); 
    }
    
    for (int day = 1; day <= daysInMonth; day++) {
        JButton dayButton = new JButton(String.valueOf(day));
        dayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedDate = dayButton.getText();
                int day = Integer.parseInt(selectedDate);
                int month = getMonthIndex(monthDisplayCI.getText().split(" ")[0]);
                int year = Integer.parseInt(monthDisplayCI.getText().split(" ")[1]);

                if (isCheckIn) {
                    selectedCheckInDate = LocalDate.of(year, month + 1, day);
                    SelectDateCI.setText(selectedDate);
                    monthDisplayCI.setText(month + " " + year);
                } else {
                    selectedCheckOutDate = LocalDate.of(year, month + 1, day);
                    SelectDateCO.setText(selectedDate);
                }
                calculateNights(); // Update nights
                updateTableHighlighting(calendarTable, selectedCheckInDate, selectedCheckInDate);
                datePickerDialog.dispose();
            }
        });
        daysPanel.add(dayButton); 
    }
    calendarPanel.add(daysPanel, BorderLayout.CENTER); 
    calendarPanel.revalidate(); 
    calendarPanel.repaint(); 
}

public static int getCurrentUserId() {
    int userId = -1; 
    String loggedInEmail = SessionManager.getInstance().getLoggedInEmail();

    if (loggedInEmail == null || loggedInEmail.isEmpty()) {
        System.out.println("No user is logged in.");
        return userId; 
    }

    String query = "SELECT id FROM users WHERE email = ?";
    try (Connection connection = MySQLConnection.connect();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        preparedStatement.setString(1, loggedInEmail);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            userId = resultSet.getInt("id"); 
        } else {
            System.out.println("No user found with the email: " + loggedInEmail);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return userId;
}

private void calculateNights() {
    String checkInText = SelectDateCI.getText();
    String checkOutText = SelectDateCO.getText();

    if (!checkInText.equals("- Select Date -") && !checkOutText.equals("- Select Date -")) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d M yyyy");
            LocalDate checkInDate = LocalDate.parse(checkInText, formatter);
            LocalDate checkOutDate = LocalDate.parse(checkOutText, formatter);

            if (!checkOutDate.isAfter(checkInDate)) {
                JOptionPane.showMessageDialog(this, "Check-out date must be after check-in date.", 
                    "Invalid Date Selection", JOptionPane.ERROR_MESSAGE);
                SelectDateCO.setText("- Select Date -");
                numNights.setText("0");
                return;
            }
            long nights = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
            numNights.setText(String.valueOf(nights));

            java.sql.Date sqlCheckInDate = java.sql.Date.valueOf(checkInDate);
            java.sql.Date sqlCheckOutDate = java.sql.Date.valueOf(checkOutDate);

            int currentUserId = getCurrentUserId(); 

            DatabaseHelper.insertBookingDetails(sqlCheckInDate, sqlCheckOutDate, (int) nights, currentUserId);

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Error parsing dates. Please try again.", 
                "Date Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
}
