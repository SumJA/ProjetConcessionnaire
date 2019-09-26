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
package net.atos.projetFinal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.atos.projetFinal.model.Client;

/**
 * Repository pour un Client et qui est une extension de
 * {@link org.springframework.data.jpa.repository.JpaRepository}.
 *
 * @author Sumaira JAVAID
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	/**
	 * Retourne la liste des clients dont le nom et le prénom correspondent au nom
	 * et prénom donnés en paramètre
	 * 
	 * @param Nom    des clients recherchés
	 * @param prenom des clients recherchés
	 * @return une liste de Clients
	 */
	@Query("SELECT c FROM Client c WHERE c.nomClient = ?1 AND c.prenomClient = ?2")
	List<Client> findClientsByName(String Nom, final String prenom);

}