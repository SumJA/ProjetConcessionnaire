package net.atos.projetFinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Représente une ligne de produit
 * @author Administrateur
 *
 */
@Entity
@Table(name="ligneProduit")
public class LigneProduit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Identifiant de la ligne de produit
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idLigneProduit")
	private Long id ;
	
	/**
	 * Quantité voulu pour la ligne donnée
	 */
	@Column(name = "qteProduit")
	private int qte ;
	
	/**
	 * Prix totale pour la ligne
	 */
	@Column(name = "prixLigne")
	private float prixLigne ;
	
	/**
	 * Devis à laquelle la ligne appartient
	 */
	@ManyToOne
	@JoinColumn(name = "devis_idDevis")
	private Devis devis ;
	
	/**
	 * Stock présent dans un devis via ligneProduit
	 */
	@ManyToOne
	@JoinColumn(name = "stock_idStock")
	private Stock stock ;

	
	public LigneProduit() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public float getPrixLigne() {
		return prixLigne;
	}

	public void setPrixLigne(float prixLigne) {
		this.prixLigne = prixLigne;
	}

	public Devis getDevis() {
		return devis;
	}

	public void setDevis(Devis devisLigneProduit) {
		this.devis = devisLigneProduit;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stockLigneProduit) {
		this.stock = stockLigneProduit;
	}
}
