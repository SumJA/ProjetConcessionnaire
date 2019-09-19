package net.atos.projetFinal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.atos.projetFinal.model.Role;

/**
 * DAO de l'entité Role
 * @author NVV
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
