package net.atos.projetFinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Entity Status
 * implement Serializable
 * attribut en private
 * getter/setter public
 * @author kamel
 *
 */
@Entity
@Table(name="status")
public class Status implements Serializable{
	
	
	/**
	 *  serial version id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id de status
	 * correspond à "idStatus" dans la Bdd
	 * généré avec "AUTO" (@GeneratedValue(strategy = GenerationType.AUTO)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idStatus")
	private Long id;
	
	@Column
	private String nomStatus;
	
	
	private Devis devis;
	
	private Commande commande;
	
	private LigneCommande ligneCommande;

	
	
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




	public String getNomStatus() {
		return nomStatus;
	}




	public void setNomStatus(String nomStatus) {
		this.nomStatus = nomStatus;
	}




	
	
	
	
	
	
	
	

}
