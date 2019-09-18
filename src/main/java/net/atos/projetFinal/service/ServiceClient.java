package net.atos.projetFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.projetFinal.model.Client;
import net.atos.projetFinal.repo.ClientRepository;


@Service
public class ServiceClient implements IClientService {
	
	
	@Autowired
	private ClientRepository dao;
	
	


	public ClientRepository getDao() {
		return dao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Client> getAllClients() {
		
		return dao.findAll();
	}

	@Override
	@Transactional
	public void creerClient(Client client) {
		
		
		
		dao.save(client);

	}

	@Override
	@Transactional
	public void supprimerClientById(int idClient) {
		
		dao.deleteById(idClient);

	}

	@Override
	@Transactional
	public void modifierClients(List<Client> clients) {
		
	}

}
