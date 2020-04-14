package it.iftsrizzoli.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


import it.iftsrizzoli.models.CD;

public interface DBHandler {
	
	public static final class DBHI{
		static boolean flag = true;
	}
	
	public default Connection getDBConnection() {
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
			
			String dbName  = "";
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
