package ATM_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
	//GLOBAL VARIABLE DECLARATION
	JButton deposit, cashWithdrawl, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
	String pin;
	int balance;
	
	Transactions(String pin, int balance){
		
		this.pin = pin;
		this.balance = balance;
		
		setLayout(null); // to build custom layout we have to set default layout as NULL

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg")); // load the img
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); // to change image size, 1st para is distance from left and 2nd is distance from top
		ImageIcon i3 = new ImageIcon(i2); // label function does not take Image() as input so we change Image to ImageIcon
		JLabel image = new JLabel(i3); //to get image label
		image.setBounds(0, 0, 900, 900);	//image label location
		add(image);	//display image lable
		
		JLabel title = new JLabel("Please Select Your Transaction Method"); //text label
		title.setBounds(175, 300, 700, 35);	//label location	
		title.setForeground(Color.WHITE);	//label color
		title.setFont(new Font("System", Font.BOLD, 16));	//label font
		image.add(title);	//to display infront of image
		
		deposit = new JButton("Deposit"); // add button for next
		deposit.setBounds(175, 375, 150, 30); // set location and height and width
		deposit.setFont(new Font("Raleway", Font.BOLD, 15));
		deposit.addActionListener(this);	//when next button click then specific action should performed 
		image.add(deposit); // display button
		
		cashWithdrawl = new JButton("Cash Withdrawl"); // add button for next
		cashWithdrawl.setBounds(350, 375, 150, 30); // set location and height and width
		cashWithdrawl.setFont(new Font("Raleway", Font.BOLD, 15));
		cashWithdrawl.addActionListener(this);	//when next button click then specific action should performed 
		image.add(cashWithdrawl); // display button
		
		fastCash = new JButton("Fast Cash"); // add button for next
		fastCash.setBounds(175, 425, 150, 30); // set location and height and width
		fastCash.setFont(new Font("Raleway", Font.BOLD, 15));
		fastCash.addActionListener(this);	//when next button click then specific action should performed 
		image.add(fastCash); // display button
		
		miniStatement = new JButton("Mini Statement"); // add button for next
		miniStatement.setBounds(350, 425, 150, 30); // set location and height and width
		miniStatement.setFont(new Font("Raleway", Font.BOLD, 15));
		miniStatement.addActionListener(this);	//when next button click then specific action should performed 
		image.add(miniStatement); // display button
		
		pinChange = new JButton("PIN Change"); // add button for next
		pinChange.setBounds(175, 475, 150, 30); // set location and height and width
		pinChange.setFont(new Font("Raleway", Font.BOLD, 15));
		pinChange.addActionListener(this);	//when next button click then specific action should performed 
		image.add(pinChange); // display button
		
		balanceEnquiry = new JButton("Balance Enquiry"); // add button for next
		balanceEnquiry.setBounds(350, 475, 150, 30); // set location and height and width
		balanceEnquiry.setFont(new Font("Raleway", Font.BOLD, 14));
		balanceEnquiry.addActionListener(this);	//when next button click then specific action should performed 
		image.add(balanceEnquiry); // display button
		
		exit = new JButton("EXIT"); // add button for next
		exit.setBounds(350, 520, 150, 30); // set location and height and width
		exit.setFont(new Font("Raleway", Font.BOLD, 15));
		exit.addActionListener(this);	//when next button click then specific action should performed 
		image.add(exit); // display button
		
		getContentPane().setBackground(Color.WHITE); // set the frame background

		setSize(900, 900); // Frame Size
		setLocation(300, 0); // location of the frame, 1st para is distance from left and 2nd is distance from top
		setUndecorated(true); //to hide the main bar
		setVisible(true); // Frame Visible function
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == exit) {
			System.exit(0);
		}else if(ae.getSource() == deposit) {
			setVisible(false); //to set current frame off
			new Deposit(pin, balance).setVisible(true);	//to open new frame deposit
		}else if(ae.getSource() == cashWithdrawl) {
			setVisible(false); //to set current frame off
			new Withdrawl(pin, balance).setVisible(true);	//to open new frame cash withdraw
		}else if(ae.getSource() == fastCash) {
			setVisible(false); //to set current frame off
			new Fast_Cash(pin, balance).setVisible(true);	//to open new frame cash Fast Cash
		}else if(ae.getSource() == pinChange) {
			setVisible(false); //to set current frame off
			new Pin_Change(pin).setVisible(true);	//to open new frame cash PIN CHANGE
		}else if(ae.getSource() == balanceEnquiry) {
			setVisible(false); //to set current frame off
			new Balance_Enquiry(pin).setVisible(true);	//to open new frame cash balance enquire
		}else if(ae.getSource() == 	miniStatement) {
			new Mini_Statement(pin).setVisible(true);	//to open new frame cash mini statement
		}
	}
	

	public static void main(String[] args) {
		new Transactions("",0);
	}

}
