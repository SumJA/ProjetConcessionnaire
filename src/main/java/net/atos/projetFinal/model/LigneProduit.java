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
 * 
 * @author JB
 * @author Kamal 
 * @author Nils 
 * 
 */
@Entity
@Table(name = "ligneProduit")
public class LigneProduit implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idLigneProduit")
	private Long idLigneProduit;
	
	@Column(nullable = false)
	private int qteProduit;
	
	@Column(nullable = false)
	private float prixLigne;
	
	@ManyToOne
	@JoinColumn(name = "devis_idDevis")
	private Devis devis;
	
	@ManyToOne
	@JoinColumn(name = "stock_idStock")
	private Stock stock;

	/**
	 * @return the qteProduit
	 */
	public int getQteProduit() {
		return qteProduit;
	}

	/**
	 * @param qteProduit the qteProduit to set
	 */
	public void setQteProduit(int qteProduit) {
		this.qteProduit = qteProduit;
	}

	/**
	 * @return the prixLigne
	 */
	public float getPrixLigne() {
		return prixLigne;
	}

	/**
	 * @param prixLigne the prixLigne to set
	 */
	public void setPrixLigne(float prixLigne) {
		this.prixLigne = prixLigne;
	}

	/**
	 * @return the devis
	 */
	public Devis getDevis() {
		return devis;
	}

	/**
	 * @param devis the devis to set
	 */
	public void setDevis(Devis devis) {
		this.devis = devis;
	}

	/**
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}

	/**
	 * @return the idLigneProduit
	 */
	public Long getIdLigneProduit() {
		return idLigneProduit;
	}

	@Override
	public String toString() {
		return "LigneProduit [idLigneProduit=" + idLigneProduit + ", qteProduit=" + qteProduit + ", prixLigne="
				+ prixLigne + ", devis=" + devis + ", stock=" + stock + "]";
	}
}
