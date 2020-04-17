package it.itsrizzoli.N4W.models;

import javax.validation.constraints.*;

public class LoginForm {
	
	@NotNull
	@Email
	@Size(min = 3, max = 300)
	String email;
	
	@NotNull
	@Size(min = 8, max = 20)
	String passwrod;
	
	public String getPasswrod() {
		return passwrod;
	}
	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
