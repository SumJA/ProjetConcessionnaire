package net.atos.projetFinal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.atos.projetFinal.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

}
