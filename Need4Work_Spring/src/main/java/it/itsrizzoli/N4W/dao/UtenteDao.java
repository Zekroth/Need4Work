package it.itsrizzoli.N4W.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.itsrizzoli.N4W.models.db.Utente;

public interface UtenteDao extends CrudRepository<Utente, String>{
	
	List<Utente> findByNome(String nome);
	List<Utente> findByCognome(String cognome);
	List<Utente> findByPassword(String password);
	List<Utente> findByPaese(String paese);
	List<Utente> findByProvincia(String provincia);
	Utente findByEmail(String email);

}
