package net.atos.projetFinal.service;


import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.dao.DataIntegrityViolationException;

import net.atos.projetFinal.model.Adresse;

/**
 * Service gérant l'adresse des clients du concessionnaire
 * 
 * 
 * @author Nils 
 * @author Sumaira JAVAID
 *
 */
public interface IAdresseService {

	/**
	 * Créer l'adresse d'un client
	 */
	List<Adresse> recupererAdresseByFields(int numero, String libelle, String complement, String codePostal, String ville) ;
	
	/**
	 * Créer l'adresse dans la database
	 * 
	 * @param adresse à créer en base, ne doit pas etre un {@literal null}
	 * @throws DataIntegrityViolationException si l'adresse est déjà existante dans
	 *                                         la base
	 * @throws NullPointerException            si l'adresse donnée en paramètre est
	 *                                         null
	 * @return une Adresse
	 */
	Adresse creerAdresse(@NotNull final Adresse adresse);

	/**
	 * Supprime une adresse
	 * 
	 * @param idAdresse identifiant de l'adresse à supppimer
	 * @throws IllegalArgumentException dans le cas où {@code idAdresse} donné est
	 *                                  {@literal null}
	 * @throws NullPointerException     si l'id de l'adresse donné en paramètre est
	 *                                  null
	 */
	void supprimerAdresseById(@NotNull final Long idAdresse);

	/**
	 * Met à jour une adresse. Si l'adresse existe déjà alors retourne l'adresse
	 * déjà sauvegardée
	 * 
	 * @param adresse à mettre à jour, ne doit pas etre un {@literal null}
	 * @return adresse that has been saved in (or retrieved from) the data base
	 * @throws NoSuchFieldException     si l'adresse avec id donné n'existe pas en
	 *                                  base
	 * @throws IllegalArgumentException si l'identidiant d'une {@code adresse} est
	 *                                  {@literal null}
	 */
	Adresse modifierAdresse(@NotNull final Adresse adresse) throws NoSuchFieldException;

}