package FProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class userdashboardUI extends JFrame {

	private static String loggedInEmail;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userdashboardUI frame = new userdashboardUI(loggedInEmail);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public userdashboardUI(String email) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1303, 811);
		contentPane = new JPanel();
		contentPane.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
			}
		});
		userdashboardUI.loggedInEmail = email;
		contentPane.setBackground(new Color(255, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(247, 233, 98));
		panel.setBounds(0, 0, 1287, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Staycay Central PH");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(10, 11, 264, 54);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 24));
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
		btnNewButton_1_1.setBounds(1173, 31, 104, 23);
		panel.add(btnNewButton_1_1);
		
		JButton btnHome = new JButton("HOME");
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 userdashboardUI newHomeFrame = new userdashboardUI(loggedInEmail);
				newHomeFrame.setVisible(true);
				dispose();
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHome.setBackground(new Color(255, 255, 255));
		btnHome.setBounds(284, 11, 104, 54);
		panel.add(btnHome);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(new ImageIcon(userdashboardUI.class.getResource("/FProject/images/user-img.png"))
		.getImage().getScaledInstance(67, 54, Image.SCALE_SMOOTH)));
		lblNewLabel_4.setBounds(1096, 11, 67, 54);
		panel.add(lblNewLabel_4);
		
		JButton btnAboutUs = new JButton("ABOUT US");
		btnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutUI newHomeFrame = new aboutUI();
				newHomeFrame.setVisible(true);
				dispose();
			}
		});
		btnAboutUs.setForeground(Color.BLACK);
		btnAboutUs.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAboutUs.setBackground(Color.WHITE);
		btnAboutUs.setBounds(398, 11, 150, 54);
		panel.add(btnAboutUs);

		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon(userdashboardUI.class.getResource("/FProject/images/deluxe-img.jpg"))
		.getImage().getScaledInstance(388, 245, Image.SCALE_SMOOTH)));
		lblNewLabel_1.setBounds(39, 87, 388, 245);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(new ImageIcon(userdashboardUI.class.getResource("/FProject/images/premier-img.jpg"))
		.getImage().getScaledInstance(388, 245, Image.SCALE_SMOOTH)));
		lblNewLabel_1_1.setBounds(449, 87, 388, 245);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(new ImageIcon(userdashboardUI.class.getResource("/FProject/images/executive-img.jpg"))
		.getImage().getScaledInstance(388, 245, Image.SCALE_SMOOTH)));
		lblNewLabel_1_2.setBounds(859, 87, 388, 245);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("DELUXE ROOM");
		lblNewLabel_2.setForeground(new Color(155, 113, 7));
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 32));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(39, 343, 388, 53);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("PREMIER ROOM");
		lblNewLabel_2_1.setForeground(new Color(155, 113, 7));
		lblNewLabel_2_1.setFont(new Font("Serif", Font.BOLD, 32));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(449, 343, 388, 53);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("EXECUTIVE ROOM");
		lblNewLabel_2_2.setForeground(new Color(155, 113, 7));
		lblNewLabel_2_2.setFont(new Font("Serif", Font.BOLD, 32));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(859, 343, 388, 53);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3 = new JLabel("<html>Our Deluxe Room offers the perfect retreat for a couple or a small family of 3. Designed with comfort and style in mind, this room combines elegance and functionality, ensuring a relaxing stay for all guests.</html>");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(39, 407, 388, 237);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("<html>Our Premier Room is designed for comfort and flexibility, accommodating 2 to 4 people. Whether you're enjoying a romantic getaway or traveling with family, this room provides the perfect blend of luxury and convenience.</html>");
		lblNewLabel_3_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblNewLabel_3_1.setBounds(449, 407, 388, 237);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("<html>Experience the perfect blend of luxury and space in our Executive Room, designed to accommodate 4 to 6 people. Ideal for larger families, small groups, or guests needing extra room to relax or work, this room offers a premium stay with all the comforts you need.</html>");
		lblNewLabel_3_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblNewLabel_3_1_1.setBounds(859, 407, 388, 237);
		contentPane.add(lblNewLabel_3_1_1);
		
		JButton btnNewButton = new JButton("BOOK NOW");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        cincoutdateUI newHomeFrame = new cincoutdateUI("Executive");  // Pass the room type
		        newHomeFrame.setVisible(true);
		        dispose();
		    }
		});
		btnNewButton.setBackground(new Color(249, 144, 83));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 28));
		btnNewButton.setBounds(961, 697, 208, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("BOOK NOW");
		btnNewButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        cincoutdateUI newHomeFrame = new cincoutdateUI("Premier");  // Pass the room type
		        newHomeFrame.setVisible(true);
		        dispose();
		    }
		});
		btnNewButton_2.setBackground(new Color(249, 144, 83));
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 28));
		btnNewButton_2.setBounds(549, 697, 208, 41);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("BOOK NOW");
		btnNewButton_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        cincoutdateUI newHomeFrame = new cincoutdateUI("Deluxe");  // Pass the room type
		        newHomeFrame.setVisible(true);
		        dispose();
		    }
		});
		btnNewButton_3.setBackground(new Color(249, 133, 83));
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 28));
		btnNewButton_3.setBounds(125, 697, 208, 41);
		contentPane.add(btnNewButton_3);
	}
}
