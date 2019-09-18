package net.atos.projetFinal.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.atos.projetFinal.model.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, Integer>{
	
	


}
