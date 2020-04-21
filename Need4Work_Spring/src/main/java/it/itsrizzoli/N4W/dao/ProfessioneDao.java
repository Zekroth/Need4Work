package it.itsrizzoli.N4W.dao;

import java.util.List;

import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.itsrizzoli.N4W.models.db.Professione;

public interface ProfessioneDao extends CrudRepository<Professione, Long>{
	
	Professione findById(long id);
	List<Professione> findByTipologia(String tipologia);
	
	@Query(value=" select p from Professione p inner join Professionista pro where pro.professionistaId.utente.email = ?1 and p.id = pro.professionistaId.professione.id")
	List<Professione> findByUser(@Param("email") String email);
}
