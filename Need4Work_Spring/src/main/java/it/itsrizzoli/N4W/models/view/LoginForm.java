package it.itsrizzoli.N4W.models.view;

import javax.validation.constraints.*;

public class LoginForm {
	
	@NotNull
	@Email
	@Size(min = 3, max = 300)
	String email;
	
	@NotNull
	@Size(min = 8, max = 20)
	String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
