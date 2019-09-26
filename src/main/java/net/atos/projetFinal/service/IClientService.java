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
package net.atos.projetFinal.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import net.atos.projetFinal.model.Client;

/**
 * Service gérant la clientèle du concessionnaire
 * 
 * @author Nils Vovan
 * @author Sumaira JAVAID
 *
 */
public interface IClientService {
	
	/**
	 * Récupère le client avec l'ID donné
	 * @param id id recherché
	 * @return le client avec l'id suivant
	 */
	Client findClientById(Long id) ;
	
	/**
	 * Get all the client saved in the database
	 * @return all the clients saved in database
	 */
	List<Client> getAllClients();
	
	/**
	 * Retourne le client correspondant à l'identifiant donné en paramètre
	 * 
	 * @param id du client à retrouver
	 * @return un client
	 */
	Optional<Client> trouverClientParId(final Long id);
	
	/**
	 * Retourne la liste des clients dont le nom et le prénom correspondent au nom
	 * et prénom donné en paramètre
	 * 
	 * @param nom    du ou des clients recherchés
	 * @param prenom du ou des clients recherchés
	 * @return une liste de clients
	 */
	List<Client> trouverClientParNom(final String Nom, final String prenom);
	
	/**
	 * Create a new client in the database
	 * @param client : the client that has to be created
	 * @return the client that has just been created
	 */
	Client creerClient(final Client client);
	
//	/**
//	 * Supprime un client
//	 * 
//	 * @param idClient identifiant du client à supprimer
//	 * @throws IllegalArgumentException dans le cas où {@code idClient} donné est
//	 *                                  {@literal null}
//	 */
//	void supprimerClientById(final Long idClient);

	
	
	/**
	 * Met à jour les informations d'un ensemble de clients
	 * 
	 * @param clients la liste des clients à mettre à jour
	 * @throws NoSuchFieldException 
	 * @throws NoSuchFieldError 
	 * @throws IllegalArgumentException si l'identidiant d'un {@code clients} est
	 *                                  {@literal null}
	 * @throws NoSuchElementException   - si un client n'existe pas en base
	 */
	void modifierClients(final List<Client> clients) throws NoSuchFieldError, NoSuchFieldException;
	
	/**
	 * Met à jour les information d'un client
	 * 
	 * @param client à mettre à jour
	 * @throws NoSuchFieldException 
	 * @throws NoSuchFieldError 
	 * @throws IllegalArgumentException si l'identidiant d'un {@code clients} est
	 *                                  {@literal null}
	 * @throws NoSuchElementException   - si un client n'existe pas en base
	 */
	void modifierClient(final Client client) throws NoSuchFieldError, NoSuchFieldException;
	
	
	
	/**
	 * Modify the adresse of the client in the database
	 * @param client : client that contains the new value of the adresse
	 * @return the new client values (with adresse updated)
	 * @throws NoSuchFieldException 
	 * @NB if the adresse attribute of the Client has an other client that the parameter client
	 * the method create a new adresse
	 */
	Client modifierAdresseClient(Client client) throws NoSuchFieldException ;

}

