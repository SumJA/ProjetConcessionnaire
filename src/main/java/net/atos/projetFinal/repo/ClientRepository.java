package net.atos.projetFinal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.atos.projetFinal.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}