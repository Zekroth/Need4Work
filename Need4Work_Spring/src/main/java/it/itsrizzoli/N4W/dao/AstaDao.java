package it.itsrizzoli.N4W.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.itsrizzoli.N4W.models.db.Asta;
import it.itsrizzoli.N4W.models.db.Utente;

public interface AstaDao extends CrudRepository<Utente, Long>{
	
	Asta findByIdAsta(long idAsta);
	List<Asta> findByProprietarioAsta(String proprietarioAsta);
	List<Asta> findByVincitoreAsta(String vincitoreAsta);
	List<Asta> findByProfessioneRichiesta(String professioneRichiesta);
	List<Asta> findByPrezzoPartenza(Double prezzoPartenza);

}