package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class snapdbconnections {
	private static String driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/snap";
	private static String user="root";
	private static String password="robinhood";
	
	private static Connection conn;
	
	public static Connection getconnection() {
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return conn;
		
	}

}
