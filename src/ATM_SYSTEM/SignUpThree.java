package ATM_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


public class SignUpThree extends JFrame implements ActionListener{
	
	//GLOBAL VARIABLE DECLARATION
		private static final String String = null;
		JButton save, cancle;
		JCheckBox declaration, atm_card, internet_banking, mobile_banking, eStatement, check_book, emailSmsAlert;
		JRadioButton saving, fixed_deposit, current, recurring_deposit;
		static String form_no;
		
		SignUpThree(String form_no){
			
			this.form_no = form_no;		//to get Form_no constructor from SignUPOne Class as a Primary Key to link the SignUpTwo information to related person 
			
			setLayout(null);		//to create custom layout we have to disable the default layout
			
			setTitle("NEW ACCOUNT APPLICATION FORM : PAGE 3");	//this frame title
			
			JLabel account_details = new JLabel("Page 3 : Account Details");	//Label to the frame
			account_details.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
			account_details.setBounds(300, 60, 300, 40); // set location and height width
			add(account_details); // Show the text in frame
			
			JLabel account_type = new JLabel("Account Type : ");	//Label to the frame
			account_type.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
			account_type.setBounds(100, 150, 150, 40); // set location and height width
			add(account_type); // Show the text in frame
			
			saving = new JRadioButton("Saving Account"); //to set a button
			saving.setBounds(100, 200, 150, 40);	//buttons location and height and width
			saving.setBackground(Color.WHITE); 	//button color
			add(saving);	//display button
			
			current = new JRadioButton("Current Account");	//to set a button
			current.setBounds(300, 200, 150, 40);		//buttons location and height and width
			current.setBackground(Color.WHITE);		//button color
			add(current);	//display button
			
			fixed_deposit = new JRadioButton("Fixed Deposite Account");	//to set a button
			fixed_deposit.setBounds(100, 250, 175, 40);	//buttons location and height and width
			fixed_deposit.setBackground(Color.WHITE);	//button color
			add(fixed_deposit);	//display button
			
			recurring_deposit = new JRadioButton("Recurring Deposite Account");	//to set a button
			recurring_deposit.setBounds(300, 250, 200, 40);	//buttons location and height and width
			recurring_deposit.setBackground(Color.WHITE);	//button color
			add(recurring_deposit);	//display button
			
			ButtonGroup accountTypeGroup = new ButtonGroup();   //ButtonGroup is use to select one of the buttons added
			accountTypeGroup.add(saving);	//add buttons
			accountTypeGroup.add(current);	//add buttons
			accountTypeGroup.add(fixed_deposit);	//add buttons
			accountTypeGroup.add(recurring_deposit);	//add buttons

			JLabel card_no = new JLabel("Card Number  :    XXXX-XXXX-XXXX-1310");	//Label to the frame
			card_no.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
			card_no.setBounds(100, 300, 500, 40); // set location and height width
			add(card_no); // Show the text in frame
			
			JLabel cardNoDetail = new JLabel("Sample 16-Digit Card Number");	//Label to the frame
			cardNoDetail.setFont(new Font("Raleway", Font.BOLD, 10)); // font to the text
			cardNoDetail.setBounds(100, 325, 300, 15); // set location and height width
			add(cardNoDetail); // Show the text in frame
			
			JLabel pin_no = new JLabel("PIN Number    :    XXXX");	//Label to the frame
			pin_no.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
			pin_no.setBounds(100, 350, 500, 40); // set location and height width
			add(pin_no); // Show the text in frame
			
			JLabel pinNoDetail = new JLabel("Sample 4-Digit PIN Number");	//Label to the frame
			pinNoDetail.setFont(new Font("Raleway", Font.BOLD, 10)); // font to the text
			pinNoDetail.setBounds(100, 375, 300, 15); // set location and height width
			add(pinNoDetail); // Show the text in frame
			
			JLabel services = new JLabel("Service Required : ");	//Label to the frame
			services.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
			services.setBounds(100, 400, 250, 40); // set location and height width
			add(services); // Show the text in frame
			
			atm_card = new JCheckBox("ATM CARD"); //to set a button
			atm_card.setBounds(100, 450, 150, 40);	//buttons location and height and width
			atm_card.setBackground(Color.WHITE); 	//button color
			add(atm_card);	//display button
			
			internet_banking = new JCheckBox("INTERENT BANKING");	//to set a button
			internet_banking.setBounds(300, 450, 150, 40);		//buttons location and height and width
			internet_banking.setBackground(Color.WHITE);		//button color
			add(internet_banking);	//display button
			
			eStatement = new JCheckBox("E - STATEMENT");	//to set a button
			eStatement.setBounds(100, 500, 175, 40);	//buttons location and height and width
			eStatement.setBackground(Color.WHITE);	//button color
			add(eStatement);	//display button
			
			mobile_banking = new JCheckBox("MOBILE BANKING");	//to set a button
			mobile_banking.setBounds(300, 500, 200, 40);	//buttons location and height and width
			mobile_banking.setBackground(Color.WHITE);	//button color
			add(mobile_banking);	//display button
			
			check_book = new JCheckBox("CHECK BOOK");	//to set a button
			check_book.setBounds(100, 550, 200, 40);	//buttons location and height and width
			check_book.setBackground(Color.WHITE);	//button color
			add(check_book);	//display button
			
			emailSmsAlert = new JCheckBox("EMAIL, SMS ALERTS");	//to set a button
			emailSmsAlert.setBounds(300, 550, 200, 40);	//buttons location and height and width
			emailSmsAlert.setBackground(Color.WHITE);	//button color
			add(emailSmsAlert);	//display button
			
			declaration = new JCheckBox("I hereby declare that above entered details are correct to the best of my knowledge");	//Label to the frame
			declaration.setFont(new Font("Raleway", Font.BOLD, 10)); // font to the text
			declaration.setBounds(100, 625, 600, 15); // set location and height width
			add(declaration); // Show the text in frame
			
			save = new JButton("SAVE"); // add button for next
			save.setBounds(100, 700, 100, 30); // set location and height and width
			save.setFont(new Font("Raleway", Font.BOLD, 15));
			save.addActionListener(this);	//when next button click then specific action should performed 
			add(save); // display button
			
			cancle = new JButton("CANCLE"); // add button for next
			cancle.setBounds(600, 700, 100, 30); // set location and height and width
			cancle.setFont(new Font("Raleway", Font.BOLD, 15));
			cancle.addActionListener(this);	//when next button click then specific action should performed 
			add(cancle); // display button
			
			getContentPane().setBackground(Color.WHITE);	//to set SignUpTwo Background	
			
			setSize(850, 800);		//to set size of frame	
			setLocation(350, 10);	//to set location of frame
			setVisible(true);	//to set visible frame
			
		}
		
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource() == save) {
				
				String account_type = null;	//to select senior citizen created radio button
				
				if(saving.isSelected()) {	//if radio button seniorYes is selected then inside String account type saving is save
					account_type = "SAVING ACCOUNT";
					}else if (current.isSelected()) { 		//if radio button seniorNo is selected then inside String account type save current
						account_type = "CURRENT ACCOUNT";
					}else if (fixed_deposit.isSelected()) {
						account_type = "FIXED DEPOSIT ACCOUNT";	//if radio button seniorYes is selected then inside String account type fixed deposit is save
					}else if(recurring_deposit.isSelected()) {
						account_type = "RECURRING DEPOSIT ACCOUNT";	//if radio button seniorYes is selected then inside String account type recurring deposit account is save
					}
				
				Random r = new Random();
				String card_no = ""+ Math.abs((r.nextLong() % 90000000L)+ 7231712100000000L);
				
				String pin = "" + Math.abs((r.nextLong() % 9000L) + 1000L);
				
				String services = "";	//to select senior citizen created check box
				
				if(atm_card.isSelected()) {	//if check box seniorYes is selected then inside String services saving is save
					
					services = services + "ATM CARD";	//services + help to select multiple options
					
				}else if (internet_banking.isSelected()) { 	//if check box seniorNo is selected then inside services type save current
				
					services = services + "INTERENT BANKING"; //services + help to select multiple options
					
				}else if (eStatement.isSelected()) {	//services + help to select multiple options
				
					services = services + "eStatement";	//if check box seniorYes is selected then inside services type fixed deposit is save
					
				}else if(mobile_banking.isSelected()) {	//services + help to select multiple options
				
					services = services + "MOBILE BANKING";	//if check box seniorYes is selected then inside services type recurring deposit account is save
					
				}else if(check_book.isSelected()) {	//services + help to select multiple options
				
					services = services + "CHECK BOOK";	//if check box seniorYes is selected then inside services type recurring deposit account is save
					
				}else if(emailSmsAlert.isSelected()) {	//services + help to select multiple options
				
					services = services + "Email And Sms Alerts";	//if check box seniorYes is selected then inside services type recurring deposit account is save
					
				}
				
				try {
					
					if(account_type.equals("")) {		//if we wont to give warning to the user when full name is empty 
						JOptionPane.showMessageDialog(null, "Account Type is Required");		//it will give warning 
					}else {
						JDBC_Connection c = new JDBC_Connection();		//to establish connection
						String query = "INSERT INTO bank_management_system.sign_up_three VALUES('"+form_no+"', '"+account_type+"', '"+card_no+"', '"+pin+"', '"+services+"')";
						String query1 = "INSERT INTO bank_management_system.login VALUES('"+form_no+"', '"+card_no+"', '"+pin+"')";
						c.s.executeUpdate(query);		//to execute query
						c.s.executeUpdate(query1);		//to execute query
						
						JOptionPane.showMessageDialog(null, "CARD NUMBER : " + card_no + "\nPIN NUMBER : " + pin);	//to show generated card number and pin for user
						JOptionPane.showMessageDialog(null, "PLEASE DEPOSIT SOME MONEY");	//to show deposit money 	
						
						int balance = 0;
						setVisible(false);	//to close the frame
						new Deposit(pin, balance).setVisible(true);		//to deposit money open deposit frame
					}
					
				} catch (Exception e) {		//if the connection is no establish then catch throws error
					System.out.println(e); //the error in e
				}
				
			} else if (ae.getSource() == cancle) {	//click on cancel means go back to login frame
				JOptionPane.showMessageDialog(null, "ARE YOU SURE!");	//display message
				setVisible(false);	//close thos frame
				new LOGIN().setVisible(true);	//open login frame
			}
		}

	public static void main(String[] args) {
		new SignUpThree(form_no);
		
	}

}
