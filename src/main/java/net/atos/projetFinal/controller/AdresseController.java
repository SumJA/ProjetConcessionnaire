package net.atos.projetFinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.service.impl.ServiceAdresse;




@RestController
public class AdresseController {

	
	
	private ServiceAdresse serviceAdresse;
	
	
	@RequestMapping(value = "/Adresses", method = RequestMethod.GET)
	@ResponseBody
	List<Adresse> getAllAdresses()
	{
		
		return this.serviceAdresse.getAllAdresses();
		
	}
	
	
	@RequestMapping(value = "/Adresses/{idAdresse}")
	@ResponseBody
	Optional<Adresse> getAdresseById(@PathVariable final Long idAdresse)
	{
		
		
		return this.serviceAdresse.getDao().findById(idAdresse);
	}
}
