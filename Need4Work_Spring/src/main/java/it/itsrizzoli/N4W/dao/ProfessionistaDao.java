package it.itsrizzoli.N4W.dao;

import org.springframework.data.repository.CrudRepository;

import it.itsrizzoli.N4W.models.db.Professionista;
import it.itsrizzoli.N4W.models.db.id.ProfessionistaId;

public interface ProfessionistaDao extends CrudRepository<Professionista, ProfessionistaId>{
	public Professionista findByProfessionistaId(ProfessionistaId professionistaId);
}
