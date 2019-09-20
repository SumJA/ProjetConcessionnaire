package net.atos.projetFinal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Description des différents Role possible pour le employés Entity de la table
 * Role
 * 
 * @author NVV
 *
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idRole", updatable = false, nullable = false)
	private Long id;

	@Column(name = "nomRole", length = 100)
	private String nom;
	
	@OneToMany(mappedBy = "role")
	private List<Employe> employes ;

	public Role() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", nom=" + nom + "]";
	}

}
