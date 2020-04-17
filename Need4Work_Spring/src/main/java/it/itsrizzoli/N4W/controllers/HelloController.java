package it.itsrizzoli.N4W.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class HelloController {
	
	@GetMapping("/")
	public String index() {
		System.out.println("ciao");
		return "hello";
	}
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	@GetMapping("/error")
	public String error() {
		return "error";
	}
}
