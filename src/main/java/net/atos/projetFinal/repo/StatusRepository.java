package net.atos.projetFinal.repo;

import net.atos.projetFinal.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository pour un Status et qui est une extension de {@link org.springframework.data.jpa.repository.JpaRepository}.
 * {@inheritDoc}
 */
@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    @Query("SELECT s FROM Status s WHERE s.nom = ?1")
    Optional<Status> findByName(String nom);
}
