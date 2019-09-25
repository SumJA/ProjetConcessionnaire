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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Commande d'un stock
 * 
 * @author Jerome BRUNA
 * @author Kamel TRABELSI
 * @author Nils VO-VAN
 * @author Sumaira JAVAID
 * 
 */
@Entity
@Table(name="commande")
public class Commande implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = true)
	private Long idCommande ;
	
	@ManyToOne
	@JoinColumn(name = "employe_idEmploye")
	private Employe employeCommande ;
	
	@ManyToOne
	@JoinColumn(name = "statut_livraison")
	private Status statusCommande ;
	
	@ManyToOne
	@JoinColumn(name = "client_idCLient")
	private Client clientCommande;
	
	@OneToMany(mappedBy = "commande")
	List<LigneCommande> lignesCommande;

	/**
	 * @return the employeCommande
	 */
	public Employe getEmployeCommande() {
		return employeCommande;
	}

	/**
	 * @param employeCommande the employeCommande to set
	 */
	public void setEmployeCommande(Employe employeCommande) {
		this.employeCommande = employeCommande;
	}

	/**
	 * @return the statusCommande
	 */
	public Status getStatusCommande() {
		return statusCommande;
	}

	/**
	 * @param statusCommande the statusCommande to set
	 */
	public void setStatusCommande(Status statusCommande) {
		this.statusCommande = statusCommande;
	}

	/**
	 * @return the clientCommande
	 */
	public Client getClientCommande() {
		return clientCommande;
	}

	/**
	 * @param clientCommande the clientCommande to set
	 */
	public void setClientCommande(Client clientCommande) {
		this.clientCommande = clientCommande;
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
	 * @return the idCommande
	 */
	public Long getIdCommande() {
		return idCommande;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", employeCommande=" + employeCommande + ", statusCommande="
				+ statusCommande + ", clientCommande=" + clientCommande + ", lignesCommande=" + lignesCommande + "]";
	}

}