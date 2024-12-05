package FProject;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class aboutUI extends JFrame {
	
	private static String loggedInEmail;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    private static final String URL = "jdbc:mysql://localhost:3306/userdata";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    aboutUI frame = new aboutUI();
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
    public aboutUI() {
    	
    	String loggedInEmail = SessionManager.getInstance().getLoggedInEmail();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1020, 590);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 220));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(247, 233, 98));
        panel.setBounds(0, 0, 1004, 76);
        contentPane.add(panel);

        JLabel lblNewLabel = new JLabel("Staycay Central PH");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 24));
        lblNewLabel.setBounds(10, 11, 264, 54);
        panel.add(lblNewLabel);

        JButton btnNewButton_1 = new JButton("PROFILE");
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        userprofile newHomeFrame = new userprofile(loggedInEmail);
				newHomeFrame.setVisible(true);
				dispose();
			}
		});
        btnNewButton_1.setBackground(Color.WHITE);
        btnNewButton_1.setBounds(1173, 11, 104, 23);
        panel.add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("SIGN-OUT");
        btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userlogregUI newHomeFrame = new userlogregUI();
				newHomeFrame.setVisible(true);
				dispose();
			}
		});
        btnNewButton_1_1.setBackground(Color.WHITE);
        btnNewButton_1_1.setBounds(1173, 42, 104, 23);
        panel.add(btnNewButton_1_1);

        JButton btnHome = new JButton("HOME");
        btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userdashboardUI newHomeFrame = new userdashboardUI(loggedInEmail);
                newHomeFrame.setVisible(true);
                dispose();
            }
        });
        btnHome.setForeground(Color.BLACK);
        btnHome.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnHome.setBackground(Color.WHITE);
        btnHome.setBounds(284, 11, 104, 54);
        panel.add(btnHome);

        JButton btnNewButton_1_1_1 = new JButton("SIGN-OUT");
        btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userlogregUI newHomeFrame = new userlogregUI();
				newHomeFrame.setVisible(true);
				dispose();
			}
		});
        btnNewButton_1_1_1.setBackground(Color.WHITE);
        btnNewButton_1_1_1.setBounds(890, 31, 104, 23);
        panel.add(btnNewButton_1_1_1);

        JLabel lblNewLabel_4 = new JLabel("");
        ImageIcon userImgIcon = new ImageIcon(aboutUI.class.getResource("/FProject/images/user-img.png"));
        Image userImgScaled = userImgIcon.getImage().getScaledInstance(67, 54, Image.SCALE_SMOOTH);
        lblNewLabel_4.setIcon(new ImageIcon(userImgScaled));
        lblNewLabel_4.setBounds(813, 11, 67, 54);
        panel.add(lblNewLabel_4);

        JButton btnAboutUs = new JButton("ABOUT US");
        btnAboutUs.setForeground(Color.BLACK);
        btnAboutUs.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnAboutUs.setBackground(Color.WHITE);
        btnAboutUs.setBounds(398, 11, 150, 54);
        panel.add(btnAboutUs);

        JLabel lblNewLabel_1 = new JLabel("ABOUT US");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel_1.setBounds(10, 87, 165, 29);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Welcome to Staycay Central PH!");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel_2.setBounds(42, 165, 391, 29);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel(
                "<html>At Staycay Central PH, we understand that every journey deserves a comfortable stay. Whether you're planning a weekend escape, a business trip, or a special occasion, we make booking the perfect accommodation simple, convenient, and stress-free.</html>");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(20, 205, 458, 150);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_3_1 = new JLabel(
                "<html>Our platform offers a curated selection of top-quality rooms, tailored to meet diverse preferences and budgets. From cozy spaces for solo travelers to luxurious suites for families, we ensure your stay is as relaxing and enjoyable as possible.</html>");
        lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3_1.setBounds(20, 369, 458, 150);
        contentPane.add(lblNewLabel_3_1);

        JLabel lblNewLabel_5 = new JLabel("");
        ImageIcon logoIcon = new ImageIcon(aboutUI.class.getResource("/FProject/images/staycay-logo.png"));
        Image logoScaled = logoIcon.getImage().getScaledInstance(493, 396, Image.SCALE_SMOOTH);
        lblNewLabel_5.setIcon(new ImageIcon(logoScaled));
        lblNewLabel_5.setBounds(490, 123, 493, 396);
        contentPane.add(lblNewLabel_5);

    

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

