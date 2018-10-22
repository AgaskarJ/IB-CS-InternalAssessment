import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;


public class CommonLibrary 
{
	public static String errMsg;
	public static Connection getConnection()
	{
		Connection myConn = null; 

		try {
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:8889/DailyActivity", "root", "root");
		return myConn;
		}
		catch (Exception E)
		{
			errMsg = E.getMessage();
			return null;
		}
	}
	
	public static void println(String msg)
	{
		System.out.println( msg );
	}
			
			
}
