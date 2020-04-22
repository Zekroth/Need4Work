package it.itsrizzoli.N4W.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import it.itsrizzoli.N4W.dao.UserJdbcDao;
import it.itsrizzoli.N4W.dao.UtenteDao;
import it.itsrizzoli.N4W.models.db.Utente;
import it.itsrizzoli.N4W.models.view.LoginForm;
import it.itsrizzoli.N4W.models.view.SignUpInserzionistaForm;
import it.itsrizzoli.N4W.models.view.SignUpProfessionistaForm;

@Controller
@EnableWebMvc
public class LoginSignupController {
	@Autowired
	private UtenteDao userRepository;	
	@Autowired
    UserJdbcDao userJdbcRepository;
	
	@GetMapping("/signUpInserzionista")
	public String signUpInserzionista(Utente utente) {
		return "signUpInserzionista";
	}
	
	@PostMapping("/signUpInserzionista")
	public String postSignUpInserzionista(@Valid Utente utente, BindingResult res, Model model, HttpSession session) {
		if (res.hasErrors())
			return "signUpInserzionista";
		
		userRepository.save(utente);
		session.setAttribute("loggedUser", utente);


		model.addAttribute("msg", "Informazioni salvate");
		return "redirect:/iscrizioneEseguita";
	}
	
	@GetMapping("/login")
	public String login(LoginForm loginForm) {
		System.out.println("Some1 tried to log");
		return "login";
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public String postLogin(@RequestParam ("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		
		List<Utente> userList = userJdbcRepository.login(email, password);
		
		if(userList.size() == 0)
			return "redirect:/login";
		else {
			session.setAttribute("loggedUser", userList.get(0));
			return "redirect:/pro/profile";	//da modificare per far andare in una pagina o l'altra a seconda di chi si sia autenticato
		}
	}
	
	@GetMapping("/iscrizioneEseguita")
	public String iscrizioneEseguita() {
		return "iscrizioneEseguita";
	}

}
