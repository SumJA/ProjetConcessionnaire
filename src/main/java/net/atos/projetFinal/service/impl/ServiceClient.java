/**
 * MIT License

Copyright (c) [2019] [Sumaira JAVAID, Nils VO-VAN, Kamel TRABELSI, Jerome BRUNA]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package net.atos.projetFinal.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.model.Client;
import net.atos.projetFinal.repo.ClientRepository;
import net.atos.projetFinal.service.IClientService;

/**
 * Implémentation de {@link IClientService}
 * 
 * @author kamel
 * @author Nils VO-VAN
 *
 */
@Service
public class ServiceClient implements IClientService {

	@Autowired
	private ClientRepository dao;
	
	@Autowired
	private ServiceAdresse serviceAdresse ;

	/**
	 * Retourne la liste de tous les clients.
	 * 
	 * @return la liste de tous les clients.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Client> getAllClients() {
		return dao.findAll();
	}

	/**
	 * Get all the client saved in the database
	 * @return all the clients saved in database
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<Client> trouverClientParId(final Long id) {
		return dao.findById(id);
	}

	/**
	 * Retourne la liste des clients dont le nom et le prénom correspondent au nom
	 * et prénom donné en paramètre
	 * 
	 * @param nom    du ou des clients recherchés
	 * @param prenom du ou des clients recherchés
	 * @return une liste de clients
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Client> trouverClientParNom(final String nom, final String prenom) {
		return dao.findClientsByName(nom, prenom);
	}

	/**
	 * Create a new client in the database
	 * @param client : the client that has to be created
	 * @return the client that has just been created
	 */
	@Override
	@Transactional
	public Client creerClient(Client client) {

		Client clientJustCreated ;
		
		clientJustCreated = dao.save(client) ;
		return(clientJustCreated);
	}


	/**
	 * Modify in the database the clients in the list 
	 * @param clients the clients with the modified attribute values
	 * @throws NoSuchFieldException 
	 * @throws NoSuchFieldError 
	 */
	@Override
	@Transactional
	public void modifierClients(List<Client> clients) throws NoSuchFieldError, NoSuchFieldException {
		for (Client client : clients) {
			modifierClient(client);
		}
	}

	/**
	 * Modify in the database the client
	 * @param client the client with the modified attribute values
	 * @throws NoSuchFieldException 
	 * @throws NoSuchFieldError 
	 */
	@Override
	@Transactional
	public void modifierClient(Client client) throws NoSuchFieldError, NoSuchFieldException {
		Client clientToUpdate ;
		
		/* Is not null (mandatory) */
		clientToUpdate = dao.findById(client.getIdClient()).get() ;
		
		/* If the adresse has changed then erase or create adresse */
		if(!clientToUpdate.getAdresse().equals(client.getAdresse()))
		{	
			System.err.println("ServiceClient.modifierClient : juste avant modifierAdresseClient");
			client = modifierAdresseClient(client) ;
		}

		clientToUpdate.setAdresse(client.getAdresse());
		clientToUpdate.setAdresseMail(client.getAdresseMail());
		clientToUpdate.setDateCreationClient(client.getDateCreationClient()) ;
		clientToUpdate.setDateDerniereMiseAJourClient(Instant.now());
		clientToUpdate.setNomClient(client.getNomClient());
		clientToUpdate.setNumeroTelClient(client.getNumeroTelClient());
		clientToUpdate.setPrenomClient(client.getPrenomClient());
		
		dao.save(clientToUpdate) ;
	}

	/**
	 * Modify the adresse of the client in the database
	 * @param client : client that contains the new value of the adresse
	 * @return the new client values (adresse updated)
	 * @throws NoSuchFieldException 
	 * @NB if the adresse attribute of the client has an other client that the parameter client
	 * the method create a new adresse
	 */
	@Override
	@Transactional
	public Client modifierAdresseClient(Client client) throws NoSuchFieldException, NoSuchFieldError {
		Client originalClient ;
		Adresse adresse ;

		adresse = client.getAdresse() ;
		
		/* findById must not be null (mandatory) */
		originalClient = dao.findById(client.getIdClient()).get() ;
		
		if(originalClient.getAdresse().getClients().size()>1)
		{
			/* If more than one client depends on same adresse then create a new adresse */
			
			Adresse newAdresse = new Adresse();
			
			newAdresse.setCodePostal(adresse.getCodePostal());
			newAdresse.setComplementAdresse(adresse.getComplementAdresse());
			newAdresse.setLibelleVoie(adresse.getLibelleVoie());
			newAdresse.setNumeroVoie(adresse.getNumeroVoie());
			newAdresse.setVille(adresse.getVille());
			/* Pas d'id car généré automatiquement par le service */
			
			newAdresse = serviceAdresse.creerAdresse(newAdresse) ;
			
			client.setAdresse(newAdresse);
		}
		else
		{
			client.setAdresse(serviceAdresse.modifierAdresse(client.getAdresse())) ;
		}
		
		return client ;
		
	}

	@Override
	public Client findClientById(Long id) {
		
		return dao.findById(id).get();
	}
	

}
