package ATM_SYSTEM;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{
	
	//GLOBAL VARIABLES DECLARATION
	JTextField amountTextField;
	JButton deposit, back;
	String pin;
	int balance;
	
	Deposit(String pin, int balance){
		
		this.pin = pin;
		this.balance = balance;
		
		setLayout(null); // to build custom layout we have to set default layout as NULL

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg")); // load the img
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); // to change image size, 1st para is distance from left and 2nd is distance from top
		ImageIcon i3 = new ImageIcon(i2); // label function does not take Image() as input so we change Image to ImageIcon
		JLabel image = new JLabel(i3); //to get image label
		image.setBounds(0, 0, 900, 900);	//image label location
		add(image);	//display image lable
		
		JLabel title = new JLabel("Enter The Amount : "); //text label
		title.setBounds(175, 300, 200, 35);	//label location	
		title.setForeground(Color.WHITE);	//label color
		title.setFont(new Font("System", Font.BOLD, 16));	//label font
		image.add(title);	//to display infront of image
		
		amountTextField = new JTextField(); // to get text of card no
		amountTextField.setBounds(335, 305, 165, 30); // to set location and height and width
		amountTextField.setFont(new Font("Raleway", Font.BOLD, 15));	//to set font type and style 
		image.add(amountTextField); // display text field
		
		deposit = new JButton("Deposit"); // add button for next
		deposit.setBounds(175, 375, 150, 30); // set location and height and width
		deposit.setFont(new Font("Raleway", Font.BOLD, 15));
		deposit.addActionListener(this);	//when next button click then specific action should performed 
		image.add(deposit); // display button
		
		back = new JButton("Back"); // add button for next
		back.setBounds(350, 375, 150, 30); // set location and height and width
		back.setFont(new Font("Raleway", Font.BOLD, 15));
		back.addActionListener(this);	//when next button click then specific action should performed 
		image.add(back); // display button
		
		setSize(900, 900); // Frame Size
		setLocation(300, 0); // location of the frame, 1st para is distance from left and 2nd is distance from top
		setUndecorated(true); //to hide the main bar
		setVisible(true); // Frame Visible function
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == deposit) {	//when user click on deposit do the below 
			String amount = amountTextField.getText();	//get amount from textfield and store in string
			Date date = new Date();	//create new date object to get date and time for deposit
			if(amount.equals("")) {	//if amount field is empty then do execute below code
				JOptionPane.showMessageDialog(null, "Please Enter Amount!");	//show message
			}else {
				try {		//try to connect frame with database
					JDBC_Connection c = new JDBC_Connection();	//connection query
				
					ResultSet rs = c.s.executeQuery("SELECT * FROM bank_management_system.bank WHERE pin = '" + pin + "'");		//database query store in ResultSet
					
					while (rs.next()) {	//loop for result set output
						if (rs.getString("type").equals("Deposit")) {	//if inside result set output check inside type there is deposite
							balance += Integer.parseInt(rs.getString("amount")); // to check the balance
						} else {
							balance -= Integer.parseInt(rs.getString("amount")); // to check the balance
						}
					
					}
					if(balance != 0) { //to check the balance
						int a = 0;
						a = balance + Integer.parseInt(amount); //if balance is equal not to zero then inside deposit the balance + amount
						balance = a; //and s
						a = 0;
					}else if(balance == 0) {
						balance = Integer.parseInt(amount); // if balance is zero then amount == balance
					}
					String query = "INSERT INTO bank_management_system.bank VALUES('" + pin + "', '" + date + "', 'Deposit', '" + amount + "', '"+balance+"')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "RS : " + amount + " Deposited Successfully!"); //message dialog
					setVisible(false); //to set current frame off
					new LOGIN().setVisible(true);	//to open new frame Transaction

				}catch(Exception e) {
					System.out.println(e);
				}
			}
			
		}else if(ae.getSource() == back) {
			setVisible(false); //to set current frame off
			new Transactions(pin, balance).setVisible(true);	//to open new frame Transaction
		}
	}

	public static void main(String[] args) {
		new Deposit("",0);
	}

}
