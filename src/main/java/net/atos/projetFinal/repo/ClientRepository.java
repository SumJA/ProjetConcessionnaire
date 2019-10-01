package net.atos.projetFinal.repo;

import net.atos.projetFinal.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository pour un Client et qui est une extension de {@link org.springframework.data.jpa.repository.JpaRepository}.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
    /**
     * Retourne la liste des clients dont le nom et le prénom correspondent au nom et prénom donnés en paramètre
     *
     * @param Nom    des clients recherchés
     * @param prenom des clients recherchés
     * @return une liste de Clients
     */
    @Query("SELECT c FROM Client c WHERE c.nom = ?1 AND c.prenom = ?2")
    List<Client> findClientsByName(String Nom, final String prenom);
    
}