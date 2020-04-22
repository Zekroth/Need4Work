package it.itsrizzoli.N4W.controllers;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.itsrizzoli.N4W.dao.AstaDao;
import it.itsrizzoli.N4W.dao.OffertaDao;
import it.itsrizzoli.N4W.dao.ProfessioneDao;
import it.itsrizzoli.N4W.dao.ProfessionistaDao;
import it.itsrizzoli.N4W.dao.UtenteDao;
import it.itsrizzoli.N4W.models.db.Asta;
import it.itsrizzoli.N4W.models.db.Offerta;
import it.itsrizzoli.N4W.models.db.Professionista;
import it.itsrizzoli.N4W.models.db.Utente;

@Controller
@RequestMapping("/pro")
public class ProfessionistaController {
	
	@Autowired
	private ProfessioneDao professionRepo;
	@Autowired
	private ProfessionistaDao professionistRepo;
	@Autowired
	private AstaDao astaRepository;
	@Autowired
	private UtenteDao userRepository;
	@Autowired
	private OffertaDao offertaRepository;
	
	@GetMapping("/add")
	public String addProfessionist(HttpSession session, Model model) {
		model.addAttribute("professionList", professionRepo.findAll());
		
		if(session.getAttribute("loggedUser")== null) {
			return "redirect:/hp";
		}
		return "selezioneProfessione";
	}
	
	@PostMapping(value = "/add")
	public String addProfessionist(Model model, HttpSession session, @RequestParam("selected") List<String> selected) {
		
		if(session.getAttribute("loggedUser")== null) {
			return "redirect:/error";
		}
		
		selected.forEach(x -> 
			professionistRepo.save(
				new Professionista((Utente)session.getAttribute("loggedUser"),
						professionRepo.findById(Long.valueOf(x)).get())));
		
		return "redirect:/hp";
	}
	
	@GetMapping(value = "/profile")
	public String viewProfile(Model model, HttpSession session) {
		return "profiloProfessionista";
	}
	
	@GetMapping("/inserzioneCercata/{idAsta}")
	public String inserzioneCercata(@PathVariable ("idAsta") long idAsta, Model model) {
		Asta asta=astaRepository.findByidAsta(idAsta);
		List<Offerta> offerte=offertaRepository.findByAsta(asta);
		//da ordinare la lista offerte
		if(asta!=null) {
			model.addAttribute("offerte",offerte);
			model.addAttribute("asta", asta);
			return "inserzioneCercata";
		} else {
			return null;
		}
	}
	
	@PostMapping("/faiOfferta")
	public String postFaiOfferta(@RequestParam ("prezzo") double prezzo, @RequestParam ("idAsta") long idAsta, BindingResult res, Model model, HttpSession session) {
		Utente utente=(Utente) session.getAttribute("loggedUser");
		if (utente!=null && res.hasErrors()==false) {
			Offerta offerta=new Offerta();
			Asta asta=astaRepository.findByidAsta(idAsta);
			offerta.setPrezzo(prezzo);
			offerta.setAsta(asta);
			offerta.setUtente(utente);
			offertaRepository.save(offerta);
			model.addAttribute("msg", "Offerta andata a buon fine");
			return "redirect:/profile";
		} else {
			return "inserzioneCercata";
		}
	}
	
}
