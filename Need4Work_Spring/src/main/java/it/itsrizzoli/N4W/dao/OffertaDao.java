package it.itsrizzoli.N4W.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.itsrizzoli.N4W.models.db.Asta;
import it.itsrizzoli.N4W.models.db.Offerta;
import it.itsrizzoli.N4W.models.db.Utente;

public interface OffertaDao extends CrudRepository<Offerta, Long>{
	
	Offerta findById(long id);
	List<Offerta> findByAsta(Asta asta);
	List<Offerta> findByUtente(Utente utente);

}
