package it.itsrizzoli.N4W.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.itsrizzoli.N4W.dao.AstaDao;
import it.itsrizzoli.N4W.dao.UtenteDao;
import it.itsrizzoli.N4W.models.db.Asta;
import it.itsrizzoli.N4W.models.db.Utente;
import it.itsrizzoli.N4W.models.view.CreazioneInserzioneForm;

@Controller
public class InserzionistaController {
	
	@Autowired
	private AstaDao astaRepository;
	@Autowired
	private UtenteDao userRepository;
	
	@GetMapping("/creazioneInserzione")
	public String creazioneInserzione(Asta asta) {
		return "creazioneInserzione";
	}
	
	@PostMapping("/creazioneInserzione")
	public String postCreazioneInserzione(@Valid Asta asta, BindingResult res, Model model, HttpSession session) {
		if (res.hasErrors())
			return "creazioneInserzione";
		
		astaRepository.save(asta);
		return "paginaUtenteInserzionista";
	}
	
	@RequestMapping ("/modificaProfiloInserzionista/{email}")
	public ModelAndView edit(@PathVariable("email") String email) {
		Utente utente = userRepository.findByEmail(email);
		ModelAndView mav=new ModelAndView();
		
		if(utente!=null) {
			mav.setViewName("modificaProfiloInserzionista");
			mav.addObject("utente", utente);
			return mav;
		} else {
			return null;
		}
	}
	
	@RequestMapping (value="/modificaProfiloInserzionista", method=RequestMethod.POST)
	public String postEdit(@ModelAttribute Utente utente) {
		userRepository.save(utente);
		return "redirect:/paginaUtenteInserzionista";
	}
	
	@GetMapping("/paginaUtenteInserzionista")
	public String paginaUtenteInserzionista() {
		return "paginaUtenteInserzionista";
	}

}
