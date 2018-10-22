import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;


public class Users
{
	String uName, uPass, login, email;
	Date DOB;
	char Gender;
	int height, weight, goal; //INT? 
	
	/* Default Constructor - with no parameters */
	public Users()
	{
		uName = ""; // TODO : All other properties to be blank
		uPass = "";
		login = "";
		DOB = new Date(1,1,2000);
		email = "jay@gmail.com";
		Gender = 'M';
		height = 180;
		weight = 80;
		goal = 2000;
		
	}
	
	/* Parameterized Constructor */
	public Users( String nm, String p, String l, Date d, String m, char s, int h, int w, int g) // TODO : All properties to be added 
	{
		uName = nm;
		uPass = p;
		login = l;
		DOB = d;
		email = m;
		Gender = s;
		height = h;
		weight = w; 
		goal = g;
		System.out.println ( DOB.getDay() + " "+ DOB.getMonth() + " " + DOB.getYear());
	}
	
	/* The Set Methods */
	
	void setUName(String nm) 		{	uName = nm;	}
	void setUPass(String p)			{	uPass = p;	}
	
	void setLogin(String l) 		{	login = l;	}
	void setDOB(Date d)			    {	DOB = d;	}
	void setEmail(String m)			{	email = m;	}
	void setGender(char s) 			{	Gender = s;	}
	
	void setHeight(int h) 			{	height = h;	}
	void setWeight(int w) 			{	weight = w;	}
	void setGoal(int g) 			{	goal = g;	}
	
	
	/* The Get Methods */
	
	String getUName()				{	return uName;	}
	String getUPass()				{	return uPass;	}

	String getLogin()				{	return login;	}
	Date getDOB()					{	return DOB;		}
	String getEmail()				{	return email;	}
	char getGender()				{	return Gender;	}
	

	int getHeight()					{	return height;	}
	int getWeight()					{	return weight;	}
	int getGoal()					{	return goal;	}
	
	
	
	/* The DB Interaction */
	void getFromDB()
	{
		
	}

	boolean saveDataToDB()
	{
		Connection myConn = CommonLibrary.getConnection(); 
		PreparedStatement myStmt= null; 
		String sql = "insert into Users (Username, Password, Name, DOB, Email, Gender, Height, Weight, Goal)" +
						" values  " + 
						" (?,?,?,?,?,?,?,?,?) ";
				
		if ( myConn != null )
		{
				try {

					myStmt = (PreparedStatement) myConn.prepareStatement(sql);
					myStmt.setString(1, uName);
					myStmt.setString(2, uPass);
					myStmt.setString(3, login);
					myStmt.setDate(4, DOB);
					myStmt.setString(5, String.valueOf(Gender));
					myStmt.setString(6, email);
					myStmt.setInt(7, height);
					myStmt.setInt(8, weight);
					myStmt.setInt(9, goal);
					
					int i = myStmt.executeUpdate();
					if ( i > 0 )
						return true;
					else
					{
						CommonLibrary.errMsg = " Insert unsuccessful ";
						return false;
					}
				}
				catch (SQLException S)
				{
					CommonLibrary.errMsg = S.getMessage();
					return false;
				}
		}
		else
		{
			return false;	
		}
	}
}
