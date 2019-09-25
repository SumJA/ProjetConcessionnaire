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
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.repo.AdresseRepository;
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

	/**
	 * Créer l'adresse d'un client
	 * 
	 * @param adresse à créer en base, ne doit pas etre un {@literal null}
	 * @throws DataIntegrityViolationException si l'adresse est déjà existante dans
	 *                                         la base
	 * @throws NullPointerException            si l'adresse donnée en paramètre est
	 *                                         null
	 * @return une Adresse
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
	 * FIXME : voir Implémentation !!
	 * Met à jour une adresse
	 * 
	 * @param adresse à mettre à jour, ne doit pas etre un {@literal null}
	 * @return 
	 * @throws NoSuchFieldException 
	 * @throws IllegalArgumentException si l'identidiant d'une {@code adresse} est
	 *                                  {@literal null} ou si L'adresse donné est en
	 *                                  paramètre est {@literal null}
	 * @throws NoSuchElementException   - si l'adresse n'existe pas en base
	 */
	@Override
	@Transactional
	public Adresse modifierAdresse(@NotNull final Adresse adresse) throws NoSuchFieldException {
		Optional<Adresse> adresseToUpdate = adresseRepository.findById(adresse.getIdAdresse());
		
		if(!adresseToUpdate.isPresent()) {
			throw new NoSuchFieldException("Id pour l'adresse inexistant") ;
		}
		
		List<Adresse> adresseVerificationDoublon = adresseRepository.findAdresseByFields(adresse.getNumeroVoie(),
				adresse.getLibelleVoie(), adresse.getComplementAdresse(), adresse.getCodePostal(), adresse.getVille());
		
		
		if (adresseVerificationDoublon.isEmpty()) {
			/* If the adresse does not exist then modify */
			adresseToUpdate.get().setClients(adresse.getClients());
			adresseToUpdate.get().setCodePostal(adresse.getCodePostal());
			adresseToUpdate.get().setComplementAdresse(adresse.getComplementAdresse());
			adresseToUpdate.get().setLibelleVoie(adresse.getLibelleVoie());
			adresseToUpdate.get().setNumeroVoie(adresse.getNumeroVoie());
			adresseToUpdate.get().setVille(adresse.getVille());
			
			return(adresseRepository.saveAndFlush(adresseToUpdate.get()));
		} else {
			
			if(adresseToUpdate.get().getClients().size() <= 1) {
				/* if the adresse has only one client then remove from the database */
				adresseToUpdate.get().getClients().clear();
				supprimerAdresseById(adresseToUpdate.get().getIdAdresse()) ;
			}
			/* If the adresse exists then return the existed adresse */
			return adresseVerificationDoublon.get(0) ;
		}
	}
}
