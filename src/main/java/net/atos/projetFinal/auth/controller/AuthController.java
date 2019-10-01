package net.atos.projetFinal.auth.controller;

import net.atos.projetFinal.auth.service.SecurityService;
import net.atos.projetFinal.auth.service.UserService;
import net.atos.projetFinal.auth.validator.UserValidator;
import net.atos.projetFinal.model.Employe;
import net.atos.projetFinal.repo.RoleRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller pour l'authentification
 *
 */
@Controller
public class AuthController {
    private final UserService userService;
    
    private final SecurityService securityService;
    
    private final UserValidator userValidator;
    
    /*
	 * TODO : changer par service
	 */
    private final RoleRepository rolerepo;
    
    public AuthController(UserService userService, SecurityService securityService, UserValidator userValidator,
                          RoleRepository rolerepo) {
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;
        this.rolerepo = rolerepo;
    }
	
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
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/home";
    }
	
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
        Employe employe = new Employe();
        model.addAttribute("login", employe);
		
		if (error != null)
			model.addAttribute("error", "Nom d'utilisateur ou Mot De Passe Invalide.");
        
        if (logout != null)
			model.addAttribute("message", "Vous avez été déconnecté !");
        
        return "login";
	}
	
	@GetMapping({ "/", "/home" })
	public String welcome(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean userIsAdmin = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("admin"));
		
		if(userIsAdmin) {
			return "adminAcceuil";
		} else {
			return "index";
		}
	}
 
}