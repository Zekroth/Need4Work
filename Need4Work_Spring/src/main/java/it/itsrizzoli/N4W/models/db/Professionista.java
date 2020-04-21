package it.itsrizzoli.N4W.models.db;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

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
