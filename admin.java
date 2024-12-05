package FProject;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class admin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    admin frame = new admin();
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
    public admin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 371, 204);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 220));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Admin");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setBounds(145, 11, 57, 40);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String keycode = new String(passwordField.getPassword());
                if (keycode.equals("admin123")) { 
                    admin_dashboard pao = new admin_dashboard();
                    pao.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Invalid keycode. Please try again.", 
                                                  "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setBounds(256, 115, 89, 23);
        contentPane.add(btnNewButton);

        JButton btnReturn = new JButton("<--");
        btnReturn.setBackground(new Color(255, 255, 255));
        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                useradminUI back = new useradminUI();
                back.setVisible(true);
                dispose();
            }
        });
        btnReturn.setVerticalAlignment(SwingConstants.TOP);
        btnReturn.setBounds(10, 115, 49, 23);
        contentPane.add(btnReturn);

        passwordField = new JPasswordField();
        passwordField.setBounds(119, 68, 119, 20);
        contentPane.add(passwordField);

        JLabel lblNewLabel_1 = new JLabel("Keycode:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_1.setBounds(20, 69, 89, 14);
        contentPane.add(lblNewLabel_1);
    }
}
