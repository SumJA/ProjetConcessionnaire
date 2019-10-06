package net.atos.projetFinal.service;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.model.Client;
import net.atos.projetFinal.repo.AdresseRepository;
import net.atos.projetFinal.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Implémentation de {@link GestionClientService}
 * <p>
 * {@inheritDoc}
 */
@Service
public class GestionClientServiceImpl implements GestionClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private AdresseRepository adresseRepository;
    
    @Autowired
    private IAdresseService adresseService;
    
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
    public List<Client> trouverClientParNomEtPrenom(@NotNull final String nom, @NotNull final String prenom)
            throws NullPointerException {
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
        if (client != null) {
            Adresse adresse = client.getAdresse();
            List<Adresse> adresseDoublon = adresseRepository.findAdresseByFields(adresse.getNumeroVoie(),
                    adresse.getLibelleVoie(),
                    adresse.getComplementAdresse(),
                    adresse.getCodePostal(),
                    adresse.getVille(),
                    adresse.getPays());
            if (adresseDoublon.isEmpty()) {
                client.setAdresse(adresseRepository.save(client.getAdresse()));
            }
            return clientRepository.save(client);
        } else
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
     * //TODO : JAVADOC à faire
     *
     * @param client
     * @param adresse
     * @return
     * @throws NullPointerException
     */
    private Client mettreAJourAdresseClient(@NotNull Client client, @NotNull Adresse adresse)
            throws NullPointerException {
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
            newAdresse = adresseRepository.save(newAdresse);
            client.setAdresse(newAdresse);
            return client;
        } else {
            client.setAdresse(modifierAdresse(client.getAdresse()));
            return client;
        }
    }
    
    @Override
    @Transactional
    public Adresse creerAdresse(@NotNull final Adresse adresse) {
        if (adresse != null) {
            List<Adresse> adresseVerificationDoublon = adresseRepository.findAdresseByFields(adresse.getNumeroVoie(),
                    adresse.getLibelleVoie(), adresse.getComplementAdresse(), adresse.getCodePostal(),
                    adresse.getVille(), adresse.getPays());
            if (adresseVerificationDoublon.isEmpty()) {
                return adresseRepository.saveAndFlush(adresse);
            } else {
                return adresseVerificationDoublon.get(0);
            }
        } else {
            throw new NullPointerException("L'Adresse fournie en paramètre est null");
        }
    }
    
    @Override
    @Transactional
    public void supprimerAdresseById(@NotNull final Long idAdresse) {
        if (idAdresse != null) { // FIXME : vérification des clients liés à l'adresse
            adresseRepository.deleteById(idAdresse);
        } else {
            throw new NullPointerException("L'identifiant de l'adresse fournie en paramètre est null");
        }
    }
    
    @Override
    @Transactional
    public void supprimerClientById(@NotNull final Long idClient) {
        if (idClient != null) { // FIXME : vérification des clients liés à l'adresse
            Optional<Client> client = clientRepository.findById(idClient);
            if (client.isPresent()) {
                adresseRepository.deleteById(client.get().getAdresse().getId());
                clientRepository.deleteById(client.get().getId());
            } else {
                throw new NoSuchElementException("Client inconnu");
            }
        } else {
            throw new NullPointerException("L'identifiant de l'adresse fournie en paramètre est null");
        }
    }
    
    @Override
    @Transactional
    public Adresse modifierAdresse(@NotNull final Adresse adresse) throws IllegalArgumentException {
        Optional<Adresse> adresseToUpdate = adresseRepository.findById(adresse.getId());
        
        if (!adresseToUpdate.isPresent())
            return (adresseRepository.save(adresse));
        
        List<Adresse> adresseVerificationDoublon = adresseRepository.findAdresseByFields(adresse.getNumeroVoie(),
                adresse.getLibelleVoie(), adresse.getComplementAdresse(), adresse.getCodePostal(), adresse.getVille(),
                adresse.getPays());
        
        if (adresseToUpdate.get().equals(adresse)) {
            /*
             * if adresse equals to adresseToUpdate then do not update because same adresse
             * already exist (with same id because findById above)
             */
            return adresseToUpdate.get(); // FIXME : throw exception
        }
        
        if (adresseVerificationDoublon.isEmpty()) {
            /* If a adresse with same attributes does not exist then modify the adresse */
            
            if (adresseToUpdate.get().getClients().size() > 1) {
                /* If the adresse to update has more than one client then create new one */
                return (adresseRepository.save(adresse));
            } else {
                /*
                 * If the adresse to update has less than (or only one) one clients then modify
                 * new one
                 */
                adresseToUpdate.get().setCodePostal(adresse.getCodePostal());
                adresseToUpdate.get().setComplementAdresse(adresse.getComplementAdresse());
                adresseToUpdate.get().setLibelleVoie(adresse.getLibelleVoie());
                adresseToUpdate.get().setNumeroVoie(adresse.getNumeroVoie());
                adresseToUpdate.get().setVille(adresse.getVille());
                
                return (adresseRepository.save(adresseToUpdate.get()));
            }
        } else {
            /* If not empty then the adresse fields already exist */
            Adresse adresseToReturn = adresseVerificationDoublon.get(0);
            
            if (adresseToUpdate.get().getClients().size() <= 1) {
                
                if (adresseToUpdate.get().getClients().size() == 1) {
                    /*
                     * if the adresse to update gets only one client then modify the client to point
                     * to the right adresse
                     */
                    Client clientToModify;
                    
                    clientToModify = adresseToUpdate.get().getClients().iterator().next();
                    
                    clientToModify.setAdresse(adresseToReturn);
                    clientToModify = clientRepository.save(clientToModify);
                }
                
                /* if the adresse has only one client then remove from the database */
                adresseToUpdate.get().getClients().clear();
                supprimerAdresseById(adresseToUpdate.get().getId());
            }
            /* If the adresse exists then return the existed adresse */
            return adresseToReturn;
        }
    }
    
    @Override
    @Transactional
    public List<Adresse> recupererAdresseByFields(int numero, @NotNull String libelle, String complement,
                                                  @NotNull String codePostal, @NotNull String ville, @NotNull String pays) {
        return adresseRepository.findAdresseByFields(numero, libelle, complement, codePostal, ville, pays);
    }
    
    @Override
    @Transactional
    public List<Client> recupererClientParNom(@NotNull String nom, @NotNull String prenom) {
        return clientRepository.findClientsByName(nom, prenom);
    }
}
