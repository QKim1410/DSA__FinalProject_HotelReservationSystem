package FProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class personalinfoUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstname;
	private JTextField Lastname;
	private JTextField email;
	private JTextField retype;
	private JTextField contact;
	private JTextField address;
	private JTextField request;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					personalinfoUI frame = new personalinfoUI();
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
	public personalinfoUI() {
		String loggedInEmail = SessionManager.getInstance().getLoggedInEmail();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 797);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 958, 76);
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
		btnNewButton_1_1.setBounds(842, 31, 104, 23);
		panel.add(btnNewButton_1_1);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userdashboardUI newHomeFrame = new userdashboardUI(loggedInEmail);
				newHomeFrame.setVisible(true);
				dispose();
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHome.setBackground(new Color(255, 255, 255));
		btnHome.setBounds(284, 12, 104, 54);
		panel.add(btnHome);
		
		ImageIcon originalIcon = new ImageIcon(personalinfoUI.class.getResource("/FProject/images/user-img.png"));
		Image img = originalIcon.getImage();
		Image scaledImg = img.getScaledInstance(67, 54, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(scaledIcon);
		lblNewLabel_4.setBounds(765, 11, 67, 54);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Personal Information");
		lblNewLabel_1.setBounds(10, 87, 277, 29);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("First Name");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(20, 127, 110, 29);
		contentPane.add(lblNewLabel_2_1);
		
		firstname = new JTextField();
		firstname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		firstname.setBounds(10, 156, 330, 30);
		contentPane.add(firstname);
		firstname.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Last Name");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(458, 127, 110, 29);
		contentPane.add(lblNewLabel_2_1_1);
		
		Lastname = new JTextField();
		Lastname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Lastname.setColumns(10);
		Lastname.setBounds(458, 156, 330, 30);
		contentPane.add(Lastname);
		
		JLabel lblNewLabel_2_1_2_2 = new JLabel("Email Address");
		lblNewLabel_2_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_2_2.setBounds(20, 197, 165, 29);
		contentPane.add(lblNewLabel_2_1_2_2);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 18));
		email.setColumns(10);
		email.setBounds(10, 237, 425, 30);
		contentPane.add(email);
		
		retype = new JTextField();
		retype.setFont(new Font("Tahoma", Font.PLAIN, 18));
		retype.setColumns(10);
		retype.setBounds(458, 237, 425, 30);
		contentPane.add(retype);
		
		JLabel lblNewLabel_2_1_2_2_1 = new JLabel("Re-type Email Address");
		lblNewLabel_2_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_2_2_1.setBounds(458, 197, 222, 29);
		contentPane.add(lblNewLabel_2_1_2_2_1);
		
		JLabel lblNewLabel_2_1_2_2_2 = new JLabel("Contact Number");
		lblNewLabel_2_1_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_2_2_2.setBounds(20, 278, 165, 29);
		contentPane.add(lblNewLabel_2_1_2_2_2);
		
		contact = new JTextField();
		contact.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contact.setColumns(10);
		contact.setBounds(10, 318, 425, 30);
		contentPane.add(contact);
		
		JLabel lblNewLabel_2_1_2_2_2_1 = new JLabel("Address");
		lblNewLabel_2_1_2_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_2_2_2_1.setBounds(20, 359, 165, 29);
		contentPane.add(lblNewLabel_2_1_2_2_2_1);
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 18));
		address.setColumns(10);
		address.setBounds(10, 407, 917, 30);
		contentPane.add(address);
		
		JLabel lblNewLabel_2_1_2_2_2_1_1 = new JLabel("Special Request\r\n");
		lblNewLabel_2_1_2_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_2_2_2_1_1.setBounds(10, 448, 165, 29);
		contentPane.add(lblNewLabel_2_1_2_2_2_1_1);
		
		request = new JTextField();
		request.setFont(new Font("Tahoma", Font.PLAIN, 18));
		request.setBounds(10, 488, 938, 201);
		contentPane.add(request);
		request.setColumns(10);
		
		JButton btnNewButton = new JButton("CANCEL");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(719, 700, 230, 47);
		contentPane.add(btnNewButton);
		
		JButton Continue = new JButton("CONTINUE");
		Continue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = firstname.getText();
		        String lastName = Lastname.getText();
		        String contactNumber = contact.getText();
		        String addressValue = address.getText();
		        String specialRequest = request.getText();
		        
				userdashboardUI newHomeFrame = new userdashboardUI(loggedInEmail);
				newHomeFrame.setVisible(true);
				dispose();
			}
		});
		Continue.setFont(new Font("Tahoma", Font.BOLD, 18));
		Continue.setBackground(Color.WHITE);
		Continue.setBounds(464, 700, 230, 47);
		contentPane.add(Continue);
	}
}
