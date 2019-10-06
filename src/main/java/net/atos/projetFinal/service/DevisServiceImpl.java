package net.atos.projetFinal.service;

import net.atos.projetFinal.model.Devis;
import net.atos.projetFinal.model.Status;
import net.atos.projetFinal.repo.DevisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.NoSuchElementException;

@Service
public class DevisServiceImpl implements DevisService {
    @Autowired
    DevisRepository devisRepository;

//    @Override
//    public List<Commande> findByStatutNouvelleCommande() {
//        return null;
//    }
//
//    @Override
//    public List<Commande> findByStatutsEnTraitementPreteCommande() {
//        return null;
//    }
    
    @Override
    public Float calculPrixHTDevis(Devis devis) {
        return null;
    }
    
    @Override
    public Float calculPrixTTCDevis(Devis devis) {
        return null;
    }
    
    /**
     * Met à jour le statut d'un devis
     *
     * @param status le statut à mettre à jour, ne doit pas être {@literal null}
     * @param devis  le devis à mettre à jour, ne doit pas être {@literal null}
     * @throws NullPointerException
     * @throws NoSuchElementException
     */
    @Override
    public void mettreAJourStatut(@NotNull Status status, @NotNull Devis devis) {
        if (status != null & devis != null) {
            Devis devisAMettreAJour = devisRepository.findById(devis.getId()).get();
            devisAMettreAJour.setStatus(devis.getStatus());
            devisRepository.saveAndFlush(devisAMettreAJour);
        } else {
            throw new NullPointerException("Le status ou le devis donné en paramètre est null");
        }
    }
    
    @Override
    public Integer calculerDelaisDevis(Devis devis) {
        return null;
    }
    
    @Override
    public void ajouterNouveauProduit(Devis devis, String nomProduit, int quantiteProduit) {
    
    }
    
    @Override
    public Devis creerNouveauDevisAvecProduits(Devis devis, String nomProduit, int quantiteProduit) {
        return null;
    }

//    @Override
//    public Integer calculerDelaisCommande(Commande c) {
//        return null;
//    }
//
//    @Override
//    public Float calculerPrixCommande(Commande c) {
//        return null;
//    }
//
//    @Override
//    public Commande livrerCommande(Commande c) {
//        return null;
//    }
}
