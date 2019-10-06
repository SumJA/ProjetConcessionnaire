package net.atos.projetFinal.service;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.model.Client;
import net.atos.projetFinal.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Implémentation de {@link IClientService} {@inheritDoc}
 */
public class ClientServiceImpl implements IClientService {
    @Autowired
    ClientRepository clientRepository;
    
    @Autowired
    IAdresseService adresseService;
    
    @Override
    @Transactional(readOnly = true)
    public List<Client> trouverTousLesClients() {
        return clientRepository.findAll();
    }
    
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
    
    @Override
    @Transactional(readOnly = true)
    public List<Client> trouverClientParNomEtPrenom(@NotNull final String nom,
                                                    @NotNull final String prenom) throws NullPointerException {
        if (nom.isEmpty())
            throw new NullPointerException("Le nom du client donné en paramètre est nul");
        else if (prenom.isEmpty())
            throw new NullPointerException("Le prénom du client donné en paramètre est nul");
        else
            return clientRepository.findClientsByName(nom, prenom);
    }
    
    @Override
    @Transactional
    public Client creerClient(@NotNull Client client) throws NullPointerException {
        if (client != null)
            return clientRepository.save(client);
        else
            throw new NullPointerException("l'objet Client donné en paramètre est null");
    }
    
    @Override
    @Transactional
    public void modifierClients(@NotEmpty List<Client> clients) throws NoSuchFieldException, IllegalArgumentException {
        if (clients.isEmpty())
            throw new IllegalArgumentException("La liste des clients à mettre à jour est vide");
        else
            for (Client client : clients)
                modifierClient(client);
    }
    
    @Override
    @Transactional
    public void modifierClient(@NotNull Client client) throws NoSuchFieldException, NullPointerException {
        if (client != null) {
            Optional<Client> clientToUpdate = clientRepository.findById(client.getId());
            if (clientToUpdate.isPresent()) {
                clientToUpdate.get().setEmail(client.getEmail());
                clientToUpdate.get().setDateDerniereMiseAJourClient(Instant.now());
                clientToUpdate.get().setNom(client.getNom());
                clientToUpdate.get().setNumeroTel(client.getNumeroTel());
                clientToUpdate.get().setPrenom(client.getPrenom());
                client = modifierAdresseClient(client);
                clientToUpdate.get().setAdresse(client.getAdresse());
                
                clientRepository.save(clientToUpdate.get());
            } else
                throw new NoSuchFieldException("client non reconnu dans la base de données");
        } else
            throw new NullPointerException("L'objet client donné en paramètre est null");
    }
    
    @Transactional
    public Client modifierAdresseClient(@NotNull Client client) throws NoSuchFieldException, NullPointerException {
        if (client != null) {
            Optional<Client> originalClient = clientRepository.findById(client.getId());
            if (originalClient.isPresent()) {
                Client clientUpdated = mettreAJourAdresseClient(originalClient.get(), client.getAdresse());
                return clientRepository.save(clientUpdated);
            } else
                throw new NoSuchElementException("client non reconnu dans la base de données");
        } else
            throw new NullPointerException("L'objet client donné en paramètre est null");
    }
    
    /**
     * //JAVADOC à faire
     *
     * @param client
     * @param adresse
     * @return
     * @throws NullPointerException
     */
    private Client mettreAJourAdresseClient(@NotNull Client client, @NotNull Adresse adresse) throws NullPointerException {
        if (client == null)
            throw new NullPointerException("L'objet client donné en paramètre est null");
        else if (adresse == null)
            throw new NullPointerException("L'objet adresse donné en paramètre est null");
        else if (client.getAdresse().getClients().size() > 1) {
            /* If more than one client depends on same adress then create a new adress */
            Adresse newAdresse = new Adresse();
            newAdresse.setCodePostal(adresse.getCodePostal());
            newAdresse.setComplementAdresse(adresse.getComplementAdresse());
            newAdresse.setLibelleVoie(adresse.getLibelleVoie());
            newAdresse.setNumeroVoie(adresse.getNumeroVoie());
            newAdresse.setVille(adresse.getVille());
            newAdresse.setPays(adresse.getPays());
            /* Pas d'id car généré automatiquement par le service */
            newAdresse = adresseService.creerAdresse(newAdresse);
            client.setAdresse(newAdresse);
            return client;
        } else {
            client.setAdresse(adresseService.modifierAdresse(client.getAdresse()));
            return client;
        }
    }
}
