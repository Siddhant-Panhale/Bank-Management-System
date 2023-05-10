package ATM_SYSTEM;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{
	//GLOBAL VARIABLES DICLARATION
	private static final String String = null;
	Random r;
	Long ran;
	JTextField fullNameTextField, fatherNameField, dobTextField, emailTextField, cityTextField, pincodeTextField, districtTextField, addressTextField, stateTextField;
	JButton next;
	JRadioButton male, female, other, single, married, divorced ;
	
	SignUpOne(){
		
		r = new Random();
		ran = Math.abs((r.nextLong() % 9000L) + 1000L);
		
		setLayout(null);
		
		JLabel form_no = new JLabel("APPLICATION FORM NO : " + ran);	//Label to the frame
		form_no.setFont(new Font("Raleway", Font.BOLD, 26)); // font to the text
		form_no.setBounds(200, 20, 600, 40); // set location and height width
		add(form_no); // Show the text in frame
		
		JLabel person_details = new JLabel("Page 1 : Personal Details");	//Label to the frame
		person_details.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		person_details.setBounds(300, 60, 300, 40); // set location and height width
		add(person_details); // Show the text in frame
		
		JLabel full_name = new JLabel("Full Name : ");	//Label to the frame
		full_name.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		full_name.setBounds(100, 150, 150, 40); // set location and height width
		add(full_name); // Show the text in frame
		
		fullNameTextField = new JTextField(); // to get text of card no
		fullNameTextField.setBounds(300, 155, 500, 30); // to set location and height and width
		fullNameTextField.setFont(new Font("Raleway", Font.BOLD, 15));	//to set font type and style 
		add(fullNameTextField); // display text field
		
		JLabel fatherFullName = new JLabel("Father's Full Name : ");	//Label to the frame
		fatherFullName.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		fatherFullName.setBounds(100, 200, 200, 40); // set location and height width
		add(fatherFullName); // Show the text in frame
		
		fatherNameField = new JTextField(); // to get text of card no
		fatherNameField.setBounds(300, 205, 500, 30); // to set location and height and width
		fatherNameField.setFont(new Font("Raleway", Font.BOLD, 15));	//to set font type and style 
		add(fatherNameField); // display text field
		
		JLabel dob = new JLabel("Date Of Birth : ");	//Label to the frame
		dob.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		dob.setBounds(100, 250, 150, 40); // set location and height width
		add(dob); // Show the text in frame
		
		dobTextField = new JTextField(); // to get text of card no
		dobTextField.setBounds(300, 255, 250, 30); // to set location and height and width
		dobTextField.setFont(new Font("Raleway", Font.BOLD, 15));	//to set font type and style 
		add(dobTextField); // display text field
		
		JLabel email = new JLabel("Email : ");	//Label to the frame
		email.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		email.setBounds(100, 300, 150, 40); // set location and height width
		add(email); // Show the text in frame
		
		emailTextField = new JTextField(); // to get text 
		emailTextField.setBounds(300, 305, 500, 30); // to set location and height and width
		emailTextField.setFont(new Font("Raleway", Font.BOLD, 15));	//to set font type and style 
		add(emailTextField); // display text field
		
		JLabel gender = new JLabel("Gender : ");	//Label to the frame
		gender.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		gender.setBounds(100, 350, 150, 40); // set location and height width
		add(gender); // Show the text in frame
		
		male = new JRadioButton("MALE"); //to set a button
		male.setBounds(300, 355, 80, 40);	//buttons location and height and width
		male.setBackground(Color.WHITE); 	//button color
		add(male);	//display button
		
		female = new JRadioButton("FEMALE");	//to set a button
		female.setBounds(400, 355, 80, 40);		//buttons location and height and width
		female.setBackground(Color.WHITE);		//button color
		add(female);	//display button
		
		other = new JRadioButton("OTHER");	//to set a button
		other.setBounds(500, 355, 80, 40);	//buttons location and height and width
		other.setBackground(Color.WHITE);	//button color
		add(other);	//display button
		
		ButtonGroup genderGroup = new ButtonGroup();   //ButtonGroup is use to select one of the buttons added
		genderGroup.add(male);	//add buttons
		genderGroup.add(female);	//add buttons
		genderGroup.add(other);	//add buttons
		
		JLabel marital = new JLabel("Marital Status : ");	//Label to the frame
		marital.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		marital.setBounds(100, 400, 150, 40); // set location and height width
		add(marital); // Show the text in frame
		
		single = new JRadioButton("SINGLE"); //to set a button
		single.setBounds(300, 405, 100, 40);	//buttons location and height and width
		single.setBackground(Color.WHITE); 	//button color
		add(single);	//display button
		
		married = new JRadioButton("MARRIED");	//to set a button
		married.setBounds(400, 405, 100, 40);		//buttons location and height and width
		married.setBackground(Color.WHITE);		//button color
		add(married);	//display button
		
		divorced = new JRadioButton("DIVORCED");	//to set a button
		divorced.setBounds(500, 405, 100, 40);	//buttons location and height and width
		divorced.setBackground(Color.WHITE);	//button color
		add(divorced);	//display button
		
		ButtonGroup martialGroup = new ButtonGroup();   //ButtonGroup is use to select one of the buttons added
		martialGroup.add(single);	//add buttons
		martialGroup.add(married);	//add buttons
		martialGroup.add(divorced);	//add buttons
		
		JLabel address = new JLabel("Address : ");	//Label to the frame
		address.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		address.setBounds(100, 450, 150, 40); // set location and height width
		add(address); // Show the text in frame
		
		addressTextField = new JTextField(); // to get text of card no
		addressTextField.setBounds(300, 455, 500, 30); // to set location and height and width
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 15));	//to set font type and style 
		add(addressTextField); // display text field
		
		JLabel pincode = new JLabel("Pin Code : ");	//Label to the frame
		pincode.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		pincode.setBounds(100, 500, 150, 40); // set location and height width
		add(pincode); // Show the text in frame
		
		pincodeTextField = new JTextField(); // to get text of card no
		pincodeTextField.setBounds(300, 505, 250, 30); // to set location and height and width
		pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 15));	//to set font type and style 
		add(pincodeTextField); // display text field
		
		JLabel city = new JLabel("City : ");	//Label to the frame
		city.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		city.setBounds(100, 550, 150, 40); // set location and height width
		add(city); // Show the text in frame
		
		cityTextField = new JTextField(); // to get text of card no
		cityTextField.setBounds(300, 555, 500, 30); // to set location and height and width
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 15));	//to set font type and style 
		add(cityTextField); // display text field
		
		JLabel district = new JLabel("District : ");	//Label to the frame
		district.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		district.setBounds(100, 600, 150, 40); // set location and height width
		add(district); // Show the text in frame
		
		districtTextField = new JTextField(); // to get text of card no
		districtTextField.setBounds(300, 605, 500, 30); // to set location and height and width
		districtTextField.setFont(new Font("Raleway", Font.BOLD, 15));	//to set font type and style 
		add(districtTextField); // display text field
		
		JLabel state = new JLabel("State : ");	//Label to the frame
		state.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		state.setBounds(100, 650, 150, 40); // set location and height width
		add(state); // Show the text in frame
		
		stateTextField = new JTextField(); // to get text of card no
		stateTextField.setBounds(300, 655, 500, 30); // to set location and height and width
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 15));	//to set font type and style 
		add(stateTextField); // display text field
		
		JButton next = new JButton("NEXT"); // add button for next
		next.setBounds(700, 700, 100, 30); // set location and height and width
		next.setFont(new Font("Raleway", Font.BOLD, 15));
		next.addActionListener(this);
		add(next); // display button
		
		getContentPane().setBackground(Color.WHITE);	//to set SignUpOne FRame background
		
		setSize(850, 800);		//to set SignUpOne frame size
		setLocation(350, 10);	//to set frame location
		setVisible(true);		//to set frame visible
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String form_no = "" + ran;		//to get from random and store in string form no
		String full_name = fullNameTextField.getText();		//to get from full name text field and store in full name
		String fatherFullName = fatherNameField.getText();	//to get from father full name text field and store in father full name
		String dob = dobTextField.getText();  //to get from dob text field and store in dob
		String email = emailTextField.getText();		//to get email from email text field
		
		String gender = null;	//to select gender created radio button
		
		if(male.isSelected()) {	//if radio button male is select inside String gender save MALE
			gender = "MALE";
			}else if (female.isSelected()) {	//if radio button female is select inside String gender save FEMALE
				gender = "FEMALE";
			}else if (other.isSelected()) {		//if radio button other is select inside String gender save OTHER
				gender = "OTHER";
			}
		
		String martial = null;		//to select martial status created radio button
		
		if(single.isSelected()) {	//if radio button single is select inside String gender save SINGLE
			martial = "SINGLE";
		}else if (married.isSelected()) {	//if radio button married is select inside String gender save MARRIED
			martial = "MARRIED";
		}else if (divorced.isSelected()) {	//if radio button divorced is select inside String gender save DIVORCED
			martial = "DIVORCED";
		}
		
		String address = addressTextField.getText();	//to get from address text field and store in address
		String pincode = pincodeTextField.getText();	//to get from pincode text field and store in pincode
		String city = cityTextField.getText();			//to get from city text field and store in city
		String district = districtTextField.getText();	//to get from district text field and store in district
		String state = stateTextField.getText();	//to get from state text field and store in state
		
		try {
			
			if(full_name.equals("")) {		//if we wont to give warning to the user when full name is empty 
				JOptionPane.showMessageDialog(null, "Full Name is Required");		//it will give warning 
			}else {
				JDBC_Connection c = new JDBC_Connection();		//to establish connection
				String query = "INSERT INTO bank_management_system.sign_up_one VALUES('"+form_no+"', '"+full_name+"', '"+fatherFullName+"', '"+dob+"', '"+email+"', '"+gender+"', '"+martial+"', '"+address+"', '"+pincode+"', '"+city+"', '"+district+"', '"+state+"')";
				c.s.executeUpdate(query);		//to execute query
				
					//when user fill the info then when user clicks on next then
					setVisible(false);		//user click on next this frame will be off and
					new SignUpTwo(form_no).setVisible(true);	//and SigUpTwo Frame will open 
			}
			
		} catch (Exception e) {		//if the connection is no establish then catch throws error
			System.out.println(e); //the error in e
		}
	}
	
	
	public static void main(String[] args) {
		
		new SignUpOne();		//Run SignUpOne Class
	}

}
