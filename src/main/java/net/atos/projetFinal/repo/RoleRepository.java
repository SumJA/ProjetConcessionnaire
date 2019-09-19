package net.atos.projetFinal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import net.atos.projetFinal.model.Role;

/**
 * DAO de l'entité Role
 * @author NVV
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

}
