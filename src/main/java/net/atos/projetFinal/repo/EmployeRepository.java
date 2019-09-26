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

import net.atos.projetFinal.model.Employe;

/**
 * Repository pour un Employe et qui est une extension de
 * {@link org.springframework.data.jpa.repository.JpaRepository}. {@inheritDoc}
 * 
 * @author Nils VO-VAN
 * @author Kamel TRABELSI
 * @author Sumaira JAVAID
 *
 */
@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
	/**
	 * Retourne l'employé dont le nom correspond à celui donné en paramètre
	 * 
	 * @param username	le nom de l'employé à retrouver
	 * @return un Employé
	 */
	@Query("SELECT e FROM Employe e WHERE e.nom = ?1")
	Employe findByUsername(String username);
	
	/**
	 * Retourne la lsite des employésdont le nom ou le mot de passe correspond à celui donné en paramètre
	 * 
	 * @param nom	le nom de ou des employés à retrouver
	 * @param email	le mot de passe de ou des employés à retrouver
	 * @return une liste d'employés
	 */
	@Query("SELECT e FROM Employe e WHERE e.nom = ?1 OR e.email = ?2")
	List<Employe> findEmployeByNameOrEmail(String nom, String email);
}