package it.itsrizzoli.N4W.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import it.itsrizzoli.N4W.dao.AstaDao;
import it.itsrizzoli.N4W.models.db.Asta;

@Controller
@EnableWebMvc
public class HelloController {
	
	@Autowired
	private AstaDao astaRepository;
	
	@GetMapping(value = "/")
	public String index( Model model ) {
		
		List<Asta> astaList=astaRepository.findAllAste();
		List<Asta> aste=new ArrayList<>();
		java.util.Date d=new java.util.Date();
		Date oggi=new Date(d.getTime());
		for (Asta a:astaList) {
			if(a.getDataFine().compareTo(oggi)>=0 && a.getVincitoreAsta()==null)
				aste.add(a);
		}
		model.addAttribute("aste",aste);
		model.addAttribute("hello", "Hello there");
		return "hp";
	}
	
	@GetMapping(value = "/hp")
	public String hp( Model model ) {
		return index( model );
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
}
