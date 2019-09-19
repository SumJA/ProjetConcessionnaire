package net.atos.projetFinal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.projetFinal.model.Client;
import net.atos.projetFinal.repo.ClientRepository;
import net.atos.projetFinal.service.IClientService;

/**
 * Classe ServiceClient implémete IClientService Annotation: @Service
 * 
 * @author kamel
 *
 */
@Service
public class ServiceClient implements IClientService {

	@Autowired
	private ClientRepository dao;

	public ClientRepository getDao() {
		return dao;
	}

	/**
	 * méthode getAllClients Annotations: @Override, @Transactional(readOnly = true)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Client> getAllClients() {

		return dao.findAll();
	}

	/**
	 * méthode creerClient Annotations: @Override, @Transactional
	 */
	@Override
	@Transactional
	public void creerClient(Client client) {

		dao.save(client);

	}

	/**
	 * méthode supprimerClient Annotations: @Override, @Transactional
	 */
	@Override
	@Transactional
	public void supprimerClientById(Long idClient) {

		dao.deleteById(idClient);

	}

	/**
	 * méthode modifierClient Annotations: @Override, @Transactional
	 */
	@Override
	@Transactional
	public void modifierClients(List<Client> clients) {

	}

}
