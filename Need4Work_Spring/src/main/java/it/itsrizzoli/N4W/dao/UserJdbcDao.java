package it.itsrizzoli.N4W.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import it.itsrizzoli.N4W.models.db.Utente;

@Repository
public class UserJdbcDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public List<Utente> login(String email, String password) {
        return jdbcTemplate.query(
                "select * from utente where email = ? and password = ?",
                new Object[]{email, password},
                (rs, rowNum) ->
                        new Utente(
                        		rs.getString("nome"),
                        		rs.getString("cognome"),
                        		rs.getDate("data_nascita"),
                        		rs.getString("via"),
                        		rs.getString("paese"),
                        		rs.getString("provincia"),
                        		rs.getString("email"),
                        		rs.getString("cellulare"),
                        		rs.getString("password"),
                        		rs.getInt("cap")
                        )
        );
    }
	
	public List<Utente> findUser(String email) {
        return jdbcTemplate.query(
                "select * from utente where email like ?",
                new Object[]{email},
                (rs, rowNum) ->
                        new Utente(
                        		rs.getString("nome"),
                        		rs.getString("cognome"),
                        		rs.getDate("data_nascita"),
                        		rs.getString("via"),
                        		rs.getString("paese"),
                        		rs.getString("provincia"),
                        		rs.getString("email"),
                        		rs.getString("cellulare"),
                        		rs.getString("password"),
                        		rs.getInt("cap")
                        )
        );
    }

}
