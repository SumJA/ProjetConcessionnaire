/**
 * MIT License
<<<<<<< HEAD

Copyright (c) [2019] [Sumaira JAVAID, Nils VO-VAN, Kamel TRABELSI, Jerome BRUNA]

=======
​
Copyright (c) [2019] [Sumaira JAVAID, Nils VO-VAN, Kamel TRABELSI, Jerome BRUNA]
​
>>>>>>> MAJ service adresse pour répondre au différent cas lors de ala modif + add comments
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
<<<<<<< HEAD

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

=======
​
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
​
>>>>>>> MAJ service adresse pour répondre au différent cas lors de ala modif + add comments
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package net.atos.projetFinal.service;

import javax.validation.constraints.NotNull;

import org.springframework.dao.DataIntegrityViolationException;

import net.atos.projetFinal.model.Adresse;

/**
 * Service gérant l'adresse des clients du concessionnaire
 * 
 * 
 * @author Nils 
 * @author Sumaira JAVAID
 *
 */
public interface IAdresseService {

	/**
	 * Créer l'adresse d'un client
	 * 
	 * @param adresse à créer en base, ne doit pas etre un {@literal null}
	 * @throws DataIntegrityViolationException si l'adresse est déjà existante dans
	 *                                         la base
	 * @throws NullPointerException            si l'adresse donnée en paramètre est
	 *                                         null
	 * @return une Adresse
	 */
	Adresse creerAdresse(@NotNull final Adresse adresse);

	/**
	 * Supprime une adresse
	 * 
	 * @param idAdresse identifiant de l'adresse à supppimer
	 * @throws IllegalArgumentException dans le cas où {@code idAdresse} donné est
	 *                                  {@literal null}
	 * @throws NullPointerException     si l'id de l'adresse donné en paramètre est
	 *                                  null
	 */
	void supprimerAdresseById(@NotNull final Long idAdresse);

	/**
	 * Met à jour une adresse. Si l'adresse existe déjà alors retourne l'adresse
	 * déjà sauvegardée
	 * 
	 * @param adresse à mettre à jour, ne doit pas etre un {@literal null}
	 * @return adresse that has been saved in (or retrieved from) the data base
	 * @throws NoSuchFieldException     si l'adresse avec id donné n'existe pas en
	 *                                  base
	 * @throws IllegalArgumentException si l'identidiant d'une {@code adresse} est
	 *                                  {@literal null}
	 */
	Adresse modifierAdresse(@NotNull final Adresse adresse) throws NoSuchFieldException;

}