package ATM_SYSTEM;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class Balance_Enquiry extends JFrame implements ActionListener{
	String pin;
	JButton show, back;
	
	Balance_Enquiry(String pin){
	
		this.pin = pin;
		setLayout(null); // to build custom layout we have to set default layout as NULL

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg")); // load the img
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); // to change image size, 1st para is distance from left and 2nd is distance from top
		ImageIcon i3 = new ImageIcon(i2); // label function does not take Image() as input so we change Image to ImageIcon
		JLabel image = new JLabel(i3); //to get image label
		image.setBounds(0, 0, 900, 900);	//image label location
		add(image);	//display image lable
		
		JLabel newPin = new JLabel("BALANCE ENQUIRY "); //text label
		newPin.setBounds(260, 300, 200, 35);	//label location	
		newPin.setForeground(Color.WHITE);	//label color
		newPin.setFont(new Font("System", Font.BOLD, 16));	//label font
		image.add(newPin);	//to display infront of image
		
		JDBC_Connection c = new JDBC_Connection();
		int balance = 0;
		try {
			
			ResultSet rs = c.s.executeQuery("SELECT * FROM bank_management_system.bank WHERE pin = '"+pin+"'");	//to get bank table
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));  //to check the balance
				}else {
					balance -= Integer.parseInt(rs.getString("amount")); // to check the balance
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel show = new JLabel("Your Current Account Balance is RS. " + balance); //text label
		show.setBounds(170, 400, 500, 35);	//label location	
		show.setForeground(Color.WHITE);	//label color
		show.setFont(new Font("System", Font.BOLD, 14));	//label font
		image.add(show);	//to display infront of image
		
		back = new JButton("BACK"); // add button for next
		back.setBounds(350, 520, 150, 30); // set location and height and width
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
			new Transactions(pin, 0).setVisible(true);	//to open new frame Transaction
		}
	}
		
	
	public static void main(String[] args) {
		new Balance_Enquiry("");
	}

}
