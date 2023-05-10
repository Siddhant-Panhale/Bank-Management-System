package ATM_SYSTEM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pin_Change extends JFrame implements ActionListener{
	JPasswordField pinChangeTextField, rePinChangeTextField;
	JButton pin_change, back;
	String pin;
	
	Pin_Change(String pin){
		this.pin = pin;
		setLayout(null); // to build custom layout we have to set default layout as NULL

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg")); // load the img
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); // to change image size, 1st para is distance from left and 2nd is distance from top
		ImageIcon i3 = new ImageIcon(i2); // label function does not take Image() as input so we change Image to ImageIcon
		JLabel image = new JLabel(i3); //to get image label
		image.setBounds(0, 0, 900, 900);	//image label location
		add(image);	//display image lable
		
		JLabel newPin = new JLabel("NEW PIN : "); //text label
		newPin.setBounds(175, 300, 200, 35);	//label location	
		newPin.setForeground(Color.WHITE);	//label color
		newPin.setFont(new Font("System", Font.BOLD, 16));	//label font
		image.add(newPin);	//to display infront of image
		
		pinChangeTextField = new JPasswordField(); // to get text of card no
		pinChangeTextField.setBounds(335, 305, 165, 30); // to set location and height and width
		pinChangeTextField.setFont(new Font("Raleway", Font.BOLD, 15));	//to set font type and style 
		image.add(pinChangeTextField); // display text field
		
		JLabel reEnterPin = new JLabel("RE-ENTER PIN : "); //text label
		reEnterPin.setBounds(175, 350, 200, 35);	//label location	
		reEnterPin.setForeground(Color.WHITE);	//label color
		reEnterPin.setFont(new Font("System", Font.BOLD, 16));	//label font
		image.add(reEnterPin);	//to display infront of image
		
		rePinChangeTextField = new JPasswordField(); // to get text of card no
		rePinChangeTextField.setBounds(335, 355, 165, 30); // to set location and height and width
		rePinChangeTextField.setFont(new Font("Raleway", Font.BOLD, 15));	//to set font type and style 
		image.add(rePinChangeTextField); // display text field
		
		pin_change = new JButton("CHANGE"); // add button for next
		pin_change.setBounds(175, 450, 150, 30); // set location and height and width
		pin_change.setFont(new Font("Raleway", Font.BOLD, 15));
		pin_change.addActionListener(this);	//when next button click then specific action should performed 
		image.add(pin_change); // display button
		
		back = new JButton("BACK"); // add button for next
		back.setBounds(350, 450, 150, 30); // set location and height and width
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
		}else if(ae.getSource() == pin_change) {
			
			try {
				String new_pin = pinChangeTextField.getText();
				String Re_pin = rePinChangeTextField.getText();
				
				if(new_pin.equals("")) {
					JOptionPane.showMessageDialog(null, "PLEASE ENTER NEW PIN IN NEW PIN BOX");
					return;
				}else if(Re_pin.equals("")) {
					JOptionPane.showMessageDialog(null, "PLEASE ENTER THE NEW PIN IN RE-ENTER BOX");
					return;
				}else if(!new_pin.equals(Re_pin)) {
					JOptionPane.showMessageDialog(null, "PLEASE ENTER SAME PIN IN BOTH BOX'S");
					return;
				}
				
				JDBC_Connection c = new JDBC_Connection();
				
				String query1 = "UPDATE bank_management_system.bank SET pin = '"+new_pin+"' WHERE pin = '"+pin+"'";
				String query2 = "UPDATE bank_management_system.login SET pin = '"+new_pin+"' WHERE pin = '"+pin+"'";
				String query3 = "UPDATE bank_management_system.sign_up_three SET pin = '"+new_pin+"' WHERE pin = '"+pin+"'";
				
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "PIN CHANGED SUCCESSFULLY");
				
				setVisible(false);
				new Transactions(new_pin,0).setVisible(true);
			
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public static void main(String[] args) {
		new Pin_Change("");
	}

}
