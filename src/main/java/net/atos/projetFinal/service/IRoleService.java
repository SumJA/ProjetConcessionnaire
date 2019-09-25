/**
 * MIT License

Copyright (c) [2019] [Sumaira JAVAID, Nils VO-VAN, Kamel TRABELSI, Jerome BRUNA]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package net.atos.projetFinal.service;

import java.util.List;

import net.atos.projetFinal.model.Role;

/**
 * Service gérant les roles des employés du concessionnaire
 * 
 * @author Nils VOVAN
 * @author Sumaira JAVAID
 *
 */
public interface IRoleService {

	/**
	 * Retourne la liste de tous les rôles existant dans la base de donnée
	 * 
	 * @return la liste de tous les rôles existant dans la base de donnée
	 */
	List<Role> trouverTousLesRoles();

	/**
	 * Créer un nouveau role
	 * 
	 * @param role à créer
	 */
	void creerRole(final Role role);

	/**
	 * Supprime un role à partir de l'identifiant donnée en paramètre
	 * 
	 * @param idRole : l'identifiant du role à supprimer
	 */
	void supprimerRoleParId(final Long idRole);

	/**
	 * Met à jour une liste de roles
	 * 
	 * @param roles : la liste des roles à mettre à jour
	 */
	void modifierRoles(final List<Role> roles);

	/**
	 * Met à jour un rôle
	 * 
	 * @param role à mettre à jour
	 */
	void modifierRole(final Role role);
}
