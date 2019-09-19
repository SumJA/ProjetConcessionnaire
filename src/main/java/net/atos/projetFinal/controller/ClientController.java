package net.atos.projetFinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.atos.projetFinal.model.Client;
import net.atos.projetFinal.service.impl.ServiceClient;


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
	@ResponseBody
	Optional<Client> getClientById(@PathVariable final  int idClient)
	{
		
		return this.serviceClient.getDao().findById(idClient);
		
		
	}
	
	@RequestMapping(value="/Clients/{idClient}", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<Client> deleteClientById(@PathVariable final int clientId)
	{
		
		
		this.serviceClient.supprimerClientById(clientId);
		return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
	}
	
	
	
	@RequestMapping(value="/Clients", method = RequestMethod.POST)
	ResponseEntity<Client> addClient(@RequestBody Client client)
	{
		
		this.serviceClient.creerClient(client);
		return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	@RequestMapping(value="/Clients", method = RequestMethod.PUT)
	ResponseEntity<Client> updateClient(@RequestBody Client client)
	{
		this.serviceClient.getDao().save(client);
		return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
	}
	
	
	
	

	
	

}
