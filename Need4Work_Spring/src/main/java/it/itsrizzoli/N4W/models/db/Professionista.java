package it.itsrizzoli.N4W.models.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Professionista implements Serializable{
	
	@Id
	@OneToMany
	@JoinColumn(name="email_utente")
	private Utente utente;
	
	@Id
	@OneToMany
	@JoinColumn(name="id_professione")
	private Professione professione;

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

	/**
	 * @param utente
	 * @param professione
	 */
	public Professionista(Utente utente, Professione professione) {
		this.utente = utente;
		this.professione = professione;
	}

	/**
	 * 
	 */
	public Professionista() {
	}
	
	
}
