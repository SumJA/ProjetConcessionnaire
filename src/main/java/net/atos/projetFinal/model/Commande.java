package net.atos.projetFinal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Commande d'un stock
 */
@Entity
@Table(name = "commande")
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;
    
    @ManyToOne
    @JoinColumn(name = "statut_livraison", nullable = false)
    private Status status;
    
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    
    @OneToMany(mappedBy = "commande")
    private Set<LigneCommande> lignesCommande;
    
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
     * Gets id.
     *
     * @return Value of id.
     */
    public Long getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", employe=" + employe +
                ", status=" + status +
                ", client=" + client +
                '}';
    }
}