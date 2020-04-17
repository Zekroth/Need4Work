package it.itsrizzoli.N4W.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.itsrizzoli.N4W.models.db.Professione;

public interface ProfessioneDao extends CrudRepository<Professione, Long>{
	
	Professione findById(long id);
	List<Professione> findByTipologia(String tipologia);

}
