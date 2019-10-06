package net.atos.projetFinal.service;

import net.atos.projetFinal.model.Commande;

public interface CommandeService {
    Commande creerNouvelleCommandeAvecDetails(Commande commande, String nomProduit, int qteProduit);
    
}
