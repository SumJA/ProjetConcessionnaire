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

import java.util.NoSuchElementException;

import javax.validation.constraints.NotNull;

import org.springframework.dao.DataIntegrityViolationException;

import net.atos.projetFinal.model.Adresse;

/**
 * Service gérant l'adresse des clients du concessionnaire
 * 
 * @author Nils Vovan
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
	void supprimerAdresseParId(@NotNull final Long idAdresse);

	/**
	 * FIXME : voir Implémentation !! Met à jour une adresse
	 * 
	 * @param adresse à mettre à jour, ne doit pas etre un {@literal null}
	 * @throws IllegalArgumentException si l'identidiant d'une {@code adresse} est
	 *                                  {@literal null} ou si L'adresse donné est en
	 *                                  paramètre est {@literal null}
	 * @throws NoSuchElementException   - si l'adresse n'existe pas en base
	 */
	void modifierAdresse(@NotNull final Adresse adresse);

}
