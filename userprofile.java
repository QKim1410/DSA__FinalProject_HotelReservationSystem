package FProject;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userprofile extends JFrame {

    private JPanel contentPane;
    private JLabel email;
    private JLabel contact;
    private JLabel date;
    private JLabel userId;

    private static final String URL = "jdbc:mysql://localhost:3306/userdata";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    userprofile frame = new userprofile("loggedInUsername"); // Use an actual logged in username here
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public userprofile(String loggedInEmail) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 718, 424);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 220));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(247, 233, 98));
        panel.setBounds(0, 0, 704, 49);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("PROFILE");
        lblNewLabel.setBounds(10, 11, 88, 25);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));

        // Labels for profile data
        userId = new JLabel("User ID:");
        userId.setFont(new Font("Tahoma", Font.BOLD, 14));
        userId.setBounds(271, 78, 122, 14);
        contentPane.add(userId);

        email = new JLabel("New label");
        email.setToolTipText("");
        email.setFont(new Font("Tahoma", Font.PLAIN, 14));
        email.setBounds(29, 141, 212, 23);
        contentPane.add(email);

        contact = new JLabel("New label");
        contact.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contact.setBounds(29, 222, 212, 23);
        contentPane.add(contact);

        date = new JLabel("New label");
        date.setFont(new Font("Tahoma", Font.PLAIN, 14));
        date.setBounds(387, 141, 307, 23);
        contentPane.add(date);

        // Separators for UI structure
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 198, 722, 14);
        contentPane.add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(0, 117, 722, 14);
        contentPane.add(separator_1);

        JSeparator separator_2 = new JSeparator();
        separator_2.setOrientation(SwingConstants.VERTICAL);
        separator_2.setBounds(342, 117, 12, 281);
        contentPane.add(separator_2);
        
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userdashboardUI newHomeFrame = new userdashboardUI(loggedInEmail);
				newHomeFrame.setVisible(true);
				dispose();
			}
		});
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHome.setBackground(new Color(255, 255, 255));
		btnHome.setBounds(576, 2, 118, 42);
		panel.add(btnHome);

        loadProfileData(loggedInEmail); // Load the profile data for the logged-in user
    }

    private void loadProfileData(String email) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT id, email, contact_number, date_created FROM users WHERE email = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, email); // Use email as the parameter
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        userId.setText("User ID: " + rs.getString("id"));
                        this.email.setText("Email: " + rs.getString("email"));
                        contact.setText("Contact Number: " + rs.getString("contact_number"));
                        date.setText("Date Created: " + rs.getString("date_created"));
                    } else {
                        userId.setText("User ID: ");
                        this.email.setText("Email: ");
                        contact.setText("Contact Number: ");
                        date.setText("Date Created: ");
                        JOptionPane.showMessageDialog(this, "No profile data found for the given email.", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading profile data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
