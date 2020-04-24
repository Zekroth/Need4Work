package it.itsrizzoli.N4W.models.db;

import java.io.Serializable;
import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
public class Offerta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name="email_utente")
	@ManyToOne
	@NotNull
	private Utente utente;
	
	@JoinColumn(name="id_asta")
	@NotNull
	@ManyToOne
	private Asta asta;
	
	@NotNull
	@DecimalMax(value = "9999.99")
	@DecimalMin(value = "0020.00")
	private Double prezzo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Asta getAsta() {
		return asta;
	}

	public void setAsta(Asta asta) {
		this.asta = asta;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * @param id
	 * @param utente
	 * @param asta
	 * @param prezzo
	 */
	public Offerta(@NotNull Long id, @NotNull Utente utente, @NotNull Asta asta,
			@NotNull @DecimalMax("9999.99") @DecimalMin("0020.00") Double prezzo) {
		this.id = id;
		this.utente = utente;
		this.asta = asta;
		this.prezzo = prezzo;
	}

	/**
	 * 
	 */
	public Offerta() {
	}
	
	
	public Offerta(@NotNull Utente utente, @NotNull Asta asta,
			@NotNull @DecimalMax("9999.99") @DecimalMin("0020.00") Double prezzo) {
		this.utente = utente;
		this.asta = asta;
		this.prezzo = prezzo;
	}

}
