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

import org.hibernate.annotations.ColumnDefault;

/**
 * 
 * @author JB
 * @author Kamal 
 * @author Nils 
 * 
 */

@Entity
@Table(name = "stock")
public class Stock implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStock;

	@Column(length = 100, nullable = false)
	private String nomProduit;

	@Column(nullable = false)
	private float prixProduit;

	@Column(nullable = false)
	@ColumnDefault("0")
	private int qteProduitDispo;

	@Column(nullable = false)
	@ColumnDefault("0")
	private int qteReserve;

	@OneToMany(mappedBy = "stock")
	List<LigneProduit> lignesProduit;

	@OneToMany(mappedBy = "stock")
	List<LigneCommande> lignesCommande;

	/**
	 * @return the nomProduit
	 */
	public String getNomProduit() {
		return nomProduit;
	}

	/**
	 * @param nomProduit the nomProduit to set
	 */
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	/**
	 * @return the prixProduit
	 */
	public float getPrixProduit() {
		return prixProduit;
	}

	/**
	 * @param prixProduit the prixProduit to set
	 */
	public void setPrixProduit(float prixProduit) {
		this.prixProduit = prixProduit;
	}

	/**
	 * @return the qteProduitDispo
	 */
	public int getQteProduitDispo() {
		return qteProduitDispo;
	}

	/**
	 * @param qteProduitDispo the qteProduitDispo to set
	 */
	public void setQteProduitDispo(int qteProduitDispo) {
		this.qteProduitDispo = qteProduitDispo;
	}

	/**
	 * @return the qteReserve
	 */
	public int getQteReserve() {
		return qteReserve;
	}

	/**
	 * @param qteReserve the qteReserve to set
	 */
	public void setQteReserve(int qteReserve) {
		this.qteReserve = qteReserve;
	}

	/**
	 * @return the lignesProduit
	 */
	public List<LigneProduit> getLignesProduit() {
		return lignesProduit;
	}

	/**
	 * @param lignesProduit the lignesProduit to set
	 */
	public void setLignesProduit(List<LigneProduit> lignesProduit) {
		this.lignesProduit = lignesProduit;
	}

	/**
	 * @return the lignesCommande
	 */
	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	/**
	 * @param lignesCommande the lignesCommande to set
	 */
	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	/**
	 * @return the idStock
	 */
	public Long getIdStock() {
		return idStock;
	}

	@Override
	public String toString() {
		return "Stock [idStock=" + idStock + ", nomProduit=" + nomProduit + ", prixProduit=" + prixProduit
				+ ", qteProduitDispo=" + qteProduitDispo + ", qteReserve=" + qteReserve + ", lignesProduit="
				+ lignesProduit + ", lignesCommande=" + lignesCommande + "]";
	}

}
