package it.itsrizzoli.N4W.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.itsrizzoli.N4W.models.db.Asta;

public interface AstaDao extends CrudRepository<Asta, Long>{
	
	Asta findById(long id);
	List<Asta> findByProprietarioAsta(String proprietarioAsta);
	List<Asta> findByVincitoreAsta(String vincitoreAsta);
	List<Asta> findByProfessioneRichiesta(String professioneRichiesta);
	List<Asta> findByPrezzoPartenza(Double prezzoPartenza);

}
