package net.atos.projetFinal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Description de l'entité devis géré par le commercial
 */
@Entity
@Table(name = "devis")
public class Devis implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    
    @Column(nullable = false)
    private LocalDateTime dateCreationDevis = LocalDateTime.now();
    
    @Column(nullable = false)
    private int delaiDevis;
    
    @Column(nullable = false)
    private float prixHT;
    
    @Column(nullable = false)
    private float prixTTC;
    
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    
    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;
    
    @ManyToOne
    @JoinColumn(name = "status_devis", nullable = false)
    private Status status;
    
    @OneToMany(mappedBy = "devis")
    private Set<LigneProduit> lignesProduit;
    
    /**
     * Gets employe.
     *
     * @return Value of employe.
     */
    public Employe getEmploye() {
        return employe;
    }
    
    /**
     * Sets new employe.
     *
     * @param employe New value of employe.
     */
    public void setEmploye(Employe employe) {
        this.employe = employe;
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
     * Gets dateCreationDevis.
     *
     * @return Value of dateCreationDevis.
     */
    public LocalDateTime getDateCreationDevis() {
        return dateCreationDevis;
    }
    
    /**
     * Sets new dateCreationDevis.
     *
     * @param dateCreationDevis New value of dateCreationDevis.
     */
    public void setDateCreationDevis(LocalDateTime dateCreationDevis) {
        this.dateCreationDevis = dateCreationDevis;
    }
    
    /**
     * Gets delaiDevis.
     *
     * @return Value of delaiDevis.
     */
    public int getDelaiDevis() {
        return delaiDevis;
    }
    
    /**
     * Sets new delaiDevis.
     *
     * @param delaiDevis New value of delaiDevis.
     */
    public void setDelaiDevis(int delaiDevis) {
        this.delaiDevis = delaiDevis;
    }
    
    /**
     * Gets prixTTC.
     *
     * @return Value of prixTTC.
     */
    public float getPrixTTC() {
        return prixTTC;
    }
    
    /**
     * Sets new prixTTC.
     *
     * @param prixTTC New value of prixTTC.
     */
    public void setPrixTTC(float prixTTC) {
        this.prixTTC = prixTTC;
    }
    
    /**
     * Gets client.
     *
     * @return Value of client.
     */
    public Client getClient() {
        return client;
    }
    
    /**
     * Sets new client.
     *
     * @param client New value of client.
     */
    public void setClient(Client client) {
        this.client = client;
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
     * Gets prixHT.
     *
     * @return Value of prixHT.
     */
    public float getPrixHT() {
        return prixHT;
    }
    
    /**
     * Sets new prixHT.
     *
     * @param prixHT New value of prixHT.
     */
    public void setPrixHT(float prixHT) {
        this.prixHT = prixHT;
    }
    
    @Override
    public String toString() {
        return "Devis{" +
                "id=" + id +
                ", dateCreationDevis=" + dateCreationDevis +
                ", delaiDevis=" + delaiDevis +
                ", prixHT=" + prixHT +
                ", prixTTC=" + prixTTC +
                ", client=" + client +
                ", employe=" + employe +
                ", status=" + status +
                '}';
    }
}