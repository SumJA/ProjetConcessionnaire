package net.atos.projetFinal.service;

import net.atos.projetFinal.model.Devis;
import net.atos.projetFinal.model.Status;

import javax.validation.constraints.NotNull;

// TODO
public interface DevisService {
    Float calculPrixHTDevis(Devis devis);
    
    Float calculPrixTTCDevis(Devis devis);
    
    void mettreAJourStatut(@NotNull Status status, @NotNull Devis devis);
    
    Integer calculerDelaisDevis(Devis devis);
    
    void ajouterNouveauProduit(Devis devis, String nomProduit, int quantiteProduit);
    
    Devis creerNouveauDevisAvecProduits(Devis devis, String nomProduit, int quantiteProduit);
}
