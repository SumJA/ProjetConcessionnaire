package net.atos.projetFinal.service.impl;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.model.Client;
import net.atos.projetFinal.repo.AdresseRepository;
import net.atos.projetFinal.repo.ClientRepository;
import net.atos.projetFinal.service.IAdresseService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Implementation de {@link IAdresseService}
 */
@Service
public class ServiceAdresse implements IAdresseService {
    
    private final AdresseRepository adresseRepository;
    
    private final ClientRepository clientRepository;
    
    public ServiceAdresse(AdresseRepository adresseRepository, ClientRepository clientRepository) {
        this.adresseRepository = adresseRepository;
        this.clientRepository = clientRepository;
    }
    
    /**
     * Créer l'adresse d'un client
     *
     * @param adresse à créer en base, ne doit pas etre un {@literal null}
     * @return adresse sauvegardée dans (ou récupérée depuis) la base
     * @throws DataIntegrityViolationException dans le cas où l'objet {@code Adresse} donné en paramètre existe déjà en
     *                                         base
     * @throws NullPointerException            si l'objet {@code Adresse} donné en paramètre est * null
     */
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
                throw new DataIntegrityViolationException("Adresse déjà existante");
            }
        } else {
            throw new NullPointerException("L'Adresse fournie en paramètre est null");
        }
    }
    
    /**
     * Supprime une adresse
     *
     * @param idAdresse identifiant de l'adresse à supppimer, ne doit pas etre un {@literal null}
     * @throws IllegalArgumentException dans le cas où {@code idAdresse} donné est {@literal null}
     * @throws NullPointerException     si l'id de l'adresse donné en paramètre est null
     */
    @Override
    @Transactional
    public void supprimerAdresseById(@NotNull final Long idAdresse) {
        if (idAdresse != null) {
            adresseRepository.deleteById(idAdresse);
        } else {
            throw new NullPointerException("L'identifiant de l'adresse fournie en paramètre est null");
        }
    }
    
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
    @Override
    @Transactional
    public Adresse modifierAdresse(@NotNull final Adresse adresse) throws IllegalArgumentException {
        Adresse newAdresse = new Adresse();
        Optional<Adresse> adresseToUpdate = adresseRepository.findById(adresse.getId());
        
        if (!adresseToUpdate.isPresent()) {
            /* if the idAdresse does not exist then create new adresse */
            //newAdresse.setClients(adresse.getClients());
            newAdresse.setCodePostal(adresse.getCodePostal());
            newAdresse.setComplementAdresse(adresse.getComplementAdresse());
            newAdresse.setLibelleVoie(adresse.getLibelleVoie());
            newAdresse.setNumeroVoie(adresse.getNumeroVoie());
            newAdresse.setVille(adresse.getVille());
            
            return (creerAdresse(newAdresse));
        }
        
        if (adresseToUpdate.get().equals(adresse)) {
            /* if adresse equals to adresseToUpdate then do not update because same adresse already exist
             * (with same id because findById above) */
            return adresseToUpdate.get();
        }
        
        List<Adresse> adresseVerificationDoublon = adresseRepository.findAdresseByFields(adresse.getNumeroVoie(),
                adresse.getLibelleVoie(), adresse.getComplementAdresse(), adresse.getCodePostal(), adresse.getVille()
                , adresse.getPays());
        
        
        if (adresseVerificationDoublon.isEmpty()) {
            /* If a adresse with same attributes does not exist then modify the adresse */
            
            if (adresseToUpdate.get().getClients().size() > 1) {
                /* If the adresse to update has more than one client then create new one */
                newAdresse.setCodePostal(adresse.getCodePostal());
                newAdresse.setComplementAdresse(adresse.getComplementAdresse());
                newAdresse.setLibelleVoie(adresse.getLibelleVoie());
                newAdresse.setNumeroVoie(adresse.getNumeroVoie());
                newAdresse.setVille(adresse.getVille());
                
                return (creerAdresse(newAdresse));
            } else {
                /* If the adresse to update has less than (or only one) one clients then modify new one */
                adresseToUpdate.get().setCodePostal(adresse.getCodePostal());
                adresseToUpdate.get().setComplementAdresse(adresse.getComplementAdresse());
                adresseToUpdate.get().setLibelleVoie(adresse.getLibelleVoie());
                adresseToUpdate.get().setNumeroVoie(adresse.getNumeroVoie());
                adresseToUpdate.get().setVille(adresse.getVille());
                
                return (adresseRepository.save(adresseToUpdate.get()));
            }
        } else {
            /* If not empty  then the adresse fields already exist */
            Adresse adresseToReturn = adresseVerificationDoublon.get(0);
            
            if (adresseToUpdate.get().getClients().size() <= 1) {
                
                if (adresseToUpdate.get().getClients().size() == 1) {
                    /* if the adresse to update gets only one client then modify the client
                     * to point to the right adresse */
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
    @Override
    @Transactional
    public List<Adresse> recupererAdresseByFields(int numero, @NotNull String libelle, String complement,
                                                  @NotNull String codePostal,
                                                  @NotNull String ville, @NotNull String pays) {
        return adresseRepository.findAdresseByFields(numero, libelle, complement, codePostal, ville, pays);
    }
}
