package it.itsrizzoli.N4W.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InserzionistaController {
	
	@GetMapping("/creazioneInserzione")
	public String creazioneInserzione(CreazioneInserzioneForm creazioneInserzioneForm) {
		return "creazioneInserzione";
	}
	
	@PostMapping("/creazioneInserzione")
	public String postCreazioneInserzione(@Valid CreazioneInserzioneForm creazioneInserzioneForm, BindingResult res) {
		if (res.hasErrors())
			return "creazioneInserzione";
		
		return "paginaUtenteInserzionista";
	}

}
