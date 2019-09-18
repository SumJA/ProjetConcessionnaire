package net.atos.projetFinal.client.service;

import java.util.List;

import net.atos.projetFinal.client.bean.Client;

public interface IClientService {
	
	List<Client> getAllClients();
	
	void creerClient(Client client);
	
	void supprimerClientById(final int idClient);
	
	void modifierClients(final List<Client> clients);
	

}

