package net.atos.projetFinal.service;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.model.Client;
import net.atos.projetFinal.repo.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Implémentation de {@link IClientService}
 */
@Service
public class ServiceClient implements IClientService {
    
    private final ClientRepository clientRepository;
    
    private final ServiceIAdresse serviceAdresse;
    
    public ServiceClient(ClientRepository clientRepository, ServiceIAdresse serviceAdresse) {
        this.clientRepository = clientRepository;
        this.serviceAdresse = serviceAdresse;
    }
    
    /**
     * Retourne la liste de tous les clients.
     *
     * @return la liste de tous les clients.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Client> trouverTousLesClients() {
        return clientRepository.findAll();
    }
    
    /**
     * Retourne la liste de l'ensemble des clients en base
     *
     * @param id du client à retrouver, ne doit pas etre un {@literal null}
     * @return la liste de l'ensemble des client sen base
     * @throws NullPointerException si l'id du client donné en paramètre est null
     */
    @Override
    @Transactional(readOnly = true)
    public Client trouverClientParId(@NotNull final Long id) throws NullPointerException, NoSuchElementException {
        if (id != null) {
            Optional<Client> client = clientRepository.findById(id);
            if (client.isPresent())
                return client.get();
            else
                throw new NoSuchElementException("Aucun client avec l'identifiant : " + id);
        } else
            throw new NullPointerException("L'identifiant du client fournie en paramètre est null");
    }
    
    /**
     * Retourne la liste des clients dont le nom et le prénom correspondent au nom et prénom donné en paramètre
     *
     * @param nom    du ou des clients recherchés, ne doit pas etre un {@literal null}
     * @param prenom du ou des clients recherchés, ne doit pas etre un {@literal null}
     * @return une liste de clients
     * @throws NullPointerException si le nom et/ou le prénom du client donné en paramètre est null
     */
    @Override
    @Transactional(readOnly = true)
    public List<Client> trouverClientParNomEtPrenom(@NotNull final String nom, @NotNull final String prenom) {
        if (nom.isEmpty()) {
            throw new NullPointerException("Le nom du client donné en paramètre est nul");
        } else if (prenom.isEmpty()) {
            throw new NullPointerException("Le prénom du client donné en paramètre est nul");
        } else {
            return clientRepository.findClientsByName(nom, prenom);
        }
    }
    
    /**
     * Création d'un nouveau client
     *
     * @param client : le client à créer, ne doit pas etre un {@literal null}
     * @return le client créé
     * @throws NullPointerException si l'objet {@code client} passé en paramètre est null
     */
    @Override
    @Transactional
    public Client creerClient(@NotNull Client client) {
        if (client != null) {
            Client clientJustCreated;
            
            clientJustCreated = clientRepository.save(client);
            return (clientJustCreated);
        } else {
            throw new NullPointerException("l'objet Client donné en paramètre est null");
        }
        
    }
    
    /**
     * Met à jour une liste de clients en base
     *
     * @param clients une liste de clients à mettre à jour, ne doit pas être vide
     * @throws IllegalArgumentException dans le cas où {@code employes} est une liste vide ou {@literal null}
     * @throws NoSuchFieldException si un client n'existe pas en base
	 */
    @Override
    @Transactional
    public void modifierClients(@NotEmpty List<Client> clients) throws NoSuchFieldException {
        if (clients.isEmpty()) {
            throw new IllegalArgumentException("La liste des clients à mettre à jour est vide");
        } else {
            for (Client client : clients) {
                modifierClient(client);
            }
        }
    }
    
    /**
     * Met à jour les information d'un client
     *
     * @param client à mettre à jour
     * @throws IllegalArgumentException si l'identidiant d'un {@code clients} est {@literal null}
     * @throws NoSuchFieldException     - si le client n'existe pas en base
     * @throws NullPointerException     si le {@code client} est {@literal null}
     */
    @Override
    @Transactional
    public void modifierClient(@NotNull Client client) throws NoSuchFieldException {
        if (client == null) {
            throw new NullPointerException("L'objet client donné en paramètre est null");
        } else {
            Client clientToUpdate = clientRepository.findById(client.getId()).get();
            
            /* If the adresse has changed then erase or create adresse */
            if (!clientToUpdate.getAdresse().equals(client.getAdresse())) {
                System.err.println("ServiceClient.modifierClient : juste avant modifierAdresseClient");
                client = modifierAdresseClient(client);
            }
            
            clientToUpdate.setAdresse(client.getAdresse());
            clientToUpdate.setEmail(client.getEmail());
            clientToUpdate.setDateCreationClient(client.getDateCreationClient());
            clientToUpdate.setDateDerniereMiseAJourClient(Instant.now());
            clientToUpdate.setNom(client.getNom());
            clientToUpdate.setNumeroTel(client.getNumeroTel());
            clientToUpdate.setPrenom(client.getPrenom());
            
            clientRepository.save(clientToUpdate);
        }
    }
    
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
    @Override
    @Transactional
    public Client modifierAdresseClient(@NotNull Client client) throws NoSuchFieldException, NullPointerException {
        if (client == null) {
            throw new NullPointerException("L'objet client donné en paramètre est null");
        } else {
            Client originalClient = clientRepository.findById(client.getId()).get();
            Adresse adresse = client.getAdresse();
            
            
            if (originalClient.getAdresse().getClients().size() > 1) {
                /* If more than one client depends on same adresse then create a new adresse */
                Adresse newAdresse = new Adresse();
                newAdresse.setCodePostal(adresse.getCodePostal());
                newAdresse.setComplementAdresse(adresse.getComplementAdresse());
                newAdresse.setLibelleVoie(adresse.getLibelleVoie());
                newAdresse.setNumeroVoie(adresse.getNumeroVoie());
                newAdresse.setVille(adresse.getVille());
                /* Pas d'id car généré automatiquement par le service */
                newAdresse = serviceAdresse.creerAdresse(newAdresse);
                client.setAdresse(newAdresse);
            } else {
                client.setAdresse(serviceAdresse.modifierAdresse(client.getAdresse()));
            }
            
            return client;
        }
    }
}
