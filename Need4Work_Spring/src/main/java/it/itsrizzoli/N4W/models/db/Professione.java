package it.itsrizzoli.N4W.models.db;

import java.io.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Professione implements Serializable{
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=5,max=100)
	private String tipologia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	/**
	 * @param id
	 * @param tipologia
	 */
	public Professione(Long id, String tipologia) {
		this.id = id;
		this.tipologia = tipologia;
	}

	/**
	 * @param id
	 */
	public Professione(Long id) {
		this.id = id;
		this.tipologia = "";
	}
	
	public Professione() {
		
	}
	
}
