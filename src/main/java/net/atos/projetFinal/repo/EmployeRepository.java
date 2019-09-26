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
 * @author Jerome Bruna
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