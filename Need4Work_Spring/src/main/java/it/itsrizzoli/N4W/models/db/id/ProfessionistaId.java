package it.itsrizzoli.N4W.models.db.id;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import it.itsrizzoli.N4W.models.db.Professione;
import it.itsrizzoli.N4W.models.db.Utente;

@Embeddable
public class ProfessionistaId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "email_utente", referencedColumnName = "email")
	private Utente utente;
	
	@ManyToOne
	@JoinColumn(name="id_professione", referencedColumnName = "id")
	private Professione professione;

	/**
	 * @param utente
	 * @param professione
	 */
	public ProfessionistaId(Utente utente, Professione professione) {
		this.utente = utente;
		this.professione = professione;
	}

	/**
	 * 
	 */
	public ProfessionistaId() {
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Professione getProfessione() {
		return professione;
	}

	public void setProfessione(Professione professione) {
		this.professione = professione;
	}
	
	
	
}
