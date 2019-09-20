package net.atos.projetFinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Gère un status
 * 
 * @author kamel
 *
 */
@Entity
@Table(name = "status")
public class Status implements Serializable {

	/**
	 * serial version id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id de status correspond à "idStatus" dans la Bdd généré avec "AUTO"
	 * (@GeneratedValue(strategy = GenerationType.AUTO)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idStatus")
	private Long id;

	/**
	 * Nom du status identifé par la colone nomStatus
	 */
	@Column(name = "nomStatus", length = 100)
	private String nom;
	
	//TODO OneToMany des ligneCommande, Commande et devis

	/**
	 * Constructeur par défaut
	 */
	public Status() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nomStatus) {
		this.nom = nomStatus;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", nom=" + nom + "]";
	}
}
