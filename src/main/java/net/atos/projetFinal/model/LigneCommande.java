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

import org.hibernate.annotations.ColumnDefault;

/**
 * 
 * @author JB
 * @author Kamal 
 * @author Nils 
 * 
 */
@Entity
@Table(name = "ligneCommande")
public class LigneCommande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long idLigneCommande;

	@Column(nullable = false)
	private int delaiLivraison;

	@Column(nullable = false)
	@ColumnDefault("1")
	private int qteCommande;

	@ManyToOne
	@JoinColumn(name = "commande_idCommande")
	private Commande commande;

	@ManyToOne
	@JoinColumn(name = "stock_idStock")
	private Stock stock;

	@ManyToOne
	@JoinColumn(name = "status_idStatus")
	private Status status;

	@Column(nullable = false)
	private LocalDateTime dateCreationLigneCommande;

	/**
	 * @return the delaiLivraison
	 */
	public int getDelaiLivraison() {
		return delaiLivraison;
	}

	/**
	 * @param delaiLivraison the delaiLivraison to set
	 */
	public void setDelaiLivraison(int delaiLivraison) {
		this.delaiLivraison = delaiLivraison;
	}

	/**
	 * @return the qteCommande
	 */
	public int getQteCommande() {
		return qteCommande;
	}

	/**
	 * @param qteCommande the qteCommande to set
	 */
	public void setQteCommande(int qteCommande) {
		this.qteCommande = qteCommande;
	}

	/**
	 * @return the commande
	 */
	public Commande getCommande() {
		return commande;
	}

	/**
	 * @param commande the commande to set
	 */
	public void setCommande(Commande commande) {
		this.commande = commande;
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
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the dateCreationLigneCommande
	 */
	public LocalDateTime getDateCreationLigneCommande() {
		return dateCreationLigneCommande;
	}

	/**
	 * @param dateCreationLigneCommande the dateCreationLigneCommande to set
	 */
	public void setDateCreationLigneCommande(LocalDateTime dateCreationLigneCommande) {
		this.dateCreationLigneCommande = dateCreationLigneCommande;
	}

	/**
	 * @return the idLigneCommande
	 */
	public Long getIdLigneCommande() {
		return idLigneCommande;
	}

	@Override
	public String toString() {
		return "LigneCommande [idLigneCommande=" + idLigneCommande + ", delaiLivraison=" + delaiLivraison
				+ ", qteCommande=" + qteCommande + ", commande=" + commande + ", stock=" + stock + ", status=" + status
				+ ", dateCreationLigneCommande=" + dateCreationLigneCommande + "]";
	}

}
