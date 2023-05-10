package ATM_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class Fast_Cash extends JFrame implements ActionListener{
	//GLOBAL VARIABLE DECLARATION
	JButton rs100, rs500, rs1000, rs2500, rs5000, rs10000, back;
	String pin;
	int balance;
	
	Fast_Cash(String pin, int balance){
		
		this.pin = pin;
		this.balance = balance;
		
		setLayout(null); // to build custom layout we have to set default layout as NULL

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg")); // load the img
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); // to change image size, 1st para is distance from left and 2nd is distance from top
		ImageIcon i3 = new ImageIcon(i2); // label function does not take Image() as input so we change Image to ImageIcon
		JLabel image = new JLabel(i3); //to get image label
		image.setBounds(0, 0, 900, 900);	//image label location
		add(image);	//display image lable
		
		JLabel title = new JLabel("Please Select FAST CASH Method"); //text label
		title.setBounds(175, 300, 700, 35);	//label location	
		title.setForeground(Color.WHITE);	//label color
		title.setFont(new Font("System", Font.BOLD, 16));	//label font
		image.add(title);	//to display infront of image
		
		rs100 = new JButton("RS. 100"); // add button for next
		rs100.setBounds(175, 375, 150, 30); // set location and height and width
		rs100.setFont(new Font("Raleway", Font.BOLD, 15));
		rs100.addActionListener(this);	//when next button click then specific action should performed 
		image.add(rs100); // display button
		
		rs500 = new JButton("RS. 500"); // add button for next
		rs500.setBounds(350, 375, 150, 30); // set location and height and width
		rs500.setFont(new Font("Raleway", Font.BOLD, 15));
		rs500.addActionListener(this);	//when next button click then specific action should performed 
		image.add(rs500); // display button
		
		rs1000 = new JButton("RS. 1000"); // add button for next
		rs1000.setBounds(175, 425, 150, 30); // set location and height and width
		rs1000.setFont(new Font("Raleway", Font.BOLD, 15));
		rs1000.addActionListener(this);	//when next button click then specific action should performed 
		image.add(rs1000); // display button
		
		rs2500 = new JButton("RS. 2500"); // add button for next
		rs2500.setBounds(350, 425, 150, 30); // set location and height and width
		rs2500.setFont(new Font("Raleway", Font.BOLD, 15));
		rs2500.addActionListener(this);	//when next button click then specific action should performed 
		image.add(rs2500); // display button
		
		rs5000 = new JButton("RS. 5000"); // add button for next
		rs5000.setBounds(175, 475, 150, 30); // set location and height and width
		rs5000.setFont(new Font("Raleway", Font.BOLD, 15));
		rs5000.addActionListener(this);	//when next button click then specific action should performed 
		image.add(rs5000); // display button
		
		rs10000 = new JButton("RS. 10000"); // add button for next
		rs10000.setBounds(350, 475, 150, 30); // set location and height and width
		rs10000.setFont(new Font("Raleway", Font.BOLD, 14));
		rs10000.addActionListener(this);	//when next button click then specific action should performed 
		image.add(rs10000); // display button
		
		back = new JButton("BACK"); // add button for next
		back.setBounds(350, 520, 150, 30); // set location and height and width
		back.setFont(new Font("Raleway", Font.BOLD, 15));
		back.addActionListener(this);	//when next button click then specific action should performed 
		image.add(back); // display button
		
		getContentPane().setBackground(Color.WHITE); // set the frame background

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
			
			String amount = ((JButton)ae.getSource()).getText().substring(4); //ae.getSource gives which button selected it return object 
																			  //so we have to type cast it with JButton then get text of JButton 
																			  //and then substring to get actual vale as string
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
				
				if(ae.getSource() != back && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE");
					return;
				}
				
				Date date = new Date();
				balance = balance - Integer.parseInt(amount);
				String query = "INSERT INTO bank_management_system.bank VALUES('"+pin+"', '"+date+"', 'Fast Cash', '"+amount+"', '"+balance+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "RS " + amount + " Withdrawl Successfully");
				setVisible(false); //to set current frame off
				new LOGIN().setVisible(true);	//to open new frame Transaction
			
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
	}
	

	public static void main(String[] args) {
		new Fast_Cash("",0);
	}

}





//if(amount.equals("")) {
	//JOptionPane.showMessageDialog(null, "Please Enter Amount!");
