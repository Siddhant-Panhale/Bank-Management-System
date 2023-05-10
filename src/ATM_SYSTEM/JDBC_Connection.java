package ATM_SYSTEM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connection {		//JDBC FOR JAVA AND DATABASE CONNECTION CLASS
	//GLOBAL VARIABLE DECLARATION
	static Connection c;		
	 Statement s;

	public JDBC_Connection(){	//class
		try {		//try to connect with database
			
			c = DriverManager.getConnection("jdbc:mysql:///bank_management_system", "root", "root");		//to connect with date base we use Driver manager to get connection using database Host name then user name and user password
			s = c.createStatement();		//to execute the query we create statement for that query
		}
		
		catch (SQLException e) {		//if the connection is failed then catch will throw the error
			System.out.println(e);		//the error as e
		}
	}
}