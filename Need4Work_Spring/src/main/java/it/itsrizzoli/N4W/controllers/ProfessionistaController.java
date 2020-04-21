package it.itsrizzoli.N4W.controllers;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import it.itsrizzoli.N4W.dao.ProfessioneDao;
import it.itsrizzoli.N4W.dao.ProfessionistaDao;
import it.itsrizzoli.N4W.models.db.Professionista;
import it.itsrizzoli.N4W.models.db.Utente;

@Controller
@RequestMapping("/pro")
public class ProfessionistaController {
	
	@Autowired
	private ProfessioneDao professionRepo;
	@Autowired
	private ProfessionistaDao professionistRepo;
	
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
	
	
	
}
