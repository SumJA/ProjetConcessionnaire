/**
 * Controller pour l'authentification
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
 * @author Sumaira
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

		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your nom and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

}
