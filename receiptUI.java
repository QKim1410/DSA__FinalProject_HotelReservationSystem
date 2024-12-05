package FProject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import  FProject.userdashboardUI;

public class receiptUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblTotalPrice;
	private static String loggedInEmail;
	private static String previousWindow;
	private JLabel Total;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    receiptUI frame = new receiptUI(previousWindow);
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
    public receiptUI(String previousWindow) {
    	this.previousWindow = previousWindow;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 540, 603);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 220));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("<html>Staycay Central PH</html>");
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(92, 11, 129, 64);
        contentPane.add(lblNewLabel);

        ImageIcon originalIcon = new ImageIcon(receiptUI.class.getResource("/FProject/images/staycay-logo.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(72, 64, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel lblStaycayCentralPh = new JLabel("");
        lblStaycayCentralPh.setIcon(scaledIcon);
        lblStaycayCentralPh.setHorizontalAlignment(SwingConstants.CENTER);
        lblStaycayCentralPh.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblStaycayCentralPh.setBounds(10, 11, 72, 64);
        contentPane.add(lblStaycayCentralPh);


        JPanel panel = new JPanel();
        panel.setBackground(new Color(247, 233, 98));
        panel.setBounds(0, 88, 156, 38);
        contentPane.add(panel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(247, 233, 98));
        panel_1.setBounds(367, 88, 156, 38);
        contentPane.add(panel_1);

        JLabel lblNewLabel_1 = new JLabel("Payment Receipt");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(145, 86, 233, 40);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Invoice to:");
        lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblNewLabel_2.setBounds(62, 137, 104, 29);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Name:");
        lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3.setBounds(72, 193, 149, 29);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_3_1 = new JLabel("Mode of Payment:");
        lblNewLabel_3_1.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3_1.setBounds(72, 226, 149, 29);
        contentPane.add(lblNewLabel_3_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(247, 233, 98));
        panel_2.setBounds(10, 264, 503, 4);
        contentPane.add(panel_2);

        JLabel lblNewLabel_2_1 = new JLabel("Booking Summary");
        lblNewLabel_2_1.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblNewLabel_2_1.setBounds(62, 279, 173, 29);
        contentPane.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_3_2 = new JLabel("(Name of the user)");
        lblNewLabel_3_2.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3_2.setBounds(248, 193, 300, 29); // Adjusted width to fit longer text
        contentPane.add(lblNewLabel_3_2);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "password");

            Statement st = con.createStatement();

            String sql = "SELECT first_name, last_name FROM users ORDER BY id DESC LIMIT 1";

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                String fullName = lastName + ", " + firstName;

                System.out.println("Retrieved user name: " + fullName);

                lblNewLabel_3_2.setText(fullName);
            } else {
                System.out.println("No data returned from the query");
            }

            // Close the connection
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        JLabel lblNewLabel_3_2_1 = new JLabel("(Mode of payment)");
        lblNewLabel_3_2_1.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3_2_1.setBounds(248, 226, 149, 29);
        contentPane.add(lblNewLabel_3_2_1);
        if (previousWindow != null) {
            lblNewLabel_3_2_1.setText(previousWindow);
        }
        
        
        
        
        JButton btnNewButton = new JButton("CONFIRM BOOKING");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = "<html><center><b>THANK YOU FROM STAYCAY CENTRAL PH STAFFS</b><br><br>"
                        + "Thank you for choosing Staycay Central PH for your upcoming stay. "
                        + "We are delighted to confirm your reservation! <br>Your booking has been successfully processed, "
                        + "and we are excited to welcome you!<br><br>"
                        + "We look forward to hosting you and ensuring your stay is exceptional.<br><br>"
                        + "Thank you again for trusting us with your accommodations. Safe travels, and we’ll see you soon!</center></html>";

                Object[] options = {"OK"};

                int result = JOptionPane.showOptionDialog(null, message, "Confirmation",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null, options, options[0]);

                if (result == JOptionPane.OK_OPTION) {

                    userdashboardUI newUI = new userdashboardUI(loggedInEmail);
                    newUI.setVisible(true);

                    ((JFrame) ((JButton) e.getSource()).getTopLevelAncestor()).dispose();
                }
            }
        });

        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.setBounds(341, 513, 173, 40);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_3_3 = new JLabel("Transaction ID:");
        lblNewLabel_3_3.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3_3.setBounds(72, 163, 149, 29);
        contentPane.add(lblNewLabel_3_3);
        
        JLabel lblNewLabel_3_2_2 = new JLabel("0");
        lblNewLabel_3_2_2.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3_2_2.setBounds(248, 163, 149, 29);
        contentPane.add(lblNewLabel_3_2_2);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "password");

            Statement st = con.createStatement();

            String sql = "SELECT booking_id FROM bookings ORDER BY booking_id DESC LIMIT 1";

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                int bookingId = rs.getObject("booking_id") == null ? 0 : rs.getInt("booking_id");

                System.out.println("Retrieved booking_id: " + bookingId);

                lblNewLabel_3_2_2.setText("T" + bookingId);
            } else {
                System.out.println("No data returned from the query");
            }

            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();  
        } catch (Exception ex) {
            ex.printStackTrace();  
        }
        
        JLabel lblNewLabel_3_3_1 = new JLabel("Reservation ID:");
        lblNewLabel_3_3_1.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3_3_1.setBounds(245, 279, 129, 29);
        contentPane.add(lblNewLabel_3_3_1);     
        
        JLabel w = new JLabel("0");
        w.setFont(new Font("SansSerif", Font.BOLD, 16));
        w.setBounds(380, 279, 143, 29);
        contentPane.add(w);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "password");

            Statement st = con.createStatement();

            String sql = "SELECT Room_ID FROM rates ORDER BY Room_ID DESC LIMIT 1";

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                int roomID = rs.getObject("Room_ID") == null ? 0 : rs.getInt("Room_ID");

                System.out.println("Retrieved Room_ID: " + roomID);

                w.setText("R" + roomID);
            } else {
                System.out.println("No data returned from the query");
            }

            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();  
        } catch (Exception ex) {
            ex.printStackTrace();  
        }
        
        JLabel lblNewLabel_3_1_1 = new JLabel("Check In:");
        lblNewLabel_3_1_1.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3_1_1.setBounds(72, 310, 149, 29);
        contentPane.add(lblNewLabel_3_1_1);
        
        JLabel lblNewLabel_3_2_2_2 = new JLabel("(Date of Check In)");
        lblNewLabel_3_2_2_2.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3_2_2_2.setBounds(248, 310, 300, 29); // Adjusted width to fit longer text
        contentPane.add(lblNewLabel_3_2_2_2);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "password");

            Statement st = con.createStatement();

            String sql = "SELECT check_in_date FROM bookings ORDER BY booking_id DESC LIMIT 1";

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String checkInDate = rs.getString("check_in_date");

                System.out.println("Retrieved check_in_date: " + checkInDate);

                lblNewLabel_3_2_2_2.setText("" + checkInDate);
            } else {
                System.out.println("No data returned from the query");
            }

            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        JLabel lblNewLabel_3_1_1_1 = new JLabel("Check Out:");
        lblNewLabel_3_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3_1_1_1.setBounds(72, 338, 149, 29);
        contentPane.add(lblNewLabel_3_1_1_1);
        
        JLabel lblNewLabel_3_1_1_2 = new JLabel("Total of Night(s):");
        lblNewLabel_3_1_1_2.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3_1_1_2.setBounds(72, 363, 149, 29);
        contentPane.add(lblNewLabel_3_1_1_2);
        
        lblTotalPrice = new JLabel("Total Price: ");
        lblTotalPrice.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTotalPrice.setBounds(62, 454, 146, 38);
        contentPane.add(lblTotalPrice);
        
        JLabel lblNewLabel_3_2_2_2_1 = new JLabel("(Date of Check Out)");
        lblNewLabel_3_2_2_2_1.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3_2_2_2_1.setBounds(248, 338, 149, 29);
        contentPane.add(lblNewLabel_3_2_2_2_1);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "password");

            Statement st = con.createStatement();

            String sql = "SELECT check_out_date FROM bookings ORDER BY booking_id DESC LIMIT 1";

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String checkOutDate = rs.getString("check_out_date");

                System.out.println("Retrieved check_out_date: " + checkOutDate);

                lblNewLabel_3_2_2_2_1.setText("" + checkOutDate);
            } else {
                System.out.println("No data returned from the query");
            }

            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        JLabel lblNewLabel_3_2_2_2_2 = new JLabel("(Total of Night(s))");
        lblNewLabel_3_2_2_2_2.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3_2_2_2_2.setBounds(248, 363, 149, 29);
        contentPane.add(lblNewLabel_3_2_2_2_2);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "password");

            Statement st = con.createStatement();

            String sql = "SELECT num_nights FROM bookings ORDER BY booking_id DESC LIMIT 1";

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                int numNights = rs.getObject("num_nights") == null ? 0 : rs.getInt("num_nights");

                System.out.println("Retrieved num_nights: " + numNights);

                lblNewLabel_3_2_2_2_2.setText("" + numNights);
            } else {
                System.out.println("No data returned from the query");
            }

            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();  
        } catch (Exception ex) {
            ex.printStackTrace();  
        }
        
        
        JLabel lblNewLabel_3_1_1_2_1 = new JLabel("Type of Room");
        lblNewLabel_3_1_1_2_1.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3_1_1_2_1.setBounds(72, 391, 149, 29);
        contentPane.add(lblNewLabel_3_1_1_2_1);
        
        JLabel lblNewLabel_3_2_2_2_2_1 = new JLabel("(Type of Room)");
        lblNewLabel_3_2_2_2_2_1.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3_2_2_2_2_1.setBounds(248, 391, 149, 29);
        contentPane.add(lblNewLabel_3_2_2_2_2_1);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "password");

            Statement st = con.createStatement();

            String sql = "SELECT Room_Type FROM rates ORDER BY Room_ID DESC LIMIT 1";

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                // Retrieve Room_Type as a String
                String roomType = rs.getString("Room_Type");

                if (roomType == null || roomType.isEmpty()) {
                    roomType = "N/A"; // Default value if Room_Type is null or empty
                }

                System.out.println("Retrieved Room_Type: " + roomType);

                lblNewLabel_3_2_2_2_2_1.setText(roomType);
            } else {
                System.out.println("No data returned from the query");
            }

            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        
        JLabel lblNewLabel_3_1_1_2_1_1 = new JLabel("Room Quantity");
        lblNewLabel_3_1_1_2_1_1.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3_1_1_2_1_1.setBounds(72, 420, 149, 29);
        contentPane.add(lblNewLabel_3_1_1_2_1_1);
        
        JLabel lblNewLabel_3_2_2_2_2_1_1 = new JLabel("(Quantity)");
        lblNewLabel_3_2_2_2_2_1_1.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNewLabel_3_2_2_2_2_1_1.setBounds(248, 420, 149, 29);
        contentPane.add(lblNewLabel_3_2_2_2_2_1_1);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "password");

            Statement st = con.createStatement();

            String sql = "SELECT Room_Quantity FROM rates ORDER by Room_ID DESC LIMIT 1";

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                int roomQuantity = rs.getObject("Room_Quantity") == null ? 0 : rs.getInt("Room_Quantity");

                System.out.println("Retrieved Room_Quantity: " + roomQuantity);

                lblNewLabel_3_2_2_2_2_1_1.setText("" + roomQuantity);
            } else {
                System.out.println("No data returned from the query");
            }

            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();  
        } catch (Exception ex) {
            ex.printStackTrace();  
        }
        
        
        
        
        
        JLabel Total = new JLabel("0");
        Total.setFont(new Font("Tahoma", Font.BOLD, 18));
        Total.setBounds(248, 466, 233, 14);
        contentPane.add(Total);
        
        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBackground(new Color(247, 233, 98));
        panel_2_1.setBounds(10, 454, 503, 4);
        contentPane.add(panel_2_1);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "password");

            Statement st = con.createStatement();

            // Query to retrieve the latest entry from the TotalPrice table
            String sql = "SELECT total_price, is_discounted FROM TotalPrice ORDER BY id DESC LIMIT 1";

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                // Retrieve total price and discount status
                double totalPrice = rs.getObject("total_price") == null ? 0 : rs.getDouble("total_price");
                boolean isDiscounted = rs.getBoolean("is_discounted");

                // Format the price
                DecimalFormat formatter = new DecimalFormat("#,###.00");

                if (isDiscounted) {
                    // If discounted, format and display the discounted price
                    System.out.println("Discounted Price: PHP " + formatter.format(totalPrice));
                    Total.setText("PHP " + formatter.format(totalPrice));
                } else {
                    // If not discounted, display the regular price
                    System.out.println("Total Price: PHP " + formatter.format(totalPrice));
                    Total.setText("PHP " + formatter.format(totalPrice));
                }
            } else {
                System.out.println("No data returned from the query");
            }

            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();  
        } catch (Exception ex) {
            ex.printStackTrace();  
        }





    /**
     * Calculate and update the total price displayed.
     */
   
}
}
