package net.atos.projetFinal.auth.service;

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
	 */
	void save(Employe user);

	/**
	 * Retrouve l'employé à partir de son username
	 *
     * @param username de l'utilisateur
	 * @return un objet Employe
	 */
	Employe findByUsername(String username);
}