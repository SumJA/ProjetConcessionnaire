package net.atos.projetFinal.service;

import net.atos.projetFinal.exception.InvalidUserRole;
import net.atos.projetFinal.model.Client;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Service gérant la clientèle du concessionnaire
 */
public interface IClientService {
    
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
    List<Client> trouverClientParNomEtPrenom(@NotNull final String nom,
                                             @NotNull final String prenom) throws NullPointerException;
    
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
    void modifierClient(@NotNull Client client) throws NoSuchFieldException, InvalidUserRole;
    
    /**
     * Modify the adresse of the client in the database
     * <p>NB if the adresse attribute of the client has an other client that the parameter client the method create a
     * new adresse</p>
     *
     * @param client : client that contains the new value of the adresse, should not be {@literal null}
     * @return the new client values (adresse updated)
     * @throws NoSuchFieldException if a client is not recorded in the database
     * @throws NullPointerException if the {@code client} is {@literal null}
     */
    Client modifierAdresseClient(@NotNull Client client) throws NoSuchFieldException, NullPointerException;
}

