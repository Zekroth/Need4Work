package it.itsrizzoli.N4W.controllers;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

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
		
		asta.setProprietarioAsta((Utente) session.getAttribute("loggedUser"));
		asta.setPrezzoChiusura(null);
		asta.setVincitoreAsta(null);
		astaRepository.save(asta);
		
		model.addAttribute("msg", "Asta creata");
		return "redirect:/paginaUtenteInserzionista";
	}
	
	@RequestMapping("/modificaProfilo")
	public ModelAndView modificaProfilo(HttpSession session) {
		Utente utente=(Utente) session.getAttribute("loggedUser");
		
		ModelAndView mav=new ModelAndView();
		
		if(utente!=null) {
			mav.setViewName("modificaProfiloInserzionista");
			mav.addObject("utente",utente);
			return mav;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value="/modificaProfilo", method=RequestMethod.POST)
	public String postModificaProfilo(@ModelAttribute Utente utente) {
		
		userRepository.save(utente);
		
		return "redirect:/paginaUtenteInserzionista";
	}
	
	@GetMapping("/paginaUtenteInserzionista")
	public String paginaUtenteInserzionista(Model model, HttpSession session) {
		Utente utente=(Utente) session.getAttribute("loggedUser");
		if (utente!=null) {
			
			List<Asta> aste=astaRepository.findByProprietarioAsta(utente);
			
			model.addAttribute("utente",utente);
			model.addAttribute("asta",aste);
			return "paginaUtenteInserzionista";
		}
		return "redirect:/login";
	}

}
