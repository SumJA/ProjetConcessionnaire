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
 * Description du Stock de voiture
 * 
 * @author Jerome BRUNA
 * @author Kamel TRABELSI
 * @author Nils VO-VAN
 * @author Sumaira JAVAID
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