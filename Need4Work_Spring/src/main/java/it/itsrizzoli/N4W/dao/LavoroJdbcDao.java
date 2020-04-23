package it.itsrizzoli.N4W.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LavoroJdbcDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public void accettaAsta(long id_asta) {
		String sql="INSERT INTO `lavoro` (`id_lavoro`, `id_asta`, `id_recensione`) VALUES (NULL, ?, NULL)";
		jdbcTemplate.update(sql, id_asta);
	}

}
