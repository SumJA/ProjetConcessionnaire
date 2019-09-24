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
 * 
 * @author JB
 * @author Kamal 
 * @author Nils 
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
