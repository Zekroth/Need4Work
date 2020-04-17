package it.itsrizzoli.N4W.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;



public interface DBHandler {
	
	public static final class DBHI{
		static boolean flag = true;
	}
	
	public default Connection getDBConnection(String dbName) {
		Connection conn = null;
		if(DBHandler.DBHI.flag) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				DBHandler.DBHI.flag = false;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			
			
		    conn =
		       DriverManager.getConnection("jdbc:mysql://localhost:3308/"+ dbName +"?" +
		                                   "user=root&password=Edogaming98&serverTimezone=Europe/Amsterdam");

		    return conn;
		  
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return null;
	}
	
	
	
}
