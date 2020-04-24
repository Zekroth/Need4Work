package it.itsrizzoli.N4W.controllers;

import java.sql.Date;
import java.util.List;

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
import it.itsrizzoli.N4W.dao.ProfessioneDao;
import it.itsrizzoli.N4W.dao.RecensioneDao;
import it.itsrizzoli.N4W.dao.RecensioniJdbcDao;
import it.itsrizzoli.N4W.dao.UserJdbcDao;
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
	private ProfessioneDao professioneRepository;
	@Autowired
	private LavoroJdbcDao jdbcLavoro;
	@Autowired
	private RecensioniJdbcDao jdbcRecensioni;
	@Autowired
	private UserJdbcDao jdbcUser;
	
	@GetMapping("/creazioneInserzione")
	public String creazioneInserzione(Asta asta, HttpSession session, Model model) {
		Utente u=(Utente) session.getAttribute("loggedUser");
		model.addAttribute("professionsList", professioneRepository.findAll());
		if (u==null)
			return "redirect:/login";
		return "creazioneInserzione";
	}
	
	@PostMapping("/creazioneInserzione")
	public String postCreazioneInserzione(@Valid Asta asta, @RequestParam ("professione") long professione, BindingResult res, Model model, HttpSession session) {
		if (res.hasErrors()) {
			model.addAttribute("msg", res.getFieldError().getDefaultMessage());
			return "creazioneInserzione";
		}
		java.util.Date d=new java.util.Date();
		Date date=new Date(d.getTime());
		asta.setDataInizio(date);
		if (asta.getDataInizio().compareTo(asta.getDataFine())>=0)
			return "creazioneInserzione";
		asta.setProprietarioAsta((Utente) session.getAttribute("loggedUser"));
		asta.setProfessioneRichiesta(professioneRepository.findById(professione));
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
	public String visualizza(@PathVariable("idAsta") long idAsta, Model model, HttpSession session) {
		Utente utente=(Utente)session.getAttribute("loggedUser");
		if(utente==null) {
			return "redirect:/login";
		}
		Asta asta=astaRepository.findByidAsta(idAsta);
		java.util.Date d=new java.util.Date();
		Date oggi=new Date(d.getTime());
		if(asta.getVincitoreAsta()!=null) {
			return "redirect:/visualizzaLavoro/"+idAsta;
		}
		if(asta.getDataFine().compareTo(oggi)<0) {
			return "redirect:/astaScaduta";
		}
		List<Offerta> offerte=offertaRepository.findByAsta(asta);
		//da ordinare la lista offerte
		if (asta!=null) {
			model.addAttribute("asta", asta);
			model.addAttribute("offerte",offerte);
			return "visualizzaInserzione";
		}
		return null;
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
		List<Lavoro> lavoro=lavoroRepository.findByAsta(asta);
		model.addAttribute("asta",asta);
		model.addAttribute("utenteEmail", offerta.getUtente().getEmail());
		model.addAttribute("utenteCellulare", offerta.getUtente().getCellulare());
		model.addAttribute("idLavoro", lavoro.get(0).getId());
		return "astaAccettata";
	}
	
	@GetMapping("/scriviRecensione/{id}")
	public String scrivi(Recensione recensione, @PathVariable("id") long id, Model model, HttpSession session) {
		Utente utente=(Utente) session.getAttribute("loggedUser");
		if (utente!=null) {
			Lavoro lavoro=(Lavoro) lavoroRepository.findById(id);
			if (lavoro.getRecensione()!=null) {
				return "redirect:/paginaUtenteInserzionista";
			}
			model.addAttribute("lavoro",lavoro);
			return "scriviRecensione";
		} else {
			return "redirect:/login";
		}
	}
	
	@PostMapping("/scriviRecensione")
	public String postScrivi(@Valid Recensione recensione, @RequestParam ("idLavoro") long idLavoro) {
		recensioneRepository.save(recensione);
		Lavoro lavoro=(Lavoro) lavoroRepository.findById(idLavoro);
		lavoro.setRecensione(recensione);
		lavoroRepository.save(lavoro);
		return "redirect:/paginaUtenteInserzionista";
	}
	
	@GetMapping("/visualizza/visualizzaUtente/{email}")
	public String visualizzaUtente(@PathVariable ("email") String email, Model model, HttpSession session) {
		Utente u=(Utente) session.getAttribute("loggedUser");
		if (u==null)
			return "redirect:/login";
		email=email+"%";
		List<Utente> utente=jdbcUser.findUser(email);
		List<Recensione> lavori=jdbcRecensioni.getAllRecensioni(utente.get(0).getEmail());
		model.addAttribute("utente",utente.get(0));
		model.addAttribute("lavori",lavori);
		return "accountProfiloProfessionista";
	}
	
	@GetMapping("/astaScaduta")
	public String astaScaduta(HttpSession session) {
		Utente u=(Utente) session.getAttribute("loggedUser");
		if (u==null)
			return "redirect:/login";
		return "astaScaduta";
	}
	
	@GetMapping("/visualizzaLavoro/{idAsta}")
	public String visualizzaUtente(@PathVariable ("idAsta") long idAsta, Model model, HttpSession session) {
		Utente u=(Utente) session.getAttribute("loggedUser");
		if (u==null)
			return "redirect:/login";
		Asta asta=astaRepository.findByidAsta(idAsta);
		List<Lavoro> lavoro=lavoroRepository.findByAsta(asta);
		model.addAttribute("asta",asta);
		model.addAttribute("utenteEmail", asta.getVincitoreAsta().getEmail());
		model.addAttribute("utenteCellulare",  asta.getVincitoreAsta().getCellulare());
		model.addAttribute("idLavoro", lavoro.get(0).getId());
		return "astaAccettata";
	}

}
