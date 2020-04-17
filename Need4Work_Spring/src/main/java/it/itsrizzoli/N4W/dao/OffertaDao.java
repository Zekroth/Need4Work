package it.itsrizzoli.N4W.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.itsrizzoli.N4W.models.db.Offerta;

public interface OffertaDao extends CrudRepository<Offerta, Long>{
	
	Offerta findById(long id);
	List<Offerta> findByAstaId(long id);
	List<Offerta> findByEmail(String email);

}
