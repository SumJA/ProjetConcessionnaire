/**
 * Interface du service qui permet de créer un compte utilisateur
 */
package net.atos.projetFinal.auth.service;

import net.atos.projetFinal.model.Employe;

/**
 * @author Sumaira
 *
 */
public interface UserService {
	/**
	 * Créer un nouveau utilisateur de type Employe
	 * @param user un utilisateur de type Employe
	 */
	void save(Employe user);

	/**
	 * Retrouve l'employé à partir de son username
	 * @param username
	 * @return un objet Employe
	 */
	Employe findByUsername(String username);
}
