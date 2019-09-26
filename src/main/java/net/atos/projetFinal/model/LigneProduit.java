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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Description d'une ligne de produit
 * 
 * @author Jerome BRUNA
 * @author Kamel TRABELSI
 * @author Nils VO-VAN
 * @author Sumaira JAVAID
 * 
 */
@Entity
@Table(name = "ligneProduit")
public class LigneProduit implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLigneProduit")
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