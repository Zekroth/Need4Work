package it.iftsrizzoli.interfaces;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.RowSet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.iftsrizzoli.models.CD;

public interface DBHandlerImpl extends DBHandler{
	
	public default boolean addToDB(CD cd) throws SQLException {
		
		Connection c = getDBConnection();
		String query = "INSERT INTO cd ( id,titolo, autore) VALUES ( " + cd.setId() + ", \"" + cd.getTitolo() + "\", \"" + cd.getAutore() + "\" );";
		System.out.println("EXECUTING SQL: | "+ query);
		Statement st = c.createStatement();
		return st.execute(query);
		
	}
	
	@Override
	public default List<CD> getCDList() throws SQLException {
		
		Connection c = getDBConnection();
		String query = "SELECT * FROM cd";
		
		Statement st = c.prepareStatement(query);
		
		ResultSet rs = st.executeQuery(query); 
		System.out.println("EXECUTING SQL: | "+ query);
		rs.last();
		int count = rs.getRow();
		rs.first();
		List<CD> list = new ArrayList<CD>();
		for (int i = 0; i < count; i++) {
			list.add(new CD(rs.getInt("id"), rs.getString("titolo"), rs.getString("autore")));

		}
		return null;
	}
	
	public default CD getCD(int id) throws SQLException {
		
		Connection c = getDBConnection();
		String query = "SELECT * FROM cd WHERE cd.id = "+ id+";";
		System.out.println("EXECUTING SQL: | "+ query);
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery(query);
		assert(rs.isFirst() && rs.isLast());
		
		return new CD(rs.getInt("id"),rs.getString("titolo"),rs.getString("autore"));
		
		
	}
}
