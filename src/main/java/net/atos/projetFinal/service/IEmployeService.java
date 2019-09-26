package net.atos.projetFinal.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.dao.DataIntegrityViolationException;

import net.atos.projetFinal.model.Employe;

/**
 * Service gérant les employés du concessionnaire
 * 
 * @author Nils Vovan
 * @author Sumaira JAVAID
 * @author Kamel TRABELSI
 * 
 */
public interface IEmployeService {
	
	/**
	 * Retourne la liste de tous les employés sauvegardé
	 * 
	 * @return la liste de tous les employés
	 */
	List<Employe> trouverTousLesEmployes();
	
	/**
	 * Créer un nouvel Employé
	 * 
	 * @param employe l'employé à créer en base, ne doit pas etre un {@literal null}
	 * @throws DataIntegrityViolationException si l'employé est déjà existant dans
	 *                                         la base
	 * @throws NullPointerException            si l'employé donné en paramètre est
	 *                                         null
	 * @return un Employe
	 */
	Employe creerEmploye(@NotNull final Employe employe);
	
	/**
	 * Supprimer un employé identifié par l'identifiant donnée en paramètre
	 * 
	 * @param idEmploye : l'identifiant de l'employé à supprimer, ne doit pas etre
	 *                  un {@literal null}
	 * @throws IllegalArgumentException dans le cas où {@code idEmploye} donné est
	 *                                  {@literal null}
	 * @throws NullPointerException     si l'id de l'employé donné en paramètre est
	 *                                  null
	 */
	void supprimerEmployeParId(@NotNull final Long idEmploye);
	
	/**
	 * Met à jour un ensemble d'employés
	 * 
	 * @param employes : la liste des employé à mettre à jour,, ne doit pas etre un
	 *                 {@literal null} ou vide
	 * @throws IllegalArgumentException dans le cas où {@code employes} est une
	 *                                  liste vide ou {@literal null}
	 * @throws NoSuchElementException   si un employé n'existe pas en base
	 */
	void modifierEmployes(@NotEmpty final List<Employe> employes);
	
	/**
	 * Met à jour un employé
	 * 
	 * @param employe : l'employé à mettre à jour, ne doit pas etre un
	 *                {@literal null}
	 * @throws IllegalArgumentException dans le cas où {@code employe} est un
	 *                                  {@literal null}
	 * @throws NoSuchElementException   si un employé n'existe pas en base
	 */
	void modifierEmploye(@NotNull final Employe employe);
}