package net.atos.projetFinal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Description des différents Role possible pour l'employés Entity de la table Role
 */

@Entity
@Table(name = "role")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    
    @Column(length = 100, unique = true, nullable = false)
    private String nom;
    
    @OneToMany(mappedBy = "role")
    private Set<Employe> employes;
    
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
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
     * Gets employes.
     *
     * @return Value of employes.
     */
    public Set<Employe> getEmployes() {
        return employes;
    }
    
    /**
     * Sets new employes.
     *
     * @param employes New value of employes.
     */
    public void setEmployes(Set<Employe> employes) {
        this.employes = employes;
    }
}