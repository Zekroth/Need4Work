package it.itsrizzoli.N4W.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RecensioneJdbcDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public void pubblicaRecensione(String commento, int voto) {
		String sql="INSERT INTO `recensione` (`id`, `commento`, `voto`) VALUES (NULL, ?, ?)";
		jdbcTemplate.update(sql, commento, voto);
	}
	
	public void associaRecensione(long idRecensione, long idLavoro) {
		String sql="UPDATE `lavoro` SET `id_recensione` = ? WHERE `lavoro`.`id_lavoro` = ?";
		jdbcTemplate.update(sql, idRecensione, idLavoro);
	}


}
