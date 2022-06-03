package registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

	public static Connection getConnection()
	{
		Connection con=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/attendance_module","root","");
			System.out.println("CONGO");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}