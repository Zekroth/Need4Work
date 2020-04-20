package it.itsrizzoli.N4W.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.itsrizzoli.N4W.models.db.Utente;

public interface UtenteDao extends CrudRepository<Utente, String>{
	
	List<Utente> findByNome(String nome);
	List<Utente> findByCognome(String cognome);
	List<Utente> findByPassword(String password);
	List<Utente> findByPaese(String paese);
	List<Utente> findByProvincia(String provincia);
	List<Utente> findByDataNascita(Date dataNascita);
	Utente findByEmail(String email);

}
