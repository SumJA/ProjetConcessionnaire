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
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

/**
 * Description de l'entité devis géré par le commercial
 * 
 * @author Jerome BRUNA
 * @author Kamel TRABELSI
 * @author Nils VO-VAN
 * @author Sumaira JAVAID
 *
 */
@Entity
@Table(name = "devis")
public class Devis implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long idDevis ;
	
	@Column(nullable = false)
	private LocalDateTime dateCreationDevis ;
	
	@Column(nullable = false)
	private int delaiDevis ;
	
	@Column(nullable = false)
	@ColumnDefault("0")
	private float prixHT ;
	
	@Column(nullable = false)
	@ColumnDefault("0")
	private float prixTTC ;
	
	@ManyToOne
	@JoinColumn(name="client_idclient")
	private Client clientDevis ;
	
	@ManyToOne
	@JoinColumn(name="user_idUser")
	private Employe employeDevis ;
	
	@ManyToOne
	@JoinColumn(name = "status_devis")
	private Status status ;
	
	@OneToMany(mappedBy = "devis")
	private List<LigneProduit> lignesProduit ;

	/**
	 * @return the dateCreationDevis
	 */
	public LocalDateTime getDateCreationDevis() {
		return dateCreationDevis;
	}

	/**
	 * @param dateCreationDevis the dateCreationDevis to set
	 */
	public void setDateCreationDevis(LocalDateTime dateCreationDevis) {
		this.dateCreationDevis = dateCreationDevis;
	}

	/**
	 * @return the delaiDevis
	 */
	public int getDelaiDevis() {
		return delaiDevis;
	}

	/**
	 * @param delaiDevis the delaiDevis to set
	 */
	public void setDelaiDevis(int delaiDevis) {
		this.delaiDevis = delaiDevis;
	}

	/**
	 * @return the prixHT
	 */
	public float getPrixHT() {
		return prixHT;
	}

	/**
	 * @param prixHT the prixHT to set
	 */
	public void setPrixHT(float prixHT) {
		this.prixHT = prixHT;
	}

	/**
	 * @return the prixTTC
	 */
	public float getPrixTTC() {
		return prixTTC;
	}

	/**
	 * @param prixTTC the prixTTC to set
	 */
	public void setPrixTTC(float prixTTC) {
		this.prixTTC = prixTTC;
	}

	/**
	 * @return the clientDevis
	 */
	public Client getClientDevis() {
		return clientDevis;
	}

	/**
	 * @param clientDevis the clientDevis to set
	 */
	public void setClientDevis(Client clientDevis) {
		this.clientDevis = clientDevis;
	}

	/**
	 * @return the employeDevis
	 */
	public Employe getEmployeDevis() {
		return employeDevis;
	}

	/**
	 * @param employeDevis the employeDevis to set
	 */
	public void setEmployeDevis(Employe employeDevis) {
		this.employeDevis = employeDevis;
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
	 * @return the idDevis
	 */
	public Long getIdDevis() {
		return idDevis;
	}

	@Override
	public String toString() {
		return "Devis [idDevis=" + idDevis + ", dateCreationDevis=" + dateCreationDevis + ", delaiDevis=" + delaiDevis
				+ ", prixHT=" + prixHT + ", prixTTC=" + prixTTC + ", clientDevis=" + clientDevis + ", employeDevis="
				+ employeDevis + ", status=" + status + ", lignesProduit=" + lignesProduit + "]";
	}
	
}
