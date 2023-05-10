package ATM_SYSTEM;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
	
	//GLOBAL VARIABLE DECLARATION
	private static final String String = null;
	JTextField occuTextField, adhar_noTextField, pan_noTextField;
	JComboBox religionBox, categoryBox, incomeBox, educationBox;
	JButton next;
	JRadioButton seniorYes, seniorNo, accountYes, accountNo;
	String form_no;
	
	SignUpTwo(String form_no){
		
		this.form_no = form_no;		//to get Form_no constructor from SignUPOne Class as a Primary Key to link the SignUpTwo information to related person 
		
		setLayout(null);		//to create custom layout we have to disable the default layout
		
		setTitle("NEW ACCOUNT APPLICATION FORM : PAGE 2");	//this frame title
		
		JLabel additional_details = new JLabel("Page 2 : Additional Details");	//Label to the frame
		additional_details.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		additional_details.setBounds(300, 60, 300, 40); // set location and height width
		add(additional_details); // Show the text in frame
		
		JLabel religion = new JLabel("Religion : ");	//Label to the frame
		religion.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		religion.setBounds(100, 150, 150, 40); // set location and height width
		add(religion); // Show the text in frame
		
		String valReligion[] = {"Hindu", "Sikh", "Christian", "Others"}; //to get multiple options
		religionBox = new JComboBox(valReligion); //to select multiple options 
		religionBox.setBounds(300, 155, 250, 30); //to set location
		religionBox.setFont(new Font("Raleway", Font.BOLD, 15));		//set font size etc
		add(religionBox); // display box field

		JLabel category = new JLabel("Caregory : ");	//Label to the frame
		category.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		category.setBounds(100, 200, 200, 40); // set location and height width
		add(category); // Show the text in frame
		
		String valCategory[] = {"General" , "OBC", "SC", "NT", "OTHER"};
		categoryBox = new JComboBox(valCategory); // to get text of category
		categoryBox.setBounds(300, 205, 500, 30); // to set location and height and width
		categoryBox.setFont(new Font("Raleway", Font.BOLD, 15));	//to set font type and style 
		add(categoryBox); // display text field
		
		JLabel income = new JLabel("Income : ");	//Label to the frame
		income.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		income.setBounds(100, 250, 150, 40); // set location and height width
		add(income); // Show the text in frame
		
		String valincome[] = {"NULL", "<1,50,000", "<3,50,000", "<5,00,000", "UPTO 10,00,000"};
		incomeBox = new JComboBox(valincome); // to get text of income
		incomeBox.setBounds(300, 255, 500, 30); // to set location and height and width
		incomeBox.setFont(new Font("Raleway", Font.BOLD, 15));	//to set font type and style 
		add(incomeBox); // display text field
		
		JLabel education = new JLabel("Educational : ");	//Label to the frame
		education.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		education.setBounds(100, 300, 150, 40); // set location and height width
		add(education); // Show the text in frame
		
		String valeducation[] = {"10TH PASSOUT", "12TH PASSOUT", "UNDERGRADUATE", "POSTGRADUATE", "OTHER"};
		educationBox = new JComboBox(valeducation); // to get text of education
		educationBox.setBounds(300, 305, 500, 30); // to set location and height and width
		educationBox.setFont(new Font("Raleway", Font.BOLD, 15));	//to set font type and style 
		add(educationBox); // display text field
		
		JLabel occupation = new JLabel("Occupation : ");	//Label to the frame
		occupation.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		occupation.setBounds(100, 350, 150, 40); // set location and height width
		add(occupation); // Show the text in frame
		
		occuTextField = new JTextField();
		occuTextField.setBounds(300, 355, 300, 30);
		occuTextField.setFont(new Font("Raleway", Font.BOLD, 15));
		add(occuTextField);
		
		JLabel pan_no = new JLabel("Pan Number : ");	//Label to the frame
		pan_no.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		pan_no.setBounds(100, 400, 150, 40); // set location and height width
		add(pan_no); // Show the text in frame
		
		pan_noTextField = new JTextField(); // to get text of card no
		pan_noTextField.setBounds(300, 405, 500, 30); // to set location and height and width
		pan_noTextField.setFont(new Font("Raleway", Font.BOLD, 15));	//to set font type and style 
		add(pan_noTextField); // display text field
		
		JLabel adhar_no = new JLabel("Adhar Number : ");	//Label to the frame
		adhar_no.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		adhar_no.setBounds(100, 450, 175, 40); // set location and height width
		add(adhar_no); // Show the text in frame
		
		adhar_noTextField = new JTextField(); // to get text of card no
		adhar_noTextField.setBounds(300, 455, 250, 30); // to set location and height and width
		adhar_noTextField.setFont(new Font("Raleway", Font.BOLD, 15));	//to set font type and style 
		add(adhar_noTextField); // display text field
		
		JLabel senior = new JLabel("Senior Citizen : ");	//Label to the frame
		senior.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		senior.setBounds(100, 500, 150, 40); // set location and height width
		add(senior); // Show the text in frame
		
		seniorYes = new JRadioButton("YES");	//to set radio button
		seniorYes.setBounds(300, 505, 80, 40);	//radio button location
		seniorYes.setBackground(Color.WHITE);	//background for radio button
		add(seniorYes);	//display button
		
		seniorNo = new JRadioButton("NO");		//to set radio button
		seniorNo.setBounds(400, 505, 80, 40);	//radio button location
		seniorNo.setBackground(Color.WHITE);	//background for radio button
		add(seniorNo);	//display button
		
		ButtonGroup seniorGroup = new ButtonGroup();   //group all senior buttons
		seniorGroup.add(seniorYes);		//add senior button in group
		seniorGroup.add(seniorNo);		//add senior button in group
		
		JLabel account = new JLabel("Exisiting Account : ");	//Label to the frame
		account.setFont(new Font("Raleway", Font.BOLD, 20)); // font to the text
		account.setBounds(100, 550, 200, 40); // set location and height width
		add(account); // Show the text in frame
		
		accountYes = new JRadioButton("YES");	//to set radio button
		accountYes.setBounds(300, 555, 80, 40);	//radio button location
		accountYes.setBackground(Color.WHITE);	//background for radio button
		add(accountYes);	//display button
		
		accountNo = new JRadioButton("NO");		//to set radio button
		accountNo.setBounds(400, 555, 80, 40);	//radio button location
		accountNo.setBackground(Color.WHITE);	//background for radio button
		add(accountNo);	//display button
		
		ButtonGroup accountGroup = new ButtonGroup();   //group all senior buttons
		accountGroup.add(accountYes);		//add senior button in group
		accountGroup.add(accountNo);		//add senior button in group
		
		JButton next = new JButton("NEXT"); // add button for next
		next.setBounds(700, 700, 100, 30); // set location and height and width
		next.setFont(new Font("Raleway", Font.BOLD, 15));
		next.addActionListener(this);	//when next button click then specific action should performed 
		add(next); // display button
		
		getContentPane().setBackground(Color.WHITE);	//to set SignUpTwo Background	
		
		setSize(850, 800);		//to set size of frame	
		setLocation(350, 10);	//to set location of frame
		setVisible(true);	//to set visible frame
		
	}
	
	public void actionPerformed(ActionEvent ae) { 	//this will perform action when next button is click
		
		String religion = (String) religionBox.getSelectedItem(); //to get input religion ComboBox and store in String religion
		String category =(String) categoryBox.getSelectedItem();	 //to get input category ComboBox and store in String category
		String income = (String) incomeBox.getSelectedItem();		 //to get input income ComboBox and store in String income
		String education = (String) educationBox.getSelectedItem();	 //to get input education ComboBox and store in String education
		String occupation = occuTextField.getText();	 //to get input occupation text field and store in String occupation
		String pan_no = pan_noTextField.getText();	//to get input pan_no text field and store in String pan_no
		String adhar_no = adhar_noTextField.getText();	//to get input adhar_no text field and store in String adhar_no
		
		String senior_citizen = null;	//to select senior citizen created radio button
		
		if(seniorYes.isSelected()) {	//if radio button seniorYes is selected then inside String senior save YES
			senior_citizen = "YES";
			}else if (seniorNo.isSelected()) { 		//if radio button seniorNo is selected then inside String senior save NO
				senior_citizen = "NO";
			}
		
		String account_existing = null;		//to select senior citizen created radio button
		
		if(accountYes.isSelected()) {	//if radio button accountYes is selected then inside String account save YES
			account_existing = "YES";
		}else if (accountNo.isSelected()) {		//if radio button accountNO is selected then inside String account save NO
			account_existing = "NO";
		}
		
		try {		//try to connect with Data BAse
				JDBC_Connection c = new JDBC_Connection();			//connecting with JDBC
				String query = "INSERT INTO bank_management_system.sign_up_two VALUES('"+form_no+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+pan_no+"', '"+adhar_no+"', '"+senior_citizen+"', '"+account_existing+"')";
				c.s.executeUpdate(query);		//to execute query
				
				//when user fill the info then when user clicks on next then
				setVisible(false);		//user click on next this frame will be off and
				new SignUpThree(form_no).setVisible(true);	//and SigUpThree Frame will open 
			
		} catch (Exception e) {		//if the connection is no establish then catch throws error
			System.out.println(e);	//the error
		}
	}
	
	

	public static void main(String[] args) {
		new SignUpTwo("");		//Run SignUpOne Class
	}

}
