package it.itsrizzoli.N4W.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class HelloController {
	
	@RequestMapping("/")
	public String index( Model model ) {
		System.out.println("ciao");
		
		model.addAttribute("hello", "Hello there");
		
		return "hello";
	}
	@GetMapping("/error")
	public String error() {
		return "error";
	}
}
