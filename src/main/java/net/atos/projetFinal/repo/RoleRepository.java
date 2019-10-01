package net.atos.projetFinal.repo;

import net.atos.projetFinal.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository pour un Role et qui est une extension de {@link org.springframework.data.jpa.repository.JpaRepository}.
 * {@inheritDoc}
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
