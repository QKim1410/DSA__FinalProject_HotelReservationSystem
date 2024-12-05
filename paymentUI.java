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

public class paymentUI extends JFrame {

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
                    paymentUI frame = new paymentUI("deluxe"); // Example usage
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
    public paymentUI(String previousWindow) {
        this.previousWindow = previousWindow;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 769, 511);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 220));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 753, 76);
        panel.setLayout(null);
        panel.setBackground(new Color(247, 233, 98));
        contentPane.add(panel);

        JLabel lblNewLabel = new JLabel("Staycay Central PH");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 24));
        lblNewLabel.setBounds(10, 11, 264, 54);
        panel.add(lblNewLabel);

        JButton btnHome = new JButton("HOME");
        btnHome.setForeground(Color.BLACK);
        btnHome.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnHome.setBackground(Color.WHITE);
        btnHome.setBounds(284, 11, 104, 54);
        panel.add(btnHome);

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
        btnNewButton_1_1.setBounds(636, 31, 104, 23);
        panel.add(btnNewButton_1_1);

        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(paymentUI.class.getResource("/FProject/images/user-img.png")));
        lblNewLabel_4.setBounds(559, 11, 67, 54);
        panel.add(lblNewLabel_4);

        ImageIcon userImage = new ImageIcon(paymentUI.class.getResource("/FProject/images/user-img.png"));
        Image scaledImage = userImage.getImage().getScaledInstance(67, 54, Image.SCALE_SMOOTH);
        lblNewLabel_4.setIcon(new ImageIcon(scaledImage));
        lblNewLabel_4.setBounds(559, 11, 67, 54);
        panel.add(lblNewLabel_4);

        JLabel lblNewLabel_2 = new JLabel("VISA & MASTERCARD");
        lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(37, 365, 280, 43);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("GCASH");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblNewLabel_2_1.setBounds(430, 365, 280, 43);
        contentPane.add(lblNewLabel_2_1);

        JLabel lblNewLabel_3 = new JLabel("Select Mode of Payment:");
        lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblNewLabel_3.setBounds(10, 87, 346, 36);
        contentPane.add(lblNewLabel_3);

        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mopcardUI newHomeFrame = new mopcardUI();
                newHomeFrame.setVisible(true);
                dispose();
            }
        });
        btnNewButton.setIcon(new ImageIcon(new ImageIcon(paymentUI.class.getResource("/FProject/images/visa-logo.png"))
            .getImage().getScaledInstance(336, 210, Image.SCALE_SMOOTH)));
        btnNewButton.setBounds(20, 144, 336, 210);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                qrcodeUI newHomeFrame = new qrcodeUI();
                newHomeFrame.setVisible(true);
                dispose();
            }
        });
        btnNewButton_1.setIcon(new ImageIcon(new ImageIcon(paymentUI.class.getResource("/FProject/images/gcash logo.png"))
            .getImage().getScaledInstance(336, 210, Image.SCALE_SMOOTH)));
        btnNewButton_1.setBounds(397, 144, 336, 210);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("CANCEL");
        btnNewButton_2.setBackground(new Color(255, 255, 255));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                navigateToPreviousWindow();
            }
        });
        btnNewButton_2.setFont(new Font("SansSerif", Font.BOLD, 24));
        btnNewButton_2.setBounds(579, 420, 154, 41);
        contentPane.add(btnNewButton_2);
    }

    private void navigateToPreviousWindow() {
        JFrame previousFrame = null;
        switch (previousWindow) {
            case "Deluxe":
                previousFrame = new deluxeUI(); // Replace with your actual class
                break;
            case "Premier":
                previousFrame = new premierUI(); // Replace with your actual class
                break;
            case "Executive":
                previousFrame = new executiveUI(); // Replace with your actual class
                break;
            default:
                System.out.println("Unknown previous window");
                return;
        }

        if (previousFrame != null) {
            previousFrame.setVisible(true);
        }
        dispose();
    }
}
