/**
 * 
 */
package net.atos.projetFinal.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Administrateur
 *
 */
public class Accueil {
	/*
	 * TODO: Accueil personalisé en fonction du role (admin, commercial, magasinier)
	 */
	@GetMapping("/")
	public String home(Model model) {
		return "Accueil";
	}
}
