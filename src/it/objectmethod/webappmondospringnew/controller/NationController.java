package it.objectmethod.webappmondospringnew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.webappmondospringnew.dao.impl.DaoNazioneImpl;
import it.objectmethod.webappmondospringnew.dao.IDaoNazione;
import it.objectmethod.webappmondospringnew.model.Citta;
import it.objectmethod.webappmondospringnew.model.Nazione;

@Controller
public class NationController {

	@Autowired
	private IDaoNazione daoNazione;

	
	@GetMapping("/runContinenti")
	public String allcontinents(ModelMap model) {
		List<String> allcontinents = daoNazione.getAllContinents();
		model.addAttribute("allcontinents", allcontinents);
		return "continenti";
	}
	
	@GetMapping("/runNazioni")
	public String login(@RequestParam("continente") String continente, ModelMap model) {
		List<Nazione> nationsbycontinent= daoNazione.getNationsByContinent(continente);
		model.addAttribute("nationsbycontinent", nationsbycontinent);
		return "listanazioni";
	}
	
	
}
