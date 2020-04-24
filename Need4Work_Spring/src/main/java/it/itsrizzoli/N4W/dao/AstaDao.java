package it.itsrizzoli.N4W.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.itsrizzoli.N4W.models.db.Asta;
import it.itsrizzoli.N4W.models.db.Utente;

public interface AstaDao extends CrudRepository<Asta, Long>{
	
	Asta findByidAsta(long idAsta);
	List<Asta> findByProprietarioAsta(Utente utente);
	List<Asta> findByVincitoreAsta(String vincitoreAsta);
	List<Asta> findByProfessioneRichiesta(String professioneRichiesta);
	List<Asta> findByPrezzoPartenza(Double prezzoPartenza);
	
	@Query("SELECT a FROM Asta a")
	public List<Asta> findAllAste();

}
