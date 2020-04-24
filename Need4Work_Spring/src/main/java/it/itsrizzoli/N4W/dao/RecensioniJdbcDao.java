package it.itsrizzoli.N4W.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import it.itsrizzoli.N4W.models.db.Recensione;

@Repository
public class RecensioniJdbcDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public List<Recensione> getAllRecensioni(String email) {
        return jdbcTemplate.query(
                "select recensione.commento, recensione.voto FROM recensione,lavoro,asta WHERE recensione.id=lavoro.id_recensione and lavoro.id_asta=asta.id_asta and asta.email_vincitore= ?",
                new Object[]{email},
                (rs, rowNum) ->
                        new Recensione(
                        		rs.getString("commento"),
                        		rs.getInt("voto")
                        )
        );
    }


}
