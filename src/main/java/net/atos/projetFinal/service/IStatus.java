package net.atos.projetFinal.service;

import net.atos.projetFinal.model.Status;

import java.util.List;

/**
 * Service gérant les différents status de commande, de ligne de commande et de devis
 *
 */
public interface IStatus {
    
    List<Status> getAllStatuts();
    
    void creerStatus(final Status status);
    
    void supprimerStatusById(final Long idStatus);
    
    void modifierStatus(final List<Status> status);

}
