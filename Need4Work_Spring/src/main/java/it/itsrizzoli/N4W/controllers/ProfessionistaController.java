package it.itsrizzoli.N4W.controllers;

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
		return "fragments/_FormAddProfessione";
	}
	@PostMapping(value = "/add")
	public String addProfessionist(Model model, HttpSession session, @RequestParam("professioni") Set<Integer> ids) {
		
		return "";
	}
}
