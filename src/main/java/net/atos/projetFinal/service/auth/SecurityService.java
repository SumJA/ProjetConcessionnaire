package net.atos.projetFinal.service.auth;

/**
 * Pour retrouver l'utilisateur connecté + 
 * gérer la connexion auto après création du compte
 *
 */
public interface SecurityService {
	/**
	 * Retrouver le username de l'utilisateur connecté
	 * @return le username de l'utilisateur
	 */
	String findLoggedInUsername();

	/**
	 * Auto login après inscription
	 * @param username de l'utilisateur
	 * @param password de l'utilisateur
	 */
	void autoLogin(String username, String password);
}