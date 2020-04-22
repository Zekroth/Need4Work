package it.itsrizzoli.N4W.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.itsrizzoli.N4W.models.db.Professionista;
import it.itsrizzoli.N4W.models.db.id.ProfessionistaId;

public interface ProfessionistaDao extends CrudRepository<Professionista, ProfessionistaId>{
	
	public Professionista findByProfessionistaId(ProfessionistaId professionistaId);
	
	@Query("delete from Professionista p where p.professionistaId.utente.email=:email")
	public void deleteProfessionistaByEmail(@Param("email") String email);
	
	
}
