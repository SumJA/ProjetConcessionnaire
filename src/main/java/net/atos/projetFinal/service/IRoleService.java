package net.atos.projetFinal.service;

import java.util.List;

import net.atos.projetFinal.model.Role;

/**
 * Interface du service de role
 * @author NVV
 *
 */
public interface IRoleService {

	/**
	 * Récupérer tous les rôles existant dans la base de donnée
	 * @return tous les roles stockés
	 */
	List<Role> getAllRoles();
	
	/**
	 * Créer un nouveau role
	 * @param role : le role à créer
	 */
	void creerRole(Role role) ;
	
	/**
	 * Supprimer un role en l'identifiant par son id
	 * @param idRole : id du role à supprimer
	 */
	void supprimerRoleById(int idRole) ;
	
	/**
	 * Modifier une liste de role
	 * @param roles : roles contenant les modifications
	 */
	void modifierRoles(List<Role> roles) ;
}
