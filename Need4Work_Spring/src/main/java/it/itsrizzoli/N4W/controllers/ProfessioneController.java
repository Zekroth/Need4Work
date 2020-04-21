package it.itsrizzoli.N4W.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.itsrizzoli.N4W.dao.ProfessioneDao;

@Controller
public class ProfessioneController {
	
	@Autowired
	private ProfessioneDao professioneRepository;
	
	@GetMapping(value = "/dp")
	public String displayProfessioni(Model model) {
		
		model.addAttribute("Professioni", professioneRepository.findAll());
		
		return "fragments/_DisplayProfessioni";
	}
	
	@GetMapping(value = "/dp/{email}")
	public String displayProfessioni(Model model, @PathVariable(value="email") String email) {
		model.addAttribute("Professioni", professioneRepository.findByUser(email));
		System.out.println("Utente ha: " + professioneRepository.findByUser(email).size() + " professioni");
		
		return "fragments/_DisplayProfessioni";
	}
}
