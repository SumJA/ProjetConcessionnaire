package net.atos.projetFinal.repo;

import net.atos.projetFinal.model.Role;
import net.atos.projetFinal.utils.RoleEmploye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * Repository pour un Role et qui est une extension de {@link org.springframework.data.jpa.repository.JpaRepository}.
 * {@inheritDoc}
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r FROM Role r WHERE r.nom = ?1")
    Optional<Role> findRoleByName(@NotNull RoleEmploye nom);
    
}
