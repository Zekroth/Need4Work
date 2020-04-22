package it.itsrizzoli.N4W.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.itsrizzoli.N4W.models.db.Lavoro;

public interface LavoroDao extends CrudRepository<Lavoro, Long>{
	
	

}
