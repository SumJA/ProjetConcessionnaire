package net.atos.projetFinal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Description des différents Status possible pour un devis, une commande ou une ligne de commande
 */

@Entity
@Table(name = "status")
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    
    @Column(length = 100, nullable = false, unique = true)
    private String nom;
    
    @OneToMany(mappedBy = "status")
    private Set<LigneCommande> lignesCommande;
    
    @OneToMany(mappedBy = "status")
    private Set<Devis> devis;
    
    @OneToMany(mappedBy = "status")
    private Set<Commande> commandes;
    
    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
    
    /**
     * Gets devis.
     *
     * @return Value of devis.
     */
    public Set<Devis> getDevis() {
        return devis;
    }
    
    /**
     * Sets new devis.
     *
     * @param devis New value of devis.
     */
    public void setDevis(Set<Devis> devis) {
        this.devis = devis;
    }
    
    /**
     * Gets lignesCommande.
     *
     * @return Value of lignesCommande.
     */
    public Set<LigneCommande> getLignesCommande() {
        return lignesCommande;
    }
    
    /**
     * Sets new lignesCommande.
     *
     * @param lignesCommande New value of lignesCommande.
     */
    public void setLignesCommande(Set<LigneCommande> lignesCommande) {
        this.lignesCommande = lignesCommande;
    }
    
    /**
     * Gets commandes.
     *
     * @return Value of commandes.
     */
    public Set<Commande> getCommandes() {
        return commandes;
    }
    
    /**
     * Sets new commandes.
     *
     * @param commandes New value of commandes.
     */
    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }
    
    /**
     * Gets nom.
     *
     * @return Value of nom.
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Sets new nom.
     *
     * @param nom New value of nom.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(Long id) {
        this.id = id;
    }
}