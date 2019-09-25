package net.atos.projetFinal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.atos.projetFinal.model.Employe;

/**
 * Repo de l'entité Employe
 * @author NVV
 *
 */
@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
	@Query("SELECT e FROM Employe e WHERE e.nom = ?1")
	Employe findByUsername(String nom);
}
