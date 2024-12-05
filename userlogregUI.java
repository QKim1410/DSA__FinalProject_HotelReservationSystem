package FProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class userlogregUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userlogregUI frame = new userlogregUI();
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
	public userlogregUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log-In");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(10, 11, 102, 41);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setBounds(28, 88, 57, 27);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setBounds(28, 154, 95, 27);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(38, 116, 256, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(38, 181, 256, 27);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Log-In");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String email = textField.getText(); 
			        String password = textField_1.getText(); 

			        if (email.isEmpty() || password.isEmpty()) {
			            JOptionPane.showMessageDialog(null, "Please enter both email and password.");
			            return;
			        }

			        boolean isAuthenticated = UserAuthentication.authenticate(email, password);

			        if (isAuthenticated) {
			            SessionManager.getInstance().setLoggedInEmail(email);
			            
			            userdashboardUI newHomeFrame = new userdashboardUI(email);
			            newHomeFrame.setVisible(true);
			            dispose();
			        } else {
			            JOptionPane.showMessageDialog(null, "Invalid email or password.");
			        }
			    }
			});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(38, 233, 109, 31);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(255, 255, 255));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancel.setBounds(185, 233, 109, 31);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_2 = new JLabel("If you don't have account");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(38, 282, 167, 22);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Sign-Up");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usersignUI newHomeFrame = new usersignUI();
				newHomeFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(205, 282, 89, 23);
		contentPane.add(btnNewButton_1);

		ImageIcon originalImage = new ImageIcon(userlogregUI.class.getResource("/FProject/images/user-img.png"));
		Image scaledImage = originalImage.getImage().getScaledInstance(225, 207, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(scaledIcon);
		lblNewLabel_3.setBounds(327, 97, 225, 207);
		contentPane.add(lblNewLabel_3);
	}
}
