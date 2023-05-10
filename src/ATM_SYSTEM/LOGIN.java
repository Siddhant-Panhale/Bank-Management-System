package ATM_SYSTEM;

import java.awt.*;
import javax.swing.*; // extends JFrame is a class import from spring to create frame
import java.awt.event.*; //implements ActionListener is interface import from awt.event use for give work or know the buttons are clicked
import java.sql.*;

public class LOGIN extends JFrame implements ActionListener {
	//Global Declaration
	JButton sign_in, clear, sign_up;
	JTextField cardTextField;	//Normal Text Field
	JPasswordField pinPassField;	//Hidden Text Field

	LOGIN() {
		setTitle("AUTOMATED TELLER MACHINE"); // Title to the Frame

		setLayout(null); // to build custom layout we have to set default layout as NULL

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo1.jpg")); // load the img
		Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT); // to change image size, 1st para is
																					// distance from left and 2nd is
																					// distance from top
		ImageIcon i3 = new ImageIcon(i2); // label function does not take Image() as input so we change Image to
											// ImageIcon
		JLabel label = new JLabel(i3);
		label.setBounds(50, 10, 150, 150); // image location and size, 1st para is distance from left and 2nd is
											// distance from top 3rd and 4th are height and width
		add(label); // Show the image on the frame

		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("logo.jpg")); // load the img
		Image i5 = i4.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT); // to change image size, 1st para is
																					// distance from left and 2nd is
																					// distance from top
		ImageIcon i6 = new ImageIcon(i5); // label function does not take Image() as input so we change Image to
											// ImageIcon
		JLabel label2 = new JLabel(i6);
		label2.setBounds(600, 10, 150, 150); // image location and size, 1st para is distance from left and 2nd is
												// distance from top 3rd and 4th are height and width
		add(label2); // Show the image on the frame

		JLabel heading = new JLabel("WELCOME TO ATM"); // Label for frame
		heading.setFont(new Font("Osward", Font.BOLD, 35)); // font to the text
		heading.setBounds(225, 40, 500, 40); // set location and height width
		add(heading); // Show the text in frame

		JLabel bank_name = new JLabel("BANK OF INDIA"); // Label for frame
		bank_name.setFont(new Font("Osward", Font.BOLD, 35)); // font to the text
		bank_name.setBounds(260, 125, 500, 40); // set location and height width
		add(bank_name); // Show the text in frame

		JLabel card_no = new JLabel("CARD NO  :  "); // Label for frame
		card_no.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		card_no.setBounds(200, 220, 120, 40); // set location and height width
		add(card_no); // Show the text in frame

		cardTextField = new JTextField(); // to get text of card no
		cardTextField.setBounds(325, 225, 250, 30); // to set location and height and width
		cardTextField.setFont(new Font("Arial", Font.BOLD, 20));	//to set font type and style 
		add(cardTextField); // display text field

		JLabel pin = new JLabel("PIN  :  "); // Label for frame
		pin.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		pin.setBounds(200, 270, 150, 40); // set location and height width
		add(pin); // Show the text in frame

		pinPassField = new JPasswordField(); // to get text but J-Password Field will hide it 
		pinPassField.setBounds(325, 275, 250, 30); // to set location and height and width
		pinPassField.setFont(new Font("Arial", Font.BOLD, 20));	//to set font type and style 
		add(pinPassField); // display text field

		sign_in = new JButton("SIGN IN"); // add button for sign in
		sign_in.setBounds(275, 325, 100, 30); // set location and height and width
		sign_in.addActionListener(this); // know when user click on sign_in and perform actions
		add(sign_in); // display button

		clear = new JButton("CLEAR"); // add button for clear
		clear.setBounds(415, 325, 100, 30); // set location and height and width
		clear.addActionListener(this); // know when user click on clear and perform actions
		add(clear); // display button

		sign_up = new JButton("SIGN UP"); // add button for sign up
		sign_up.setBounds(350, 375, 100, 30); // set location and height and width
		sign_up.addActionListener(this); // know when user click on sign_up and perform actions
		add(sign_up); // display button

		getContentPane().setBackground(Color.WHITE); // set the frame background

		setSize(800, 480); // Frame Size
		setVisible(true); // Frame Visible function
		setLocation(350, 200); // location of the frame, 1st para is distance from left and 2nd is distance from top
	}

	public void actionPerformed(ActionEvent ae) { // In this Class we declare the work of the buttons
		if (ae.getSource() == clear) { // getSource use to know the buttons are click
			cardTextField.setText(""); // set the work / text
			pinPassField.setText(""); // set the work / text

		} else if (ae.getSource() == sign_in) {
			JDBC_Connection JDBC_Connection = new JDBC_Connection();
			String card_no = cardTextField.getText();
			String pin = pinPassField.getText();
			String query = "SELECT * FROM bank_management_system.login WHERE card_no = '"+card_no+"' AND pin = '"+pin+"'";
			try {
				ResultSet rs = JDBC_Connection.s.executeQuery(query);
				if(rs.next()){
					int balance = 0;
					setVisible(false); //to set current frame off
					new Transactions(pin, balance).setVisible(true);	//to open new frame Transaction
				}else {
					JOptionPane.showMessageDialog(null, "INCORRECT CARD NUMBER OR PIN");
				}
			}catch (Exception e) {
				System.out.println(e);
			}
			
		} else if (ae.getSource() == sign_up) {	//if user click on sign_up
			setVisible(false); //to set current frame off
			new SignUpOne().setVisible(true);	//to open new frame SignUpOne
		}
	}

	public static void main(String[] args) {
		new LOGIN();		//Run LOGIN Class
	}

}