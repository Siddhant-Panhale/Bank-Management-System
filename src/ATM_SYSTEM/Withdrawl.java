package ATM_SYSTEM;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener{
	
	//GLOBAL VARIABLES DECLARATION
	JTextField amountTextField;
	JButton withdrawl, back;
	String pin;
	int balance;
	
	Withdrawl(String pin, int balance){
		
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
		
		withdrawl = new JButton("Withdrawl"); // add button for next
		withdrawl.setBounds(175, 375, 150, 30); // set location and height and width
		withdrawl.setFont(new Font("Raleway", Font.BOLD, 15));
		withdrawl.addActionListener(this);	//when next button click then specific action should performed 
		image.add(withdrawl); // display button
		
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
		if(ae.getSource() == back) {
			setVisible(false); //to set current frame off
			new Transactions(pin, balance).setVisible(true);	//to open new frame transactions
		
		}else {
			String amount = amountTextField.getText();
			if(amount.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter Amount!");
			}
			JDBC_Connection c = new JDBC_Connection();
			
			try {

				ResultSet rs = c.s.executeQuery("SELECT * FROM bank_management_system.bank WHERE pin = '"+pin+"'");	//to get bank table
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));  //to check the balance
					}else {
						balance -= Integer.parseInt(rs.getString("amount")); // to check the balance
					}
				}
				
				if(ae.getSource() != back && balance < Integer.parseInt(amount)) {	//to check the back button is click or not and to check the insufficient balance
					JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE");
					return;
				}
				
				Date date = new Date();
				balance = balance - Integer.parseInt(amount);	//after withdraw balance - withdraw amount
				String query = "INSERT INTO bank_management_system.bank VALUES('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"', '"+balance+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "RS " + amount + " Withdrawl Successfully");
				setVisible(false); //to set current frame off
				new LOGIN().setVisible(true);	//to open new frame Transaction
			
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}	}

	public static void main(String[] args) {
		new Withdrawl("",0);
	}

}
