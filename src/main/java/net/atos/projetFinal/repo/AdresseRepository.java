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

import net.atos.projetFinal.model.Adresse;

/**
 * Repository pour une Adresse et qui est une extension de
 * {@link org.springframework.data.jpa.repository.JpaRepository}. {@inheritDoc}
 *
 * @author Sumaira JAVAID
 * 
 */
@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long> {

	/**
	 * Execution de la requete JPA pour récupérer les Adresse dont le numéro,
	 * libellé, complément, codePostal et Ville correspondent à ceux donné en
	 * paramètres
	 * 
	 * @param numero	numéro de la voie des adresses recherchés
	 * @param libelle	libellé de la voie des adresses recherchés
	 * @param complement	complément d'adresse des adresses recherchés
	 * @param codePostal	le code postal des adresses recherchés
	 * @param ville	le nom de la ville des adresses recherchés
	 * @return une liste d'adresse
	 */
	@Query("SELECT a FROM Adresse a WHERE a.numero = ?1 AND a.libelle = ?2 AND a.complement = ?3 AND a.codePostal = ?4 AND a.ville = ?5")
	List<Adresse> findAdresseByFields(int numero, String libelle, String complement, String codePostal, String ville);
}
