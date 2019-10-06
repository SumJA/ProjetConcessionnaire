package net.atos.projetFinal.model;

import net.atos.projetFinal.utils.RoleEmploye;

import javax.persistence.*;
import java.io.Serializable;

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
    
    @Enumerated(EnumType.STRING)
    private RoleEmploye nom;
    
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", nom=" + nom +
                '}';
    }
    
    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Gets nom.
     *
     * @return Value of nom.
     */
    public RoleEmploye getNom() {
        return nom;
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
     * Sets new nom.
     *
     * @param nom New value of nom.
     */
    public void setNom(RoleEmploye nom) {
        this.nom = nom;
    }
}