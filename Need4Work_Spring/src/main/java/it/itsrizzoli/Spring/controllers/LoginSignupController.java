package it.itsrizzoli.Spring.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

@Controller
public class LoginSignupController {
	
	@GetMapping("/signUpInserzionista")
	public String signUpInserzionista(SignUpInserzionistaForm signUpInserzionistaForm) {
		return "signUpInserzionista";
	}
	
	@PostMapping("/signUpInserzionista")
	public String postSignUpInserzionista(@Valid SignUpInserzionistaForm signUpInserzionistaForm, BindingResult res) {
		if (res.hasErrors())
			return "signUpInserzionista";
		
		
		return "iscrizioneEseguita";
	}
	
	@GetMapping("/signUpProfessionista")
	public String signUpProfessionista(SignUpProfessionistaForm signUpProfessionistaForm) {
		return "signUpProfessionista";
	}
	
	@PostMapping("/signUpProfessionista")
	public String postSignUpProfessionista(@Valid SignUpProfessionistaForm signUpProfessionistaForm, BindingResult res) {
		if (res.hasErrors())
			return "signUpProfessionista";
		
		
		return "iscrizioneEseguita";
	}
	
	@GetMapping("/login")
	public String login(LoginForm loginForm) {
		return "login";
	}
	
	@PostMapping("/login")
	public String postLogin(@Valid LoginForm loginForm, BindingResult res) {
		if (res.hasErrors())
			return "login";
		
		
		return null;	//da modificare per far andare in una pagina o l'altra a seconda di chi si sia autenticato
	}
	
	@GetMapping("/sceltaAccount")
	public String sceltaAccount() {
		return "sceltaAccount";
	}
	
	@GetMapping("/iscrizioneEseguita")
	public String iscrizioneEseguita() {
		return "iscrizioneEseguita";
	}

}
