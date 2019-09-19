package net.atos.projetFinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Description des différents Role possible pour le employés
 * Entity de la table Role
 * @author NVV
 *
 */
@Entity
@Table(name = "Role")
public class Role implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id qui point sur la primary key de la table role qui est programmée en auto incremental
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idRole")
	private int id ;
	
	/**
	 * nom du rôle pointe sur la colonne nomRole de la table
	 */
	@Column(name="nomRole", length = 75)
	private String nom ;

	public Role() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
