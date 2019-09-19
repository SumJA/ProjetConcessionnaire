package net.atos.projetFinal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.atos.projetFinal.model.Employe;

/**
 * DAO de l'entité Employe
 * @author NVV
 *
 */
@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
