package net.atos.projetFinal.service;

import net.atos.projetFinal.model.Role;

import java.util.List;

/**
 * Service gérant les roles des employés du concessionnaire
 */
public interface IRoleService {
    /**
     * Récupérer tous les rôles existant dans la base de donnée
     *
     * @return tous les roles stockés
     */
    List<Role> getAllRoles();
    
    /**
     * Créer un nouveau role
     *
     * @param role : le role à créer
     */
    void creerRole(final Role role);
    
    /**
     * Supprimer un role en l'identifiant par son id
     *
     * @param idRole : id du role à supprimer
     */
    void supprimerRoleById(final Long idRole);
    
    /**
     * Modifier une liste de role
     *
     * @param roles : roles contenant les modifications
     */
    //void modifierRoles(final List<Role> roles) ;
    
    void modifierRole(Role role);
}
