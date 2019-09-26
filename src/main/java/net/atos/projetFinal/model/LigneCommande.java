/**
 * MIT License

Copyright (c) [2019] [Sumaira JAVAID, Nils VO-VAN, Kamel TRABELSI, Jerome BRUNA]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
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
 * Description d'une ligne de commande
 * 
 * @author Jerome BRUNA
 * @author Kamel TRABELSI
 * @author Nils VO-VAN
 * @author Sumaira JAVAID
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