package it.itsrizzoli.N4W.controllers;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.itsrizzoli.N4W.dao.AstaDao;
import it.itsrizzoli.N4W.dao.LavoroDao;
import it.itsrizzoli.N4W.dao.LavoroJdbcDao;
import it.itsrizzoli.N4W.dao.OffertaDao;
import it.itsrizzoli.N4W.dao.RecensioneDao;
import it.itsrizzoli.N4W.dao.RecensioneJdbcDao;
import it.itsrizzoli.N4W.dao.UtenteDao;
import it.itsrizzoli.N4W.models.db.Asta;
import it.itsrizzoli.N4W.models.db.Lavoro;
import it.itsrizzoli.N4W.models.db.Offerta;
import it.itsrizzoli.N4W.models.db.Recensione;
import it.itsrizzoli.N4W.models.db.Utente;

@Controller
public class InserzionistaController {
	
	@Autowired
	private AstaDao astaRepository;
	@Autowired
	private UtenteDao userRepository;
	@Autowired
	private OffertaDao offertaRepository;
	@Autowired
	private LavoroDao lavoroRepository;
	@Autowired
	private RecensioneDao recensioneRepository;
	@Autowired
	private LavoroJdbcDao jdbcLavoro;
	@Autowired
	private RecensioneJdbcDao jdbcRecensione;
	
	@GetMapping("/creazioneInserzione")
	public String creazioneInserzione(Asta asta) {
		return "creazioneInserzione";
	}
	
	@PostMapping("/creazioneInserzione")
	public String postCreazioneInserzione(@Valid Asta asta, BindingResult res, Model model, HttpSession session) {
		if (res.hasErrors())
			return "creazioneInserzione";
		
		asta.setProprietarioAsta((Utente) session.getAttribute("loggedUser"));
		asta.setPrezzoChiusura(null);
		asta.setVincitoreAsta(null);
		astaRepository.save(asta);
		
		model.addAttribute("msg", "Asta creata");
		return "redirect:/paginaUtenteInserzionista";
	}
	
	@RequestMapping("/modificaProfilo")
	public ModelAndView modificaProfilo(HttpSession session) {
		Utente utente=(Utente) session.getAttribute("loggedUser");
		
		ModelAndView mav=new ModelAndView();
		
		if(utente!=null) {
			mav.setViewName("modificaProfiloInserzionista");
			mav.addObject("utente",utente);
			return mav;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value="/modificaProfilo", method=RequestMethod.POST)
	public String postModificaProfilo(@ModelAttribute Utente utente) {
		
		userRepository.save(utente);
		
		return "redirect:/paginaUtenteInserzionista";
	}
	
	@GetMapping("/paginaUtenteInserzionista")
	public String paginaUtenteInserzionista(Model model, HttpSession session) {
		Utente utente=(Utente) session.getAttribute("loggedUser");
		if (utente!=null) {
			
			List<Asta> aste=astaRepository.findByProprietarioAsta(utente);
			
			model.addAttribute("utente",utente);
			model.addAttribute("asta",aste);
			return "paginaUtenteInserzionista";
		}
		return "redirect:/login";
	}
	
	@RequestMapping("/visualizza/{idAsta}")
	public String visualizza(@PathVariable("idAsta") long idAsta, Model model) {
		Asta asta=astaRepository.findByidAsta(idAsta);
		List<Offerta> offerte=offertaRepository.findByAsta(asta);
		//da ordinare la lista offerte
		if (asta!=null) {
			model.addAttribute("asta", asta);
			model.addAttribute("offerte",offerte);
			return "visualizzaInserzione";
		} else {
			return null;
		}
	}
	
	@GetMapping("/visualizza/accetta/{id}")
	public String accetta(@PathVariable("id") long id, HttpSession session, Model model) {
		Utente utente=(Utente)session.getAttribute("loggedUser");
		if(utente==null) {
			return "redirect:/login";
		}
		Offerta offerta=offertaRepository.findById(id);
		Asta asta=offerta.getAsta();
		asta.setVincitoreAsta(offerta.getUtente());
		asta.setPrezzoChiusura(offerta.getPrezzo());
		astaRepository.save(asta);
		jdbcLavoro.accettaAsta(asta.getIdAsta());
		model.addAttribute("asta",asta);
		model.addAttribute("utenteEmail", offerta.getUtente().getEmail());
		model.addAttribute("utenteCellulare", offerta.getUtente().getCellulare());
		return "astaAccettata";
	}
	
	@GetMapping("/scriviRecensione/{id}")
	public String scrivi(Recensione recensione, @PathVariable("id") long id, Model model) {
		Lavoro lavoro=(Lavoro) lavoroRepository.findById(id);
		model.addAttribute("lavoro",lavoro);
		return "scriviRecensione";
	}
	
	@PostMapping("/scriviRecensione")
	public String postScrivi(@ModelAttribute Recensione recensione, @RequestParam ("idLavoro") long idLavoro) {
		jdbcRecensione.pubblicaRecensione(recensione.getCommento(),recensione.getVoto());
		Lavoro lavoro=(Lavoro) lavoroRepository.findById(idLavoro);
		
		jdbcRecensione.associaRecensione(recensione.getId(), idLavoro);
		return "scriviRecensione";
	}

}
