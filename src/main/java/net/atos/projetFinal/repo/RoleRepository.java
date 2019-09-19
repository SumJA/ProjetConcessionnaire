package net.atos.projetFinal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.atos.projetFinal.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
