package it.itsrizzoli.N4W.models;

import java.io.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professione implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
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
	
}
