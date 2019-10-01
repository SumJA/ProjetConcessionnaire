package net.atos.projetFinal.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Description du Stock de voiture
 */
@Entity
@Table(name = "stock")
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    
    @Column(length = 100, nullable = false, unique = true)
    private String nomProduit;
    
    @Column(nullable = false)
    private float prixProduit;
    
    @Column(nullable = false)
    @ColumnDefault("0")
    private int qteProduitDispo;
    
    @Column(nullable = false)
    @ColumnDefault("0")
    private int qteReserve;
    
    @OneToMany(mappedBy = "stock")
    private Set<LigneProduit> lignesProduit;
    
    @OneToMany(mappedBy = "stock")
    private Set<LigneCommande> lignesCommande;
    
    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", nomProduit='" + nomProduit + '\'' +
                ", prixProduit=" + prixProduit +
                ", qteProduitDispo=" + qteProduitDispo +
                ", qteReserve=" + qteReserve +
                '}';
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
     * Gets qteProduitDispo.
     *
     * @return Value of qteProduitDispo.
     */
    public int getQteProduitDispo() {
        return qteProduitDispo;
    }
    
    /**
     * Sets new qteProduitDispo.
     *
     * @param qteProduitDispo New value of qteProduitDispo.
     */
    public void setQteProduitDispo(int qteProduitDispo) {
        this.qteProduitDispo = qteProduitDispo;
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
     * Gets lignesProduit.
     *
     * @return Value of lignesProduit.
     */
    public Set<LigneProduit> getLignesProduit() {
        return lignesProduit;
    }
    
    /**
     * Sets new lignesProduit.
     *
     * @param lignesProduit New value of lignesProduit.
     */
    public void setLignesProduit(Set<LigneProduit> lignesProduit) {
        this.lignesProduit = lignesProduit;
    }
    
    /**
     * Gets qteReserve.
     *
     * @return Value of qteReserve.
     */
    public int getQteReserve() {
        return qteReserve;
    }
    
    /**
     * Sets new qteReserve.
     *
     * @param qteReserve New value of qteReserve.
     */
    public void setQteReserve(int qteReserve) {
        this.qteReserve = qteReserve;
    }
    
    /**
     * Gets prixProduit.
     *
     * @return Value of prixProduit.
     */
    public float getPrixProduit() {
        return prixProduit;
    }
    
    /**
     * Sets new prixProduit.
     *
     * @param prixProduit New value of prixProduit.
     */
    public void setPrixProduit(float prixProduit) {
        this.prixProduit = prixProduit;
    }
    
    /**
     * Gets nomProduit.
     *
     * @return Value of nomProduit.
     */
    public String getNomProduit() {
        return nomProduit;
    }
    
    /**
     * Sets new nomProduit.
     *
     * @param nomProduit New value of nomProduit.
     */
    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }
}