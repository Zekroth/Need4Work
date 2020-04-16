package it.itsrizzoli.N4W.models;


import java.util.Date;

import javax.validation.constraints.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class RegistrazioneFormProfessionista {

	@NotEmpty
	@Size(min = 3, max = 15)
	String nome;
	
	@NotEmpty
	@Size(min = 3, max = 15)
	String cognome;
	

	
	@NotEmpty
	Date datanascita;
	
	@NotEmpty
	String via;
	
	@NotEmpty
	String paese;
	
	@NotEmpty
	String email;
	
	@NotEmpty
	int cellulare;
	
	@NotEmpty
	String password;
	
	
	String[] group;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getPaese() {
		return paese;
	}

	public void setPaese(String paese) {
		this.paese = paese;
	}

	public Date getDataNascita() {
		return datanascita;
	}

	public void setDataNascita(Date datanascita) {
		this.datanascita = datanascita;
	}
	
	public String getVia() {
		return via;
	}
	
	public void setVia(String via) {
		this.via = via;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public int getCellulare() {
		return cellulare;
	}
	
	public void setCellulare(int cellulare) {
		this.cellulare=cellulare;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public String[] getGroup() {
		return group;
	}
	
	public void setGroup(String[] group) {
		this.group = group;
	}
	
}
