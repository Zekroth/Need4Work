package it.itsrizzoli.N4W.models.db;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import it.itsrizzoli.N4W.models.db.id.ProfessionistaId;

@Entity
public class Professionista implements Serializable{
	
	@EmbeddedId
	private ProfessionistaId professionistaId;

	public Utente getUtente() {
		return professionistaId.getUtente();
	}

	public void setUtente(Utente utente) {
		this.professionistaId.setUtente(utente);
	}

	public Professione getProfessione() {
		return professionistaId.getProfessione();
	}

	public void setProfessione(Professione professione) {
		this.professionistaId.setProfessione(professione);
	}
	public ProfessionistaId getId() {
		return this.professionistaId;
	}
	public void setId(ProfessionistaId proId) {
		this.professionistaId = proId;
	}
	/**
	 * @param professionistaId
	 */
	public Professionista(ProfessionistaId professionistaId) {
		this.professionistaId = professionistaId;
	}
	/**
	 * @param utente
	 * @param professione
	 */
	public Professionista(Utente utente, Professione professione) {
		this.professionistaId = new ProfessionistaId(utente,professione);
	}
	

	/**
	 * 
	 */
	public Professionista() {
	}
	
	
}
