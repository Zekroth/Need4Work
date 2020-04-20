package it.itsrizzoli.N4W.models.db;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Utente {
	
	@NotNull
	@Size(min = 3, max = 100)
	String nome;
	
	@NotNull
	@Size(min = 3, max = 100)
	String cognome;
	
	@NotNull
	@Column(name="data_nascita")
	Date dataNascita;
	
	@NotNull
	@Size(min = 3, max = 300)
	String via;
	
	@NotNull
	@Size(min = 3, max = 100)
	String paese;
	
	@NotNull
	@Size(min = 2, max = 2)
	String provincia;
	
	@Id
	@Size(min = 3, max = 300)
	@Email
	String email; //chiave primaria
	
	@Size(min = 9, max = 10)
	String cellulare;
	
	@NotNull
	@Size(min = 8, max = 20)
	String password;
	
	@NotNull
	@Size(min = 5, max = 5)
	int cap;
	
	
	public Utente() {}

	public Utente(@Size(min = 3, max = 300) @Email String email, @NotNull @Size(min = 8, max = 20) String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public Utente(@NotNull @Size(min = 3, max = 100) String nome, @NotNull @Size(min = 3, max = 100) String cognome,
			@NotNull Date dataNascita, @NotNull @Size(min = 3, max = 300) String via,
			@NotNull @Size(min = 3, max = 100) String paese, @NotNull @Size(min = 2, max = 2) String provincia,
			@Size(min = 3, max = 300) @Email String email, @Size(min = 9, max = 10) String cellulare,
			@NotNull @Size(min = 8, max = 20) String password, @NotNull @Size(min = 5, max = 5) int cap) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.via = via;
		this.paese = paese;
		this.provincia = provincia;
		this.email = email;
		this.cellulare = cellulare;
		this.password = password;
		this.cap = cap;
	}
	

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

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getPaese() {
		return paese;
	}

	public void setPaese(String paese) {
		this.paese = paese;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

}
