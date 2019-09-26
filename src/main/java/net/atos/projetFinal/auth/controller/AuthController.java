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
package net.atos.projetFinal.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.atos.projetFinal.auth.service.SecurityService;
import net.atos.projetFinal.auth.service.UserService;
import net.atos.projetFinal.auth.validator.UserValidator;
import net.atos.projetFinal.model.Employe;
import net.atos.projetFinal.repo.RoleRepository;

/**
 * Controller pour l'authentification
 * 
 * @author Sumaira JAVAID
 * @author Jerome BRUNA
 *
 */
@Controller
public class AuthController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;
	
	/* 
	 * TODO : changer par service
	 */
	@Autowired
	private RoleRepository rolerepo;

	@GetMapping("/inscription")
	public String registration(Model model) {
		Employe employe = new Employe();
		model.addAttribute("inscription", employe);
		model.addAttribute("role", rolerepo.findAll());

		return "inscription";
	}

	@PostMapping("/inscription")
	public String registration(@ModelAttribute("inscription") Employe userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "inscription";
		}
		
		userService.save(userForm);

		securityService.autoLogin(userForm.getNom(), userForm.getPasswordConfirm());

		return "redirect:/";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Nom d'utilisateur ou Mot De Passe Invalide.");

		if (logout != null)
			model.addAttribute("message", "Vous avez été déconnecté !");

		return "login";
	}
	
	@GetMapping({ "/", "/home" })
	public String welcome(Model model) {
		return "index";
	}

}