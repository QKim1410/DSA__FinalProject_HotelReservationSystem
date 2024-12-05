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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class usersignUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField emailaddress;
    private JTextField confirmemail;
    private JLabel lblNewLabel_1_1_2;
    private JTextField firstname;
    private JLabel lblNewLabel_1_1_3;
    private JTextField lastname;
    private JLabel lblNewLabel_1_1;
    private JTextField password;
    private JLabel lblNewLabel_1_1_4;
    private JTextField confirmpassword;
    private JLabel lblNewLabel_1_1_5;
    private JTextField contact;
    private JLabel lblNewLabel_1_1_6;
    private JButton signup;
    private JButton btnCancel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    usersignUI frame = new usersignUI();
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
    public usersignUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 721, 640);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 220));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Register");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(10, 11, 140, 29);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Email Address:");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1_1_1.setBounds(21, 68, 149, 22);
        contentPane.add(lblNewLabel_1_1_1);
        
        emailaddress = new JTextField();
        emailaddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
        emailaddress.setColumns(10);
        emailaddress.setBounds(31, 95, 309, 22);
        contentPane.add(emailaddress);
        
        confirmemail = new JTextField();
        confirmemail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        confirmemail.setColumns(10);
        confirmemail.setBounds(31, 155, 309, 22);
        contentPane.add(confirmemail);
        
        lblNewLabel_1_1_2 = new JLabel("Confirm Email Address:");
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1_1_2.setBounds(21, 128, 225, 22);
        contentPane.add(lblNewLabel_1_1_2);
        
        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        firstname.setColumns(10);
        firstname.setBounds(31, 215, 309, 22);
        contentPane.add(firstname);
        
        lblNewLabel_1_1_3 = new JLabel("First Name:");
        lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1_1_3.setBounds(21, 188, 202, 22);
        contentPane.add(lblNewLabel_1_1_3);
        
        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lastname.setColumns(10);
        lastname.setBounds(31, 275, 309, 22);
        contentPane.add(lastname);
        
        lblNewLabel_1_1 = new JLabel("Last Name:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1_1.setBounds(21, 248, 202, 22);
        contentPane.add(lblNewLabel_1_1);
        
        password = new JPasswordField();
        password.setFont(new Font("Tahoma", Font.PLAIN, 18));
        password.setColumns(10);
        password.setBounds(31, 335, 309, 22);
        contentPane.add(password);
        
        lblNewLabel_1_1_4 = new JLabel("Password:");
        lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1_1_4.setBounds(21, 308, 202, 22);
        contentPane.add(lblNewLabel_1_1_4);
        
        confirmpassword = new JPasswordField();
        confirmpassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        confirmpassword.setColumns(10);
        confirmpassword.setBounds(31, 395, 309, 22);
        contentPane.add(confirmpassword);
        
        lblNewLabel_1_1_5 = new JLabel("Confirm Password:");
        lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1_1_5.setBounds(21, 368, 202, 22);
        contentPane.add(lblNewLabel_1_1_5);
        
        contact = new JTextField();
        contact.setFont(new Font("Tahoma", Font.PLAIN, 18));
        contact.setColumns(10);
        contact.setBounds(31, 455, 309, 22);
        contentPane.add(contact);
        
        lblNewLabel_1_1_6 = new JLabel("Contact Number:");
        lblNewLabel_1_1_6.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1_1_6.setBounds(21, 428, 202, 22);
        contentPane.add(lblNewLabel_1_1_6);
        
        signup = new JButton("Sign-Up");
        signup.setBackground(new Color(255, 255, 255));
        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  String email = emailaddress.getText();
                  String confirmEmail = confirmemail.getText();
                  String passwordText = new String(((JPasswordField) password).getPassword()); // Convert password to String
                  String confirmPasswordText = new String(((JPasswordField) confirmpassword).getPassword()); // Convert confirm password to String
                  String contactNumber = contact.getText();

                  if (!email.equals(confirmEmail)) {
                      JOptionPane.showMessageDialog(contentPane, "Emails do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                      return;
                  }
                  
                  if (!passwordText.equals(confirmPasswordText)) {
                      JOptionPane.showMessageDialog(contentPane, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                      return;
                  }
                  
                  if (!contactNumber.matches("\\d+")) {
                      JOptionPane.showMessageDialog(contentPane, "Contact number must contain only digits.", "Error", JOptionPane.ERROR_MESSAGE);
                      return;
                  }

                  boolean success = UserRegistration.registerUser(email, firstname.getText(), lastname.getText(), passwordText, contactNumber);
                  if (success) {
                      JOptionPane.showMessageDialog(contentPane, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                      userlogregUI newHomeFrame = new userlogregUI();
                      newHomeFrame.setVisible(true);
                      dispose();  
                  } else {
                      JOptionPane.showMessageDialog(contentPane, "Registration failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                  }
              }
          });
        signup.setFont(new Font("Tahoma", Font.BOLD, 18));
        signup.setBounds(61, 495, 109, 40);
        contentPane.add(signup);
        
        btnCancel = new JButton("Cancel");
        btnCancel.setBackground(new Color(255, 255, 255));
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userlogregUI newHomeFrame = new userlogregUI();
                newHomeFrame.setVisible(true);
                dispose();  // Close current frame
            }
        });
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnCancel.setBounds(206, 495, 103, 40);
        contentPane.add(btnCancel);

        ImageIcon originalImage = new ImageIcon(usersignUI.class.getResource("/FProject/images/register-img.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(225, 195, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(scaledIcon);
        lblNewLabel_3.setBounds(411, 192, 225, 195);
        contentPane.add(lblNewLabel_3);
    }
}
