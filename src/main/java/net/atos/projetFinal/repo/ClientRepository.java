package net.atos.projetFinal.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.atos.projetFinal.model.Client;



public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	
	@Query("select c from Client where c.id=?1")
	Optional<Client> finduserById(Integer userId);

}
