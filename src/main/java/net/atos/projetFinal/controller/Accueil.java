/**
 * 
 */
package net.atos.projetFinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Administrateur
 *
 */
@Controller
public class Accueil {
	/*
	 * TODO: Accueil personalisé en fonction du role (admin, commercial, magasinier)
	 */
	@GetMapping("/admin/test")
	public String test(Model model) {
		System.out.println("teststesetezseees");
		return "test";
	}
}
