/**
 * 
 */
package net.atos.projetFinal.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Administrateur
 *
 */
public class Client {

	/*
	 * TODO: afficher la liste des clients
	 */
	@GetMapping("/listeClients")
	public String listeClients(Model model) {
		return "listeClients";
	}
	
	/*
	 * TODO: Ajouter la liste des clients
	 */
	@GetMapping("/ajouterClients")
	public String afficherAjouterClients(Model model) {
		return "ajouterClients";
	}
	
	/*
	 * TODO: Ajouter la liste des clients
	 */
	@PostMapping("/ajouterClients")
	public String ajouterClients(Model model) {
		return "ajouterClients";
	}
	
	/*
	 * TODO: Selectionner un client
	 */
	@GetMapping("/SelectionClients")
	public String afficherSelectionClients(Model model) {
		return "ajouterClients";
	}
	
	/*
	 * TODO: Selectionner un client
	 */
	@PostMapping("/SelectionClients")
	public String SelectionClients(Model model) {
		return "ajouterClients";
	}
	

}
