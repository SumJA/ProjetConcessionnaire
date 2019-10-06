package net.atos.projetFinal.repo;

import net.atos.projetFinal.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Repository pour une Adresse et qui est une extension de
 * {@link org.springframework.data.jpa.repository.JpaRepository}.
 * {@inheritDoc}
 */
@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long> {
    /**
     * Execution de la requete JPA pour récupérer les Adresse dont le numéro, libellé, complément, codePostal et Ville
     * correspondent à ceux donné en paramètres
     *
     * @param numero     numéro de la voie des adresses recherchés
     * @param libelle    libellé de la voie des adresses recherchés
     * @param complement complément d'adresse des adresses recherchés
     * @param codePostal le code postal des adresses recherchés
     * @param ville      le nom de la ville des adresses recherchés
     * @param pays       le nom du pays des adresse recherchés
     * @return une liste d'adresse
     */

    @Query("SELECT a FROM Adresse a WHERE "
            + "?1 is NULL OR a.numeroVoie = ?1 "
            + "AND a.libelleVoie = ?2 "
            + "AND ?3 is NULL OR a.complementAdresse = ?3 "
            + "AND a.codePostal = ?4 "
            + "AND a.ville = ?5 "
            + "AND a.pays = ?6 ")
    List<Adresse> findAdresseByFields(@Param("numeroVoie") int numero,
                                      @NotNull String libelle,
                                      @Param("complementAdresse") String complement,
                                      @NotNull String codePostal,
                                      @NotNull String ville,
                                      @NotNull String pays);
}

