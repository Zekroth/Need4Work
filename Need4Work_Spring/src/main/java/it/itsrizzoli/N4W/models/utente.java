package it.itsrizzoli.N4W.models;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class utente {
	
	@NotNull
	@Size(min = 3, max = 100)
	String nome;
	
	@NotNull
	@Size(min = 3, max = 100)
	String cognome;
	
	@NotNull
	Date datanascita;
	
	@NotNull
	@Size(min = 3, max = 300)
	String via;
	
	@NotNull
	@Size(min = 3, max = 100)
	String paese;
	
	@NotNull
	@Size(min = 2, max = 2)
	String provincia;
	
	@NotNull
	@Size(min = 3, max = 300)
	@Email
	String email; //chiave primaria
	
	@Size(min = 9, max = 10)
	int cellulare;
	
	@NotNull
	@Size(min = 8, max = 20)
	String password;
	
	@NotNull
	@Size(min = 5, max = 5)
	int cap;

	public String getEmail() {
	return email;
	}

	public void setEmail(String email) {
	this.email = email;
	}

	public String getPassword() {
	return password;
	}

	public void setPassword(String password) {
	this.password = password;
	}

	public Date getData_nascita() {
	return data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
	this.data_nascita = data_nascita;
	}

	public String getNome() {
	return Nome;
	}

	public void setNome(String nome) {
	Nome = nome;
	}

	public String getCognome() {
	return Cognome;
	}

	public void setCognome(String cognome) {
	Cognome = cognome;
	}

	public String getVia() {
	return Via;
	}

	public void setVia(String via) {
	Via = via;
	}

	public String getCAP() {
	return CAP;
	}

	public void setCAP(String cAP) {
	CAP = cAP;
	}

	public String getPaese() {
	return Paese;
	}

	public void setPaese(String paese) {
	Paese = paese;
	}

	public String getProvincia() {
	return Provincia;
	}

	public void setProvincia(String provincia) {
	Provincia = provincia;
	}

	public String getCellulare() {
	return Cellulare;
	}

	public void setCellulare(String cellulare) {
	Cellulare = cellulare;
	}

}
