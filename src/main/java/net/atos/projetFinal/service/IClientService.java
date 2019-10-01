//package net.atos.projetFinal.service;
//​
//import net.atos.projetFinal.model.Client;
//​
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//​
///**
// * Service gérant la clientèle du concessionnaire
// */
//public interface IClientService {
//    
//    /**
//     * Récupère le client avec l'ID donné
//     *
//     * @param id id recherché
//     * @return le client avec l'id suivant
//     */
//    Client findClientById(Long id);
//    
//    /**
//     * Retourne la liste de tous les clients.
//     *
//     * @return la liste de tous les clients.
//     */
//    List<Client> getAllClients();
//    
//    /**
//     * Retourne la liste de l'ensemble des clients en base
//     *
//     * @param id du client à retrouver, ne doit pas etre un {@literal null}
//     * @return la liste de l'ensemble des client sen base
//     * @throws NullPointerException si l'id du client donné en paramètre est null
//     */
//    Optional<Client> trouverClientParId(final Long id);
//    
//    /**
//     * Retourne la liste des clients dont le nom et le prénom correspondent au nom et prénom donné en paramètre
//     *
//     * @param nom    du ou des clients recherchés, ne doit pas etre un {@literal null}
//     * @param prenom du ou des clients recherchés, ne doit pas etre un {@literal null}
//     * @return une liste de clients
//     * @throws NullPointerException si le nom et/ou le prénom du client donné en paramètre est null
//     */
//    List<Client> trouverClientParNom(@NotNull final String nom, @NotNull final String prenom);
//    
//    /**
//     * Création d'un nouveau client
//     *
//     * @param client : le client à créer, ne doit pas etre un {@literal null}
//     * @return le client créé
//     * @throws NullPointerException si l'objet {@code client} passé en paramètre est null
//     */
//    Client creerClient(@NotNull final Client client);
//    
//    /**
//     * Met à jour une liste de clients en base
//     *
//     * @param clients une liste de clients à mettre à jour, ne doit pas être vide
//     * @throws IllegalArgumentException dans le cas où {@code employes} est une liste vide ou {@literal null}
//     * @throws NoSuchFieldException si un client n'existe pas en base
//     */
//    void modifierClients(@NotEmpty final List<Client> clients) throws NoSuchFieldException;
//    
//    /**
//     * Met à jour les information d'un client
//     *
//     * @param client à mettre à jour
//     * @throws IllegalArgumentException si l'identidiant d'un {@code clients} est {@literal null}
//     * @throws NoSuchFieldException     - si un client n'existe pas en base
//     * @throws NullPointerException si le {@code client} est {@literal null}
//     */
//    void modifierClient(@NotNull Client client) throws NoSuchFieldException;
//    
//    
//    /**
//     * Modify the adresse of the client in the database
//     * <p>NB if the adresse attribute of the client has an other client that the parameter client the method create a
//     * new adresse</p>
//     *
//     * @param client : client that contains the new value of the adresse, should not be {@literal null}
//     * @return the new client values (adresse updated)
//     * @throws NoSuchFieldException if a client is not recorded in the database
//     */
//    Client modifierAdresseClient(@NotNull Client client) throws NoSuchFieldException;
//    
