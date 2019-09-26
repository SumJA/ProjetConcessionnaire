package net.atos.projetFinal.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.constraints.NotNull;

import org.springframework.dao.DataIntegrityViolationException;

import net.atos.projetFinal.model.Employe;
import net.atos.projetFinal.model.Stock;

/**
 * Service gérant les employés du concessionnaire
 * 
 * @author Nils Vovan
 * @author Sumaira JAVAID
 * @author Kamel TRABELSI
 * @author Jerome
 * 
 */
public interface IStockService {
	
	/**
	 * Retourne la liste de tous les lignes de stock sauvegardées
	 * 
	 * @return la liste de tous les lignes de stock
	 */
	List<Stock> trouverTousLesStocks();
	
	/**
	 * Créer un nouveau produit
	 * 
	 * @param la ligne de stock à créer en base, ne doit pas etre un {@literal null}
	 * @throws DataIntegrityViolationException si la ligne est déjà existant dans
	 *                                         la base
	 * @throws NullPointerException            si la ligne donnée en paramètre est
	 *                                         null
	 * @return un produit
	 */
	Stock creerProduit(@NotNull final Stock stock);		
	
	/**
	 * Supprimer une ligne identifiée par l'identifiant donnée en paramètre
	 * 
	 * @param idStock : l'identifiant de la ligne à supprimer, ne doit pas etre
	 *                  un {@literal null}
	 * @throws IllegalArgumentException dans le cas où {@code idStock} donné est
	 *                                  {@literal null}
	 * @throws NullPointerException     si l'id de la ligne donnée en paramètre est
	 *                                  null
	 */
	void supprimerLigneParId(@NotNull final Long idStock);
	
	/**
	 * Met à jour une ligne de stock
	 * 
	 * @param stock : la ligne à mettre à jour, ne doit pas etre un
	 *                {@literal null}
	 * @throws IllegalArgumentException dans le cas où {@code stock} est un
	 *                                  {@literal null}
	 * @throws NoSuchElementException   si une ligne n'existe pas en base
	 */
	void modifierStock(@NotNull final Stock stock);
}