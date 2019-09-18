package net.atos.projetFinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.atos.projetFinal.model.Client;
import net.atos.projetFinal.service.ServiceClient;


@RestController
public class ClientController {
	
	
	@Autowired
	private ServiceClient serviceClient;
	
	
	
	@RequestMapping(value="/Clients", method=RequestMethod.GET)
	@ResponseBody
	List<Client> getAllClient(){
		
		
		
		
		return this.serviceClient.getAllClients();
	}
	
	
	@RequestMapping(value="/Clients/{idClient}", method=RequestMethod.GET)
	Optional<Client> getClientById(@PathVariable final  int idClient)
	{
		
		return this.serviceClient.getDao().findById(idClient);
		
		
	}
	
	

	
	

}
