package net.atos.projetFinal.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Description d'une ligne de commande
 */
@Entity
@Table(name = "ligneCommande", uniqueConstraints =
@UniqueConstraint(columnNames = {"delaiLivraison", "qteCommande", "commande_id", "stock_id"}))
public class LigneCommande implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    
    @Column(nullable = false)
    private int delaiLivraison;
    
    @Column(nullable = false)
    @ColumnDefault("1")
	private int qteCommande;
    
    @Column(nullable = false)
    private LocalDateTime dateCreationLigneCommande = LocalDateTime.now();
    
    @ManyToOne
    @JoinColumn(name = "commande_id", nullable = false)
    private Commande commande;
    
    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;
    
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;
    
    @Override
    public String toString() {
        return "LigneCommande{" +
                "id=" + id +
                ", delaiLivraison=" + delaiLivraison +
                ", qteCommande=" + qteCommande +
                ", dateCreationLigneCommande=" + dateCreationLigneCommande +
                ", commande=" + commande +
                ", stock=" + stock +
                ", status=" + status +
                '}';
    }
    
    /**
     * Gets commande.
     *
     * @return Value of commande.
     */
    public Commande getCommande() {
        return commande;
    }
    
    /**
     * Sets new commande.
     *
     * @param commande New value of commande.
     */
    public void setCommande(Commande commande) {
        this.commande = commande;
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
     * Gets dateCreationLigneCommande.
     *
     * @return Value of dateCreationLigneCommande.
     */
    public LocalDateTime getDateCreationLigneCommande() {
        return dateCreationLigneCommande;
    }
    
    /**
     * Sets new dateCreationLigneCommande.
     *
     * @param dateCreationLigneCommande New value of dateCreationLigneCommande.
     */
    public void setDateCreationLigneCommande(LocalDateTime dateCreationLigneCommande) {
        this.dateCreationLigneCommande = dateCreationLigneCommande;
    }
    
    /**
     * Gets qteCommande.
     *
     * @return Value of qteCommande.
     */
    public int getQteCommande() {
        return qteCommande;
    }
    
    /**
     * Sets new qteCommande.
     *
     * @param qteCommande New value of qteCommande.
     */
    public void setQteCommande(int qteCommande) {
        this.qteCommande = qteCommande;
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
     * Gets status.
     *
     * @return Value of status.
     */
    public Status getStatus() {
        return status;
    }
    
    /**
     * Sets new status.
     *
     * @param status New value of status.
     */
    public void setStatus(Status status) {
        this.status = status;
    }
    
    /**
     * Gets delaiLivraison.
     *
     * @return Value of delaiLivraison.
     */
    public int getDelaiLivraison() {
        return delaiLivraison;
    }
    
    /**
     * Sets new delaiLivraison.
     *
     * @param delaiLivraison New value of delaiLivraison.
     */
    public void setDelaiLivraison(int delaiLivraison) {
        this.delaiLivraison = delaiLivraison;
    }
}