package net.atos.projetFinal.repo;

import net.atos.projetFinal.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository pour un Status et qui est une extension de {@link org.springframework.data.jpa.repository.JpaRepository}.
 * {@inheritDoc}
 */
@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
