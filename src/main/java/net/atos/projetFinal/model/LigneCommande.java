package net.atos.projetFinal.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ligneCommande")
public class LigneCommande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Id du devis qui pointe sur la clé primaire
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idLigneCommande")
	private Long id ;
	
	/**
	 * Délai de livraison exprimé en jour
	 */
	@Column(name = "delaisLivraison")
	private int delaisLivraison ;
	
	/**
	 * Quantité nécessaire à la ligne de commande
	 */
	@Column(name = "qteCommande")
	private int qteCommande ;
	
	/**
	 * La commande à laquelle est affectée la ligne
	 */
	@ManyToOne
	@JoinColumn(name = "commande_idCommande")
	private Commande commande ;
	
	/**
	 * Stock présent dans un devis via ligneProduit
	 */
	@ManyToOne
	@JoinColumn(name = "stock_idStock")
	private Stock stock ;
	
	/**
	 * Le status du devis
	 */
	@ManyToOne
	@JoinColumn(name = "status_idstatus")
	private Status status ;

	/**
	 * Date de création du devis
	 */
	@Temporal(TemporalType.DATE)
	@Column(name="dateCreationLigneCommande")
	private LocalDateTime dateCreation ;

	public LigneCommande() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDelaisLivraison() {
		return delaisLivraison;
	}

	public void setDelaisLivraison(int delaisLivraison) {
		this.delaisLivraison = delaisLivraison;
	}

	public int getQteCommande() {
		return qteCommande;
	}

	public void setQteCommande(int qteCommande) {
		this.qteCommande = qteCommande;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	

}
