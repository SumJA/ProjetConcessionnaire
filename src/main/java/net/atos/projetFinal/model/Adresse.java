package net.atos.projetFinal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Adresse d'un client
 *
 * @author Jerome BRUNA
 * @author Kamel TRABELSI
 * @author Nils VO-VAN
 * @author Sumaira JAVAID
 */
@Entity
@Table(name = "adresse", uniqueConstraints =
@UniqueConstraint(columnNames = {"numeroVoie", "libelleVoie", "complementAdresse", "codePostal", "ville", "pays"}))
public class Adresse implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    
    @Column
    private int numeroVoie;
    
    @Column(length = 200, nullable = false)
    private String libelleVoie;
    
    @Column(length = 150)
    private String complementAdresse;
    
    @Column(length = 45, nullable = false)
    private String codePostal;
    
    @Column(length = 100, nullable = false)
    private String ville;
    
    @Column(length = 100, nullable = false)
    private String pays;
    
    @OneToMany(mappedBy = "adresse")
    private Set<Client> clients;
    
    /**
     * Gets libelleVoie.
     *
     * @return Value of libelleVoie.
     */
    public String getLibelleVoie() {
        return libelleVoie;
    }
    
    /**
     * Sets new libelleVoie.
     *
     * @param libelleVoie New value of libelleVoie.
     */
    public void setLibelleVoie(String libelleVoie) {
        this.libelleVoie = libelleVoie;
    }
    
    /**
     * Gets codePostal.
     *
     * @return Value of codePostal.
     */
    public String getCodePostal() {
        return codePostal;
    }
    
    /**
     * Sets new codePostal.
     *
     * @param codePostal New value of codePostal.
     */
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    
    /**
     * Gets complementAdresse.
     *
     * @return Value of complementAdresse.
     */
    public String getComplementAdresse() {
        return complementAdresse;
    }
    
    /**
     * Sets new complementAdresse.
     *
     * @param complementAdresse New value of complementAdresse.
     */
    public void setComplementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
    }
    
    /**
     * Gets clients.
     *
     * @return Value of clients.
     */
    public Set<Client> getClients() {
        return clients;
    }
    
    /**
     * Sets new clients.
     *
     * @param clients New value of clients.
     */
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
    
    /**
     * Gets ville.
     *
     * @return Value of ville.
     */
    public String getVille() {
        return ville;
    }
    
    /**
     * Sets new ville.
     *
     * @param ville New value of ville.
     */
    public void setVille(String ville) {
        this.ville = ville;
    }
    
    /**
     * Gets idAdresse.
     *
     * @return Value of idAdresse.
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Gets numeroVoie.
     *
     * @return Value of numeroVoie.
     */
    public int getNumeroVoie() {
        return numeroVoie;
    }
    
    /**
     * Sets new numeroVoie.
     *
     * @param numeroVoie New value of numeroVoie.
     */
    public void setNumeroVoie(int numeroVoie) {
        this.numeroVoie = numeroVoie;
    }
    
    /**
     * Gets pays.
     *
     * @return Value of pays.
     */
    public String getPays() {
        return pays;
    }
    
    /**
     * Sets new pays.
     *
     * @param pays New value of pays.
     */
    public void setPays(String pays) {
        this.pays = pays;
    }
    
    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", numeroVoie=" + numeroVoie +
                ", libelleVoie='" + libelleVoie + '\'' +
                ", complementAdresse='" + complementAdresse + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }
    
    /**
     * Digère les données stockées dans une instance d'Adresse dans une valeur de hachage
     *
     * @return une valeur de hachage
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
        result = prime * result + ((complementAdresse == null) ? 0 : complementAdresse.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((libelleVoie == null) ? 0 : libelleVoie.hashCode());
        result = prime * result + numeroVoie;
        result = prime * result + ((ville == null) ? 0 : ville.hashCode());
        return result;
    }
    
    /**
     * Equals method with all attributes except for the following attributes id, dateCreation, dateDerniereMiseAJour and
     * clients equals method with all attributes except for idAdresse
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Adresse other = (Adresse) obj;
        if (codePostal == null) {
            if (other.codePostal != null)
                return false;
        } else if (!codePostal.equals(other.codePostal))
            return false;
        if (complementAdresse == null) {
            if (other.complementAdresse != null)
                return false;
        } else if (!complementAdresse.equals(other.complementAdresse))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (libelleVoie == null) {
            if (other.libelleVoie != null)
                return false;
        } else if (!libelleVoie.equals(other.libelleVoie))
            return false;
        if (numeroVoie != other.numeroVoie)
            return false;
        if (ville == null) {
            return other.ville == null;
        } else return ville.equals(other.ville);
    }
    
    @Override
    public Adresse clone() {
        Adresse clone;
        try {
            clone = (Adresse) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error("Erreur clone adresse");
        }
        return clone;
    }
}