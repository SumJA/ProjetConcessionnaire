package net.atos.projetFinal.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import net.atos.projetFinal.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{


}