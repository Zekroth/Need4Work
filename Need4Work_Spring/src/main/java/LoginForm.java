

import javax.validation.constraints.*;

public class LoginForm {
	
	@NotNull
	@Email
	String email;
	
	@NotNull
	@Size(min = 5, max = 15)
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
