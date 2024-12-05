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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class qrcodeUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String previousWindow;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    qrcodeUI frame = new qrcodeUI();
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
    public qrcodeUI() {
    	this.previousWindow = previousWindow;

    	String loggedInEmail = SessionManager.getInstance().getLoggedInEmail();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 686, 673);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 220));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(247, 233, 98));
        panel.setBounds(0, 0, 670, 76);
        contentPane.add(panel);

        JLabel lblNewLabel = new JLabel("Staycay Central PH");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 24));
        lblNewLabel.setBounds(10, 11, 264, 54);
        panel.add(lblNewLabel);

        JButton btnNewButton_1 = new JButton("PROFILE");
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_1.setBounds(1143, 11, 104, 23);
        panel.add(btnNewButton_1);

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

        JButton btnNewButton_1_1_1 = new JButton("SIGN-OUT");
        btnNewButton_1_1_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		userlogregUI newHomeFrame = new userlogregUI();
				newHomeFrame.setVisible(true);
				dispose();
        	}
        });
        btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_1_1_1.setBounds(556, 31, 104, 23);
        panel.add(btnNewButton_1_1_1);
        
        ImageIcon userImageIcon = new ImageIcon(qrcodeUI.class.getResource("/FProject/images/user-img.png"));
        Image userImage = userImageIcon.getImage().getScaledInstance(67, 54, Image.SCALE_SMOOTH);
        JLabel lblNewLabel_4_1 = new JLabel(new ImageIcon(userImage));
        lblNewLabel_4_1.setBounds(479, 11, 67, 54);
        panel.add(lblNewLabel_4_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(148, 119, 348, 313);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        ImageIcon qrImageIcon = new ImageIcon(qrcodeUI.class.getResource("/FProject/images/nevergonnagiveyouup.png"));
        Image qrImage = qrImageIcon.getImage().getScaledInstance(328, 291, Image.SCALE_SMOOTH);
        JLabel lblNewLabel_5 = new JLabel(new ImageIcon(qrImage));
        lblNewLabel_5.setBounds(10, 11, 328, 291);
        panel_1.add(lblNewLabel_5);

        JLabel lblNewLabel_1 = new JLabel("QR Code");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(292, 87, 105, 21);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Send to this account Number:");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2.setBounds(173, 475, 316, 33);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("0912-345-6789");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_3.setBounds(183, 508, 294, 33);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("OR");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_4.setBounds(316, 443, 105, 21);
        contentPane.add(lblNewLabel_4);

        JButton btnNewButton = new JButton("CONFIRM BOOKING");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		gcashUI newHomeFrame = new gcashUI();
				newHomeFrame.setVisible(true);
				dispose();
        	}
        });
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton.setBounds(89, 552, 223, 50);
        contentPane.add(btnNewButton);

        JButton btnCancel = new JButton("CANCEL");
        btnCancel.setBackground(new Color(255, 255, 255));
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        		paymentUI newHomeFrame = new paymentUI(previousWindow);
				newHomeFrame.setVisible(true);
				dispose();
            }
        });
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnCancel.setBounds(354, 552, 223, 50);
        contentPane.add(btnCancel);
    }
}
