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

import net.atos.projetFinal.model.Status;

/**
 * Service gérant les différents status de commande, de ligne de commande et de devis
 * 
 * @author Sumaira JAVAID
 *
 */
public interface IStatus {
	
	/**
	 * Retourne la liste de l'ensemble des status sauvegardé en base
	 * 
	 * @return la liste de l'ensemble des status sauvegardé en base
	 */
	List<Status> trouverTousLesStatus();

	/**
	 * Retourne le status dont l'identifiant correspond à l'id donné en paramètre
	 * 
	 * @param id : l'identifiant du status à trouver
	 * @return le status dont l'identifiant correspond à l'id donné en paramètre
	 */
	Status trouverStatusParId(final Long id);
	
	/**
	 * Retourne le status dont le nom correspond au nom donné en paramètre
	 * 
	 * @param nomStatus : le nonm du status à trouver 
	 * @return le status dont le nom correspond au nom donné en paramètre
	 */
	Status trouverStatusParNom(final String nomStatus);

}
