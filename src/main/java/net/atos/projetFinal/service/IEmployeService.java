package net.atos.projetFinal.service;

import java.util.List;

import net.atos.projetFinal.model.Employe;

/**
 * Interface du service de Employe
 * @author NVV
 *
 */
public interface IEmployeService {

	/**
	 * Récuperer tous les employé sauvegarder
	 * @return liste des employés stockés
	 */
	List<Employe> findAllEmploye() ;
	
	/**
	 * Créer un nouvel employé
	 * @param employe : employé à créer
	 */
	void creerEmploye(Employe employe) ;
	
	/**
	 * Supprimer un employé identifié par l'id
	 * @param idEmploye : id de l'employé à supprimer
	 */
	void supprimerEmployeParId(int idEmploye) ;
	
	/**
	 * Modifier des employés dans la sauvegarde
	 * @param employes : Liste des employé à modifier
	 */
	void modifierEmployes(List<Employe> employes) ;
}
