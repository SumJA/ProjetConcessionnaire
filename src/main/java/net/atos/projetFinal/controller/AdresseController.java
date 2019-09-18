package net.atos.projetFinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.service.ServiceAdresse;




@RestController
public class AdresseController {

	
	
	private ServiceAdresse serviceAdresse;
	
	
	@RequestMapping(value = "/Adresses", method = RequestMethod.GET)
	List<Adresse> getAllAdresses()
	{
		
		return this.serviceAdresse.getAllAdresses();
		
	}
	
	
	@RequestMapping(value = "/Adresses/{idAdresse}")
	Optional<Adresse> getAdresseById(@PathVariable final int idAdresse)
	{
		
		
		return this.serviceAdresse.getDao().findById(idAdresse);
	}
}
