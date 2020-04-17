package it.itsrizzoli.N4W.models.view;


import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class LoginformProgetto {
	
	@NotEmpty
	@Size(min = 5, max = 10)
	String username;
	
	@NotEmpty
	@Size(min = 5, max = 15)
	String passwrod;
	
	@NotEmpty
	@Email
	String email;
	
	
	String group[];
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
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
	public String[] getGroup(){
		return group;
	}
	public void setGroup(String[] group) {
		this.group = group;
	}
	
	
}
