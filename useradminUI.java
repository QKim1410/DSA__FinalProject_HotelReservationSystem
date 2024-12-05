package FProject;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class useradminUI extends JFrame {
	
	private static String loggedInEmail;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					useradminUI frame = new useradminUI();
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
	public useradminUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 239, 184));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 245, 220));
		panel.setBounds(10, 11, 614, 449);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User and Admin Log-In");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(162, 47, 291, 29);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userlogregUI newHomeFrame = new userlogregUI();
				newHomeFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(new ImageIcon(useradminUI.class.getResource("/FProject/images/user-img.png"))
		.getImage().getScaledInstance(210, 172, Image.SCALE_SMOOTH)));
		btnNewButton.setBounds(61, 117, 210, 172);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin newHomeFrame = new admin();
				newHomeFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon(new ImageIcon(useradminUI.class.getResource("/FProject/images/admin-img.png"))
		.getImage().getScaledInstance(210, 172, Image.SCALE_SMOOTH)));
		btnNewButton_1.setBounds(343, 117, 210, 172);
		panel.add(btnNewButton_1);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUser.setBounds(134, 300, 74, 29);
		panel.add(lblUser);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAdmin.setBounds(409, 300, 86, 29);
		panel.add(lblAdmin);
	}
}
