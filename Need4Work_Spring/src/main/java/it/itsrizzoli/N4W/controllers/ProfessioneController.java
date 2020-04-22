package it.itsrizzoli.N4W.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import it.itsrizzoli.N4W.dao.ProfessioneDao;
import it.itsrizzoli.N4W.dao.ProfessionistaDao;
import it.itsrizzoli.N4W.models.db.Professione;
import it.itsrizzoli.N4W.models.db.Utente;
import it.itsrizzoli.N4W.models.db.id.ProfessionistaId;

@Controller
public class ProfessioneController {
	
	@Autowired
	private ProfessioneDao professioneRepository;
	
	@Autowired
	private ProfessionistaDao professionistaRepository;
	
	@GetMapping(value = "/dp")
	public String displayProfessioni(Model model, HttpSession session) {
		
		model.addAttribute("Professioni", professioneRepository.findAll());
		Utente loggedUser = (Utente) session.getAttribute("loggedUser");
		//filtro professionisti
		if(loggedUser != null) {
			model.addAttribute("Professione",
					((List<Professione>) model.getAttribute("Professioni"))
						.removeIf(x-> 
							professionistaRepository.findById(new ProfessionistaId(loggedUser, x)).isEmpty()
						)
			);
		}
		return "fragments/_DisplayProfessioni";
	}
	
	
}
