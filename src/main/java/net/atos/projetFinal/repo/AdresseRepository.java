package net.atos.projetFinal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.atos.projetFinal.model.Adresse;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long> {

}
