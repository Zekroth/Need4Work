package it.itsrizzoli.N4W.dao;

import org.springframework.data.repository.CrudRepository;

import it.itsrizzoli.N4W.models.db.Recensione;

public interface RecensioneDao extends CrudRepository<Recensione, Long>{
	
	Recensione findById(long id);

}
