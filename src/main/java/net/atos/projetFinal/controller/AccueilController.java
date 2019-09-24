package net.atos.projetFinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {
	
	
	@GetMapping({"/", "/hello"})
	public String indexPage() {
        return "coucou";
    }
}
