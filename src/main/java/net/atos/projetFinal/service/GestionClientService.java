package net.atos.projetFinal.service;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.model.Client;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Service gérant la clientèle du concessionnaire
 */
public interface GestionClientService {
    
    /**
     * Retourne la liste de tous les clients.
     *
     * @return la liste de tous les clients.
     */
    List<Client> trouverTousLesClients();
    
    /**
     * Retourne la liste de l'ensemble des clients en base
     *
     * @param id l'identifiant du client à retrouver, ne doit pas etre un {@literal null}
     * @return la liste de l'ensemble des client sen base
     * @throws NullPointerException   si l'{@code id} donné en paramètre est {@literal null}
     * @throws NoSuchElementException si aucun client avec l'{@code id} donné n'est enregistré dans la base
     */
    Client trouverClientParId(@NotNull final Long id) throws NullPointerException, NoSuchElementException;
    
    /**
     * Retourne la liste des clients dont le nom et le prénom correspondent au {@code nom} et {@code prenom} donné en
     * paramètre
     *
     * @param nom    le nom du ou des clients recherchés, ne doit pas etre un {@literal null}
     * @param prenom le prénom du ou des clients recherchés, ne doit pas etre un {@literal null}
     * @return une liste de clients
     * @throws NullPointerException si le nom et/ou le prénom du client donné en paramètre est null
     */
    List<Client> trouverClientParNomEtPrenom(@NotNull final String nom, @NotNull final String prenom)
            throws NullPointerException;
    
    /**
     * Création d'un nouveau client
     *
     * @param client : le client à créer, ne doit pas etre un {@literal null}
     * @return le client créé, ne sera jamais un {@literal null}
     * @throws NullPointerException si l'objet {@code client} passé en paramètre est {@literal null}
     */
    Client creerClient(@NotNull final Client client) throws NullPointerException;
    
    /**
     * Met à jour une liste de clients en base
     *
     * @param clients une liste de clients à mettre à jour, ne doit pas être vide
     * @throws IllegalArgumentException dans le cas où {@code employes} est une liste vide ou {@literal null}
     * @throws NoSuchFieldException     si un client n'existe pas en base
     */
    void modifierClients(@NotEmpty final List<Client> clients) throws NoSuchFieldException, IllegalArgumentException;
    
    /**
     * Met à jour les information d'un client
     *
     * @param client à mettre à jour
     * @throws IllegalArgumentException si l'identidiant d'un {@code clients} est {@literal null}
     * @throws NoSuchFieldException     - si le client n'existe pas en base
     * @throws NullPointerException     si le {@code client} est {@literal null}
     */
    void modifierClient(@NotNull Client client) throws NoSuchFieldException, IllegalArgumentException;
    
    /**
     * Modify the adresse of the client in the database
     * <p>
     * NB if the adresse attribute of the client has an other client that the parameter client the method create a new
     * adresse
     * </p>
     *
     * @param client : client that contains the new value of the adresse, should not be {@literal null}
     * @return the new client values (adresse updated)
     * @throws NoSuchFieldException if a client is not recorded in the database
     * @throws NullPointerException if the {@code client} is {@literal null}
     */
    Client modifierAdresseClient(@NotNull Client client) throws NoSuchFieldException, NullPointerException;
    
    /**
     * Créer l'adresse d'un client
     *
     * @param adresse à créer en base, ne doit pas etre un {@literal null}
     * @return adresse sauvegardée dans (ou récupérée depuis) la base
     * @throws DataIntegrityViolationException dans le cas où l'objet {@code Adresse} donné en paramètre existe déjà en
     *                                         base
     * @throws NullPointerException            si l'objet {@code Adresse} donné en paramètre est * null
     */
    Adresse creerAdresse(@NotNull Adresse adresse);
    
    /**
     * Supprime une adresse FIXME
     *
     * @param idAdresse identifiant de l'adresse à supppimer, ne doit pas etre un {@literal null}
     * @throws IllegalArgumentException dans le cas où {@code idAdresse} donné est {@literal null}
     * @throws NullPointerException     si l'id de l'adresse donné en paramètre est null
     */
    void supprimerAdresseById(@NotNull Long idAdresse);
    
    /**
     * Met à jour une adresse.
     * <p> Si idAdresse ne pointe sur rien donc creation adresse. Sinon si idAdresse pointe sur une
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
    Adresse modifierAdresse(@NotNull Adresse adresse) throws IllegalArgumentException;
    
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
    
    /**
     * TODO and FIXME
     *
     * @param idClient
     */
    void supprimerClientById(@NotNull Long idClient);
    
    List<Client> recupererClientParNom(@NotNull String nom, @NotNull String prenom);
    
}