package it.itsrizzoli.N4W.models.db;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Asta implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_asta")
	private Long idAsta;
	
	@ManyToOne
	@JoinColumn(name="email_utente")
	private Utente ProprietarioAsta;
	
	@Column(name="data_inizio")
	private Date dataInizio;
	
	@Column(name="data_fine")
	private Date dataFine;
	
	@ManyToOne
	@JoinColumn(name="email_vincitore")
	private Utente vincitoreAsta;
	
	@Column(name="prezzo_partenza")
	private Double prezzoPartenza;
	
	@Column(name="prezzo_chiusura")
	private Double prezzoChiusura;
	
	@Size(min=5,max=100)
	@NotNull
	private String titolo;
	
	@Size(min=30,max=500)
	@NotNull
	private String commento;
	
	@ManyToOne
	@JoinColumn(name="professione_richiesta")
	private Professione professioneRichiesta;

	public Long getIdAsta() {
		return idAsta;
	}

	public void setIdAsta(Long idAsta) {
		this.idAsta = idAsta;
	}

	public Utente getProprietarioAsta() {
		return ProprietarioAsta;
	}

	public void setProprietarioAsta(Utente proprietarioAsta) {
		ProprietarioAsta = proprietarioAsta;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Utente getVincitoreAsta() {
		return vincitoreAsta;
	}

	public void setVincitoreAsta(Utente vincitoreAsta) {
		this.vincitoreAsta = vincitoreAsta;
	}

	public Double getPrezzoPartenza() {
		return prezzoPartenza;
	}

	public void setPrezzoPartenza(Double prezzoPartenza) {
		this.prezzoPartenza = prezzoPartenza;
	}

	public Double getPrezzoChiusura() {
		return prezzoChiusura;
	}

	public void setPrezzoChiusura(Double prezzoChiusura) {
		this.prezzoChiusura = prezzoChiusura;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public Professione getProfessioneRichiesta() {
		return professioneRichiesta;
	}

	public void setProfessioneRichiesta(Professione professioneRichiesta) {
		this.professioneRichiesta = professioneRichiesta;
	}

	/**
	 * @param idAsta
	 * @param proprietarioAsta
	 * @param dataInizio
	 * @param dataFine
	 * @param vincitoreAsta
	 * @param prezzoPartenza
	 * @param prezzoChiusura
	 * @param titolo
	 * @param commento
	 * @param professioneRichiesta
	 */
	public Asta(Long idAsta, Utente proprietarioAsta, Date dataInizio, Date dataFine, Utente vincitoreAsta,
			Double prezzoPartenza, Double prezzoChiusura, String titolo, String commento,
			Professione professioneRichiesta) {
		this.idAsta = idAsta;
		ProprietarioAsta = proprietarioAsta;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.vincitoreAsta = vincitoreAsta;
		this.prezzoPartenza = prezzoPartenza;
		this.prezzoChiusura = prezzoChiusura;
		this.titolo = titolo;
		this.commento = commento;
		this.professioneRichiesta = professioneRichiesta;
	}

	/**
	 * 
	 */
	public Asta() {
	}
	
	
}
