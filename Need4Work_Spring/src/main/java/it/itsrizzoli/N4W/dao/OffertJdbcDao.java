package it.itsrizzoli.N4W.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OffertJdbcDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public void pubblicaOfferta(String email_utente, long id_asta, double prezzo) {
		String sql="INSERT INTO `offerta` (`id`, `email_utente`, `id_asta`, `prezzo`) VALUES (NULL, ?, ?, ?)";
		jdbcTemplate.update(sql, email_utente, id_asta, prezzo);
	}
        
                

}
