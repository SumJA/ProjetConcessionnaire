package net.atos.projetFinal.service;

import java.util.List;

import net.atos.projetFinal.model.Client;

public interface IClientService {
	
	List<Client> getAllClients();
	
	void creerClient(Client client);
	
	void supprimerClientById(final int idClient);
	
	void modifierClients(final List<Client> clients);
	

}

