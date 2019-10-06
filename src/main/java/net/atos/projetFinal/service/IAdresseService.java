package net.atos.projetFinal.service;


import net.atos.projetFinal.model.Adresse;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Service gérant l'adresse des clients du concessionnaire
 *
 * @author Nils
 * @author Sumaira JAVAID
 */
public interface IAdresseService {
    
    /**
     * Créer l'adresse dans la database
     *
     * @param adresse à créer en base, ne doit pas etre un {@literal null}
     * @return une Adresse
     * @throws DataIntegrityViolationException si l'adresse est déjà existante dans la base
     * @throws NullPointerException            si l'adresse donnée en paramètre est null
     */
    Adresse creerAdresse(@NotNull final Adresse adresse);
    
    /**
     * Supprime une adresse
     *
     * @param idAdresse identifiant de l'adresse à supppimer
     * @throws IllegalArgumentException dans le cas où {@code idAdresse} donné est {@literal null}
     * @throws NullPointerException     si l'id de l'adresse donné en paramètre est null
     */
    void supprimerAdresseParId(@NotNull final Long idAdresse);
    
    /**
     * Met à jour de l'adresse d'un client
     * <p> Si idAdresse ne pointe sur rien, une nouvelle adresse est créée. Sinon si idAdresse pointe sur une
     * adresse ayant les mêmes attributs alors rien faire. Sinon si aucune adresse existe avec des attributs identique à
     * celle passé en param alors modif. Sinon si une adresse avec des attributs indentiques à celle passé en paramètre
     * alors pointé sur celle-ci ET supprimer l'adresse avec idAdresse paramètré si elle ne contenait qu'un seul
     * client.
     * </p>
     *
     * @param adresse à mettre à jour, ne doit pas etre un {@literal null}
     * @return l'adresse mise à jour
     * @throws IllegalArgumentException si l'identidiant d'une {@code adresse} est {@literal null}
     */
    Adresse modifierAdresse(@NotNull final Adresse adresse) throws IllegalArgumentException;
    
    /**
     * récupère les Adresse dont le numéro, libellé, complément, codePostal et Ville correspondent à ceux donné en
     * paramètres
     *
     * @param numero     numéro de la voie des adresses recherchés
     * @param libelle    libellé de la voie des adresses recherchés
     * @param complement complément d'adresse des adresses recherchés
     * @param codePostal le code postal des adresses recherchés
     * @param ville      le nom de la ville des adresses recherchés
     * @param pays       le nom du pays des adresse recherchés
     * @return une liste d'adresse
     */
    List<Adresse> recupererAdresseByFields(int numero, @NotNull String libelle, String complement,
                                           @NotNull String codePostal,
                                           @NotNull String ville, @NotNull String pays);
}