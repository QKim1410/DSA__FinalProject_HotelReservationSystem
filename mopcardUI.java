package FProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

@SuppressWarnings("unused")
public class mopcardUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private String previousWindow;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mopcardUI frame = new mopcardUI();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public mopcardUI() {
		this.previousWindow = previousWindow;
		String loggedInEmail = SessionManager.getInstance().getLoggedInEmail();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 772);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 670, 76);
		panel.setLayout(null);
		panel.setBackground(new Color(247, 233, 98));
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

		JLabel lblUserImage_1_1 = new JLabel(new ImageIcon(new ImageIcon(mopcardUI.class.getResource("/FProject/images/user-img.png"))
		.getImage().getScaledInstance(69, 54, Image.SCALE_SMOOTH)));
		lblUserImage_1_1.setBounds(477, 11, 69, 54);
		panel.add(lblUserImage_1_1);

		
		JButton btnNewButton_5 = new JButton("CANCEL");
		btnNewButton_5.setBounds(367, 673, 281, 44);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		paymentUI newHomeFrame = new paymentUI(previousWindow);
				newHomeFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("CONTINUE");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receiptUI paymentFrame = new receiptUI("Visa/Mastercard");
		        paymentFrame.setVisible(true);
		        dispose();
			}
		});
		btnNewButton_5_1.setBounds(22, 673, 281, 44);
		btnNewButton_5_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_5_1.setBackground(new Color(255, 255, 255));
		contentPane.add(btnNewButton_5_1);
		
		JLabel lblNewLabel_1 = new JLabel("VISA & MasterCard");
		lblNewLabel_1.setBounds(10, 83, 461, 30);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Credit/Debit Card Number");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(22, 124, 281, 29);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(22, 154, 614, 30);
        ((PlainDocument) textField.getDocument()).setDocumentFilter(new NumericDocumentFilter(19));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("First Name");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(22, 195, 281, 29);
		contentPane.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(22, 223, 281, 30);
		contentPane.add(textField_1);
		
        ((AbstractDocument) textField_1.getDocument()).setDocumentFilter(new AlphabeticDocumentFilter());
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Last Name");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(355, 195, 281, 29);
		contentPane.add(lblNewLabel_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(355, 223, 281, 30);
		contentPane.add(textField_2);
		
        ((AbstractDocument) textField_2.getDocument()).setDocumentFilter(new AlphabeticDocumentFilter());

		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Expiry Month");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1_1.setBounds(22, 264, 127, 29);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox.setBounds(22, 293, 127, 30);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Expiry Year");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1_1_1.setBounds(264, 264, 127, 29);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040"}));
		comboBox_1.setBounds(264, 293, 127, 30);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("CVV / CVC / CVN");
		lblNewLabel_2_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1_1_2.setBounds(486, 264, 150, 29);
		contentPane.add(lblNewLabel_2_1_1_1_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setBounds(485, 293, 151, 30);
		((PlainDocument) textField_3.getDocument()).setDocumentFilter(new CVVDocumentFilter());
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Address");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_2.setBounds(22, 402, 281, 29);
		contentPane.add(lblNewLabel_2_1_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(22, 429, 614, 30);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("City");
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_2_1.setBounds(22, 465, 281, 29);
		contentPane.add(lblNewLabel_2_1_2_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(22, 492, 614, 30);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_2_1_2_2 = new JLabel("Postal Code");
		lblNewLabel_2_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_2_2.setBounds(22, 527, 281, 29);
		contentPane.add(lblNewLabel_2_1_2_2);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(22, 554, 614, 30);
		((PlainDocument) textField_6.getDocument()).setDocumentFilter(new PostalCodeFilter());
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_2_1_2_4 = new JLabel("Provinces");
		lblNewLabel_2_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_2_4.setBounds(22, 595, 281, 29);
		contentPane.add(lblNewLabel_2_1_2_4);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setBackground(new Color(255, 255, 255));
		comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"- Select Provinces -", "National Capital Region (NCR)", "Cordillera Administrative Region (CAR)", "Ilocos Region (Region I)", "Cagayan Valley (Region II)", "Central Luzon (Region III)", "CALABARZON (Region IV-A)", "MIMAROPA (Region IV-B)", "Bicol Region (Region V)", "Western Visayas (Region VI)", "Central Visayas (Region VII)", "Eastern Visayas (Region VIII)", "Zamboanga Peninsula (Region IX)", "Northern Mindanao (Region X)", "Davao Region (Region XI)", "SOCCSKSARGEN (Region XII)", "Caraga Region (Region XIII)", "Bangsamoro Autonomous Region in Muslim Mindanao (BARMM)"}));
		comboBox_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		comboBox_1_1_1.setBounds(22, 624, 614, 30);
		contentPane.add(comboBox_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Billing Information");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(22, 334, 167, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("<html>*Address should be the same with your credit/debit card account</html>");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(22, 353, 614, 38);
		contentPane.add(lblNewLabel_4);
		
	}
	static class NumericDocumentFilter  extends DocumentFilter {
			private int maxLength;
			
			public NumericDocumentFilter(int maxLength) {
	            this.maxLength = maxLength;
	        }

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
			    // Check if the text is numeric and does not exceed the maximum length
			    if (isNumeric(text)) {
			        int currentLength = fb.getDocument().getLength();
			        int newLength = currentLength - length + text.length(); // Adjust new length considering the replaced text

			        // If the new length is within 19 digits, allow replacement
			        if (newLength <= maxLength) {
			            super.replace(fb, offset, length, text, attrs);
			        }
			    }
			}
		        
		    public void remove1(FilterBypass fb, int offset, int length) throws BadLocationException {
	            super.remove(fb, offset, length);
	        }
		    
		    @Override
	        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
	            super.remove(fb, offset, length);
	        }
		    
		    // Check if the string is numeric
	        private boolean isNumeric(String text) {
	            return text.matches("\\d+");
	        }
	        
	        // Check if the total length after insert/replace will be between 16 and 19 digits
	        private boolean isWithinLength(FilterBypass fb, int newLength) throws BadLocationException {
	            int currentLength = fb.getDocument().getLength();
	            return (currentLength + newLength) <= maxLength && (currentLength + newLength) >= 16;
	        }
	    }
	
    static class AlphabeticDocumentFilter extends DocumentFilter {

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (isAlphabetic(string)) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs) throws BadLocationException {
            if (isAlphabetic(string)) {
                super.replace(fb, offset, length, string, attrs);
            }
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length);
        }

        // Check if the string contains only alphabetic characters
        private boolean isAlphabetic(String text) {
            return text.matches("[a-zA-Z]+");
        }
    }
    
    static class CVVDocumentFilter extends DocumentFilter {
        private static final int MAX_LENGTH = 3;

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (isNumeric(text) && isWithinLength(fb, text.length())) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        private boolean isNumeric(String text) {
            return text.matches("\\d*"); // Allow only digits
        }

        private boolean isWithinLength(FilterBypass fb, int newLength) throws BadLocationException {
            int currentLength = fb.getDocument().getLength();
            return (currentLength + newLength) <= MAX_LENGTH;
        }
    }
    
    static class PostalCodeFilter extends DocumentFilter {
        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (isNumeric(text)) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        private boolean isNumeric(String text) {
            return text.matches("\\d*"); // Allow only digits
        }
    }

    
}
	