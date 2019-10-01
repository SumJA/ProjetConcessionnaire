package net.atos.projetFinal.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Description d'une ligne de produit
 */
@Entity
@Table(name = "ligneProduit", uniqueConstraints =
@UniqueConstraint(columnNames = {"qteProduit", "prixLigne", "devis_id", "stock_id"}))
public class LigneProduit implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    
    @Column(nullable = false)
    @ColumnDefault("1")
    private int qteProduit;
    
    @Column(nullable = false)
    @ColumnDefault("0")
    private float prixLigne;
    
    @ManyToOne
    @JoinColumn(name = "devis_id", nullable = false)
    private Devis devis;
    
    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
	private Stock stock;
    
    @Override
    public String toString() {
        return "LigneProduit{" +
                "id=" + id +
                ", qteProduit=" + qteProduit +
                ", prixLigne=" + prixLigne +
                ", devis=" + devis +
                ", stock=" + stock +
                '}';
    }
    
    /**
     * Gets devis.
     *
     * @return Value of devis.
     */
    public Devis getDevis() {
        return devis;
    }
    
    /**
     * Sets new devis.
     *
     * @param devis New value of devis.
     */
    public void setDevis(Devis devis) {
        this.devis = devis;
    }
    
    /**
     * Gets prixLigne.
     *
     * @return Value of prixLigne.
     */
    public float getPrixLigne() {
        return prixLigne;
    }
    
    /**
     * Sets new prixLigne.
     *
     * @param prixLigne New value of prixLigne.
     */
    public void setPrixLigne(float prixLigne) {
        this.prixLigne = prixLigne;
    }
    
    /**
     * Gets qteProduit.
     *
     * @return Value of qteProduit.
     */
    public int getQteProduit() {
        return qteProduit;
    }
    
    /**
     * Sets new qteProduit.
     *
     * @param qteProduit New value of qteProduit.
     */
    public void setQteProduit(int qteProduit) {
        this.qteProduit = qteProduit;
    }
    
    /**
     * Gets stock.
     *
     * @return Value of stock.
     */
    public Stock getStock() {
        return stock;
    }
    
    /**
     * Sets new stock.
     *
     * @param stock New value of stock.
     */
    public void setStock(Stock stock) {
        this.stock = stock;
    }
    
    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public Long getId() {
        return id;
    }
}