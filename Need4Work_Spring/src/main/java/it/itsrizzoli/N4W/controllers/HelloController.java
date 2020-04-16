package it.itsrizzoli.N4W.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/")
	public String index() {
		return "hello";
	}
}
