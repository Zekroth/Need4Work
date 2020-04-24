package it.itsrizzoli.N4W.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.itsrizzoli.N4W.models.db.Professione;

public interface ProfessioneDao extends CrudRepository<Professione, Long>{
	
	public Professione findById(long id);
	public List<Professione> findByTipologia(String tipologia);
	
	@Query(value="SELECT * FROM Professione INNER JOIN Professionista ON Professione.id = Professionista.id_professione WHERE Professionista.email_utente = ?1", nativeQuery = true)
	public List<Professione> findByUser(String email);
}
