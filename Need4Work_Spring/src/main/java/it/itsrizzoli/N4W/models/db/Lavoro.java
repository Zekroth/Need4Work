package it.itsrizzoli.N4W.models.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Lavoro implements Serializable{
	
	@Id
	@NotNull
	@Column(name="id_lavoro")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@JoinColumn(name="id_asta")
	@OneToOne
	private Asta asta;
	
	@JoinColumn(name="id_recensione")
	@OneToOne
	private Recensione recensione;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Asta getAsta() {
		return asta;
	}

	public void setAsta(Asta asta) {
		this.asta = asta;
	}

	public Recensione getRecensione() {
		return recensione;
	}

	public void setRecensione(Recensione recensione) {
		this.recensione = recensione;
	}

	public Lavoro(@NotNull Long id, @NotNull Asta asta, Recensione recensione) {
		super();
		this.id = id;
		this.asta = asta;
		this.recensione = recensione;
	}

	public Lavoro() {
	}
	
	
	
	
}
