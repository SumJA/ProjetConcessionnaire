/**
 * MIT License

Copyright (c) [2019] [Sumaira JAVAID, Nils VO-VAN, Kamel TRABELSI, Jerome BRUNA]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package net.atos.projetFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.atos.projetFinal.service.IAdresseService;
import net.atos.projetFinal.service.IClientService;

/**
 * 
 * @author Nils VO-VAN
 * @author Sumaira JAVAID
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
