package ATM_SYSTEM;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class Mini_Statement extends JFrame implements ActionListener{
	String pin;
	JButton show, back;
	
	Mini_Statement(String pin){
	
		this.pin = pin;
		setLayout(null); // to build custom layout we have to set default layout as NULL
		
		JLabel title = new JLabel("BANK OF INDIA"); //text label
		title.setBounds(140, 20, 120, 20);	//label location	
		title.setFont(new Font("System", Font.BOLD, 16));	//label font
		add(title);	//to display 
		
		JLabel title2 = new JLabel("MINI STATEMENT"); //text label
		title2.setBounds(130, 40, 150, 20);	//label location	
		title2.setFont(new Font("System", Font.BOLD, 16));	//label font
		add(title2);	//to display
		
		JLabel card = new JLabel();
		card.setBounds(20, 80, 300, 20);
		add(card);
		
		try {
			JDBC_Connection c = new JDBC_Connection();
			ResultSet rs = c.s.executeQuery("SELECT * FROM bank_management_system.login WHERE pin = '"+pin+"'");
			while(rs.next()) {
				card.setText("Card Number : " + rs.getString("card_no").substring(0,4) + "XXXXXXXX" + rs.getString("card_no").substring(12));
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel history = new JLabel();
		history.setBounds(20, 80, 500, 500);
		add(history);
		
		try {
			JDBC_Connection c = new JDBC_Connection();
			ResultSet rs = c.s.executeQuery("SELECT * FROM bank_management_system.bank WHERE pin = '"+pin+"'");
			while(rs.next()) {
				history.setText(history.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("balance") + "<br><br><html>");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		back = new JButton("BACK"); // add button for next
		back.setBounds(250, 520, 100, 30); // set location and height and width
		back.setFont(new Font("Raleway", Font.BOLD, 15));
		back.addActionListener(this);	//when next button click then specific action should performed 
		add(back); // display button
		
		setSize(400, 600); // Frame Size
		setLocation(20, 20); // location of the frame, 1st para is distance from left and 2nd is distance from top
		getContentPane().setBackground(Color.WHITE);	//set frame color white
		setVisible(true); // Frame Visible function
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
			setVisible(false); //to set current frame off
			new Transactions(pin, 0).setVisible(true);	//to open new frame Transaction
		}
}

	public static void main(String[] args) {
		new Mini_Statement("");
		}
}