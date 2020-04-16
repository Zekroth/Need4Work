

import java.util.Date;


import javax.validation.constraints.*;
import javax.validation.constraints.Size;

public class SignUpInserzionistaForm {

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
	String email;
	
	@Size(min = 9, max = 10)
	int cellulare;
	
	@NotNull
	@Size(min = 8, max = 20)
	String password;
	
	@NotNull
	@Size(min = 5, max = 5)
	int cap;
	
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

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
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
	
	
}
