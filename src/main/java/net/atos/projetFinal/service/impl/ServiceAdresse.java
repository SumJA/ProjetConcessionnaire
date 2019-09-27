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

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.model.Client;
import net.atos.projetFinal.repo.AdresseRepository;
import net.atos.projetFinal.repo.ClientRepository;
import net.atos.projetFinal.service.IAdresseService;

/**
 * Implementation de {@link IAdresseService}
 * 
 * @author Kamel TRABELSI
 * @author Sumaira JAVAID
 *
 */
@Service
public class ServiceAdresse implements IAdresseService {

	@Autowired
	private AdresseRepository adresseRepository;

	@Autowired
	private ClientRepository clientRepository;

	/**
	 * Créer l'adresse d'un client
	 * 
	 * @param adresse à créer en base, ne doit pas etre un {@literal null}
	 * @return adresse sauvegardée dans (ou récupérée depuis) la base
	 */
	@Override
	@Transactional
	public Adresse creerAdresse(@NotNull final Adresse adresse) {
		if (adresse != null) {
			List<Adresse> adresseVerificationDoublon = adresseRepository.findAdresseByFields(adresse.getNumeroVoie(),
					adresse.getLibelleVoie(), adresse.getComplementAdresse(), adresse.getCodePostal(),
					adresse.getVille());
			if (adresseVerificationDoublon.isEmpty()) {
				return adresseRepository.saveAndFlush(adresse);
			} else {
				throw new DataIntegrityViolationException("Adresse déjà existante");
			}
		} else {
			throw new NullPointerException("L'Adresse fournie en paramètre est null");
		}
	}

	
	/**
	 * Supprime une adresse
	 * 
	 * @param idAdresse identifiant de l'adresse à supppimer
	 * @throws IllegalArgumentException dans le cas où {@code idAdresse} donné est
	 *                                  {@literal null}
	 * @throws NullPointerException     si l'id de l'adresse donné en paramètre est
	 *                                  null
	 */
	@Override
	@Transactional
	public void supprimerAdresseById(@NotNull final Long idAdresse) {
		if (idAdresse != null) {
			adresseRepository.deleteById(idAdresse);
		} else {
			throw new NullPointerException("L'identifiant de l'adresse fournie en paramètre est null");
		}
	}

	/**
	 * Met à jour une adresse. 
	 * Si idAdresse ne pointe sur rien donc creation adresse.
	 * Sinon si idAdresse pointe sur une adresse ayant les mêmes attributs alors rien faire.
	 * Sinon si aucune adresse existe avec des attributs identique à celle passé en param alors modif.
	 * Sinon si une adresse avec des attributs indentiques à celle passé en paramètre alors pointé sur celle-ci
	 * 		ET supprimer l'adresse avec idAdresse paramètré si elle ne contenait qu'un seul client.
	 * 
	 * @param adresse à mettre à jour, ne doit pas etre un {@literal null}
	 * @return 
	 * @throws NoSuchFieldException 
	 * @throws IllegalArgumentException si l'identidiant d'une {@code adresse} est
	 *                                  {@literal null}
	 */
	@Override
	@Transactional
	public Adresse modifierAdresse(final Adresse adresse) throws IllegalArgumentException {

		Adresse newAdresse = new Adresse() ;
		Optional<Adresse> adresseToUpdate = adresseRepository.findById(adresse.getIdAdresse());
		
		if(!adresseToUpdate.isPresent()) {
			/* if the idAdresse does not exist then create new adresse */
			//newAdresse.setClients(adresse.getClients());
			newAdresse.setCodePostal(adresse.getCodePostal());
			newAdresse.setComplementAdresse(adresse.getComplementAdresse());
			newAdresse.setLibelleVoie(adresse.getLibelleVoie());
			newAdresse.setNumeroVoie(adresse.getNumeroVoie());
			newAdresse.setVille(adresse.getVille());
			
			return(creerAdresse(newAdresse)) ;
		}
		
		if(adresseToUpdate.get().equals(adresse))
		{
			/* if adresse equals to adresseToUpdate then do not update because same adresse already exist 
			 * (with same id because findById above) */
			return adresseToUpdate.get() ;
		}
		
		List<Adresse> adresseVerificationDoublon = adresseRepository.findAdresseByFields(adresse.getNumeroVoie(),
				adresse.getLibelleVoie(), adresse.getComplementAdresse(), adresse.getCodePostal(), adresse.getVille());
		
		
		if (adresseVerificationDoublon.isEmpty()) {
			/* If a adresse with same attributes does not exist then modify the adresse */

			if(adresseToUpdate.get().getClients().size() > 1)
			{
				/* If the adresse to update has more than one client then create new one */
				newAdresse.setCodePostal(adresse.getCodePostal());
				newAdresse.setComplementAdresse(adresse.getComplementAdresse());
				newAdresse.setLibelleVoie(adresse.getLibelleVoie());
				newAdresse.setNumeroVoie(adresse.getNumeroVoie());
				newAdresse.setVille(adresse.getVille());
				
				return(creerAdresse(newAdresse)) ;
			}
			else
			{
				/* If the adresse to update has less than (or only one) one clients then modify new one */
				adresseToUpdate.get().setCodePostal(adresse.getCodePostal());
				adresseToUpdate.get().setComplementAdresse(adresse.getComplementAdresse());
				adresseToUpdate.get().setLibelleVoie(adresse.getLibelleVoie());
				adresseToUpdate.get().setNumeroVoie(adresse.getNumeroVoie());
				adresseToUpdate.get().setVille(adresse.getVille());
				
				return(adresseRepository.save(adresseToUpdate.get()));
			}
		} else {
			/* If not empty  then the adresse fields already exist */
			Adresse adresseToReturn = adresseVerificationDoublon.get(0) ;
			
			if(adresseToUpdate.get().getClients().size() <= 1) {
				
				if(adresseToUpdate.get().getClients().size() == 1)
				{
					/* if the adresse to update gets only one client then modify the client
					 * to point to the right adresse */
					Client clientToModify ;
					
					clientToModify = adresseToUpdate.get().getClients().get(0) ;

					clientToModify.setAdresse(adresseToReturn) ;
					clientToModify=clientRepository.save(clientToModify) ;
				}
				
				/* if the adresse has only one client then remove from the database */
				adresseToUpdate.get().getClients().clear();
				supprimerAdresseById(adresseToUpdate.get().getIdAdresse()) ;
			}
			/* If the adresse exists then return the existed adresse */
			return adresseToReturn ;
		}
	}


	@Override
	public List<Adresse> recupererAdresseByFields(int numero, String libelle, String complement, String codePostal,
			String ville) {
		return adresseRepository.findAdresseByFields(numero, libelle, complement, codePostal, ville) ;
	}
}
