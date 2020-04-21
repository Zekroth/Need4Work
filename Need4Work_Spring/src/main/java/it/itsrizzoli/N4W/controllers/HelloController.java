package it.itsrizzoli.N4W.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class HelloController {
	
	@GetMapping(value = "/")
	public String index( Model model ) {
		
		
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
