package FProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gcashUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gcashUI frame = new gcashUI();
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
	public gcashUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 435);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(247, 233, 98));
		panel.setBounds(0, 0, 671, 76);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Staycay Central PH");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(10, 11, 264, 54);
		panel.add(lblNewLabel);
		
		JLabel lblUserImage = new JLabel((Icon) null);
		lblUserImage.setBounds(1064, 11, 69, 54);
		panel.add(lblUserImage);
		
		JButton btnNewButton_1 = new JButton("PROFILE");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(1143, 11, 104, 23);
		panel.add(btnNewButton_1);
		
		JButton btnHome = new JButton("HOME");
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(284, 12, 104, 54);
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
		btnNewButton_1_1_1.setBounds(556, 31, 104, 23);
		panel.add(btnNewButton_1_1_1);
		
		ImageIcon userImageIcon = new ImageIcon(gcashUI.class.getResource("/FProject/images/user-img.png"));
		Image userImage = userImageIcon.getImage().getScaledInstance(69, 54, Image.SCALE_SMOOTH); // Adjust width and height here
		JLabel lblUserImage_1_1 = new JLabel(new ImageIcon(userImage));
		lblUserImage_1_1.setBounds(477, 11, 69, 54);
		panel.add(lblUserImage_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("GCASH");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 87, 96, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("GCASH Reference #:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(20, 123, 281, 29);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(30, 151, 631, 30);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("AMOUNT:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(20, 187, 281, 29);
		contentPane.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(30, 216, 631, 30);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("DATE:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(20, 250, 281, 29);
		contentPane.add(lblNewLabel_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(30, 282, 631, 30);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("CANCEL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		qrcodeUI newHomeFrame = new qrcodeUI();
				newHomeFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(481, 340, 180, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("CONTINUE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receiptUI paymentFrame = new receiptUI("Gcash");
		        paymentFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(276, 340, 180, 45);
		contentPane.add(btnNewButton_2);
	}
}
