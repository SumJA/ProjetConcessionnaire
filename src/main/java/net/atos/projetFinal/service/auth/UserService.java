package net.atos.projetFinal.service.auth;

import net.atos.projetFinal.exception.InvalidUserRole;
import net.atos.projetFinal.model.Employe;

/**
 * Interface du service qui permet de créer un compte utilisateur
 *
 */
public interface UserService {
	/**
	 * Créer un nouveau utilisateur de type Employe
     *
     * @param user un utilisateur de type Employe
     * @return un objet Employe
     */
    Employe save(Employe user) throws InvalidUserRole;

	/**
	 * Retrouve l'employé à partir de son username
	 *
     * @param username de l'utilisateur
	 * @return un objet Employe
	 */
	Employe findByUsername(String username);
}