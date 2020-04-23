package it.itsrizzoli.N4W.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.itsrizzoli.N4W.dao.AstaDao;
import it.itsrizzoli.N4W.dao.OffertJdbcDao;
import it.itsrizzoli.N4W.dao.OffertaDao;
import it.itsrizzoli.N4W.dao.ProfessioneDao;
import it.itsrizzoli.N4W.dao.ProfessionistaDao;
import it.itsrizzoli.N4W.models.db.Asta;
import it.itsrizzoli.N4W.models.db.Offerta;
import it.itsrizzoli.N4W.models.db.Professione;
import it.itsrizzoli.N4W.models.db.Professionista;
import it.itsrizzoli.N4W.models.db.Utente;
import it.itsrizzoli.N4W.models.db.id.ProfessionistaId;

@Controller
@RequestMapping("/pro")
public class ProfessionistaController {
	
	@Autowired
	private ProfessioneDao professionRepo;
	@Autowired
	private ProfessionistaDao professionistRepo;
	@Autowired
	private AstaDao astaRepository;
	@Autowired
	private OffertJdbcDao jdbcOfferta;
	@Autowired
	private OffertaDao offertaRepository;
	
	@GetMapping("/add")
	public String addProfessionist(HttpSession session, Model model) {
		
		Iterable<Professione> professionIter = professionRepo.findAll();
		List<Professione> professionList = new ArrayList<Professione>();
		professionIter.forEach(professionList :: add);
		Utente u = (Utente) session.getAttribute("loggedUser");
		if(u == null) {
			return "redirect:/hp";
		}else {
			professionList.removeIf(x -> !professionistRepo.findById(new ProfessionistaId(u, x)).isEmpty());
		}
		model.addAttribute("professionList", professionList);
		return "selezioneProfessione";
	}
	@GetMapping("/edit")
	public String editProfessionistProfessions(HttpSession session, Model model, @RequestParam("email") String email) {
		
		if(email == null) {
			return "";
		}
		
		Iterable<Professione> professionIter = professionRepo.findAll();
		List<Professione> professionList = new ArrayList<Professione>();
		professionIter.forEach(x-> professionList.add(x));
		List<Professione> userProfessions = new ArrayList<Professione>();

		for (Professione professione : professionList) {
			userProfessions.add(professione);
		}
		System.out.println(professionList.size());
		model.addAttribute("professionList", professionList);
		Utente u = (Utente) session.getAttribute("loggedUser");
		
		if(u == null) {
			return "redirect:/hp";
		}else {
			userProfessions.removeIf(x ->{
				
				boolean result = professionistRepo.findById(new ProfessionistaId(u, x)).isEmpty();
				System.out.println(x.getTipologia() + " " + result);
				return result;
			});
		}
		model.addAttribute("userProfessions", userProfessions);

		return "fragments/_FormEditProfessioniUtente";
	}
	
	
	@PostMapping("/edit")
	public String editProfessionistProfessions(HttpSession session, Model model, @RequestParam("selected") List<String> selected) {
		
		if(session.getAttribute("loggedUser")== null) {
			return "redirect:/error";
		}
		Utente u = (Utente) session.getAttribute("loggedUser");
		Iterable<Professione> professionIter = professionRepo.findAll();
		List<Professione> professionList = new ArrayList<Professione>();
		professionIter.forEach(professionList :: add);
		
		
		selected.forEach(x-> {
			Long l = Long.parseLong(x);
			
			professionistRepo.save(new Professionista(u, professionRepo.findById(l).get()));
			professionList.removeIf(y -> y.getId() == l);
			
		});
		
		professionList.forEach(x->{
			professionistRepo.delete(new Professionista(u, x));
			});
		
		return "redirect:/hp";
	}
	
	@PostMapping(value = "/add")
	public String addProfessionist(Model model, HttpSession session, @RequestParam("selected") List<String> selected) {
		
		if(session.getAttribute("loggedUser")== null) {
			return "redirect:/error";
		}
		
		selected.forEach(x -> 
			professionistRepo.save(
				new Professionista((Utente)session.getAttribute("loggedUser"),
						professionRepo.findById(Long.valueOf(x)).get())));
		
		return "redirect:/hp";
	}
	
	@GetMapping(value = "/profile")
	public String viewProfile(Model model, HttpSession session) {
		Utente utente=(Utente)session.getAttribute("loggedUser");
		//List<Asta> aste=astaRepository.findByProprietarioAsta(utente);
		List<Offerta> offerte=offertaRepository.findByUtente(utente);
		model.addAttribute("utente",utente);
		model.addAttribute("offerte",offerte);
		return "profiloProfessionista";
	}
	
	@GetMapping("/inserzioneCercata/{idAsta}")
	public String inserzioneCercata(@PathVariable ("idAsta") long idAsta, Model model, HttpSession session) {
		Utente utente=(Utente)session.getAttribute("loggedUser");
		if(utente==null)
			return "redirect:/login";
		Asta asta=astaRepository.findByidAsta(idAsta);
		List<Offerta> offerte=offertaRepository.findByAsta(asta);
		//da ordinare la lista offerte
		if(asta!=null) {
			if (asta.getProprietarioAsta().getEmail().equals(utente.getEmail())) {
				return "redirect:/visualizza/"+asta.getIdAsta();
			} else {
				if (asta.getVincitoreAsta()==null) {
					model.addAttribute("offerte",offerte);
					model.addAttribute("asta", asta);
					return "inserzioneCercata";
				} else {
					return "redirect:/pro/inserzioneFinita/"+asta.getIdAsta();
				}
			}
		} else {
			return null;
		}
	}
	
	@PostMapping("/faiOfferta/{idAsta}")
	public String postFaiOfferta(@RequestParam("prezzo") double prezzo, @PathVariable ("idAsta") long idAsta, Model model, HttpSession session) {
		Utente utente=(Utente)session.getAttribute("loggedUser");
		Asta asta=astaRepository.findByidAsta(idAsta);
		if (prezzo>asta.getPrezzoPartenza()) {
			return "redirect:/pro/inserzioneCercata/"+idAsta;
		}
		jdbcOfferta.pubblicaOfferta(utente.getEmail(), idAsta, prezzo);
		model.addAttribute("msg", "Offerta andata a buon fine");
		return "redirect:/pro/profile";
		
	}
	
	@GetMapping("/inserzioneFinita/{idAsta}")
	public String inserzioneFinita(@PathVariable ("idAsta") long idAsta, Model model, HttpSession session) {
		Utente utente=(Utente)session.getAttribute("loggedUser");
		if(utente==null) {
			return "redirect:/login";
		}
		String vittoria="";
		Asta asta=astaRepository.findByidAsta(idAsta);
		if (asta.getVincitoreAsta().getEmail().equals(utente.getEmail())) {
			vittoria="Complimenti hai vinto l'asta. A breve il proprietario ti contatterà";
		} else {
			vittoria="Che peccato! Non sei riuscito a vincere l'asta";
		}
		model.addAttribute("asta", asta);
		model.addAttribute("vittoria", vittoria);
		return "inserzioneAstaFinita";
	}
	
	
}
