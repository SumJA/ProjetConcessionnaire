package net.atos.projetFinal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import net.atos.projetFinal.model.Employe;

/**
 * DAO de l'entité Employe
 * @author NVV
 *
 */
public interface EmployeRepository extends JpaRepository<Employe, Integer> {

}
