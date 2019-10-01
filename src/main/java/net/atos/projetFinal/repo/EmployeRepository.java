package net.atos.projetFinal.repo;

import net.atos.projetFinal.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository pour un Employe et qui est une extension de {@link org.springframework.data.jpa.repository.JpaRepository}.
 * {@inheritDoc}
 */
@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
    /**
     * Retourne l'employé dont le nom correspond à celui donné en paramètre
     *
     * @param username le nom d'utilisateur de l'employé à retrouver
     * @return un Employé
     */
    @Query("SELECT e FROM Employe e WHERE e.username = ?1")
    Employe findByUsername(String username);
    
    /**
     * Retourne la lsite des employés dont le nom ou le mot de passe correspond à celui donné en paramètre
     *
     * @param username le nom d'utilisateur de ou des employés à retrouver
     * @param email    l'adresse email de ou des employés à retrouver
     * @return une liste d'employés
     */
    @Query("SELECT e FROM Employe e WHERE e.username = ?1 OR e.email = ?2")
    List<Employe> findEmployeByUsernameOrEmail(String username, String email);
}