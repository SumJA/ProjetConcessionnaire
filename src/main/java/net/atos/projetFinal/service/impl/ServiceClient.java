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
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.projetFinal.model.Client;
import net.atos.projetFinal.repo.ClientRepository;
import net.atos.projetFinal.service.IClientService;

/**
 * Implémentation de {@link IClientService}
 * 
 * @author Kamel TRABELSI
 * @author Sumaira JAVAID
 * 
 */
@Service
public class ServiceClient implements IClientService {

	@Autowired
	private ClientRepository clientReposiroty;

	/**
	 * Retourne la liste de tous les clients.
	 * 
	 * @return la liste de tous les clients.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Client> trouverTousLesClients() {
		return clientReposiroty.findAll();
	}

	/**
	 * Retourne le client correspondant à l'identifiant donné en paramètre
	 * 
	 * @param id du client à retrouver
	 * @return un client
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<Client> trouverClientParId(final Long id) {
		return clientReposiroty.findById(id);
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
		return clientReposiroty.findClientsByName(nom, prenom);
	}

	/**
	 * Créer un nouveau client
	 * 
	 * @param client à créer
	 */
	@Override
	@Transactional
	public void creerClient(final Client client) {
		clientReposiroty.saveAndFlush(client);
	}

	/**
	 * Supprime un client
	 * 
	 * @param idClient identifiant du client à supprimer
	 * @throws IllegalArgumentException dans le cas où {@code idClient} donné est
	 *                                  {@literal null}
	 */
	@Override
	@Transactional
	public void supprimerClientParId(final Long idClient) {
		clientReposiroty.deleteById(idClient);
	}

	/**
	 * Met à jour les informations d'un ensemble de clients
	 * 
	 * @param clients la liste des clients à mettre à jour
	 * @throws IllegalArgumentException si l'identidiant d'un {@code clients} est
	 *                                  {@literal null}
	 * @throws NoSuchElementException   - si un client n'existe pas en base
	 */
	@Override
	@Transactional
	public void modifierClients(final List<Client> clients) {
		for (Client client : clients) {
			Optional<Client> clientToUpdate = clientReposiroty.findById(client.getIdClient());
			clientToUpdate.get().setNomClient(client.getNomClient());
			clientToUpdate.get().setPrenomClient(client.getPrenomClient());
			clientToUpdate.get().setNumeroTelClient(client.getNumeroTelClient());
			clientToUpdate.get().setAdresseMail(client.getAdresseMail());
			clientToUpdate.get().setAdresse(client.getAdresse());
			clientReposiroty.save(clientToUpdate.get());
		}
		clientReposiroty.flush();
	}

	/**
	 * Met à jour les information d'un client
	 * 
	 * @param client à mettre à jour
	 * @throws IllegalArgumentException si l'identidiant d'un {@code clients} est
	 *                                  {@literal null}
	 * @throws NoSuchElementException   - si un client n'existe pas en base
	 */
	@Override
	@Transactional
	public void modifierClient(final Client client) {
		Optional<Client> clientToUpdate = clientReposiroty.findById(client.getIdClient());
		clientToUpdate.get().setNomClient(client.getNomClient());
		clientToUpdate.get().setPrenomClient(client.getPrenomClient());
		clientToUpdate.get().setNumeroTelClient(client.getNumeroTelClient());
		clientToUpdate.get().setAdresseMail(client.getAdresseMail());
		clientToUpdate.get().setDateDerniereMiseAJourClient(Instant.now());
		clientToUpdate.get().setAdresse(client.getAdresse());
		clientReposiroty.saveAndFlush(clientToUpdate.get());
	}
}
