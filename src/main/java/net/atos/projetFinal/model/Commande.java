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
 * Désigne la commande gérer par le magasinier
 * @author NVV
 *
 */
@Entity
@Table(name="commande")
public class Commande implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * id de Commande correspond à "idStatus" 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idCommande")
	private Long id ;
	
	/**
	 * Employe qui gère la commande
	 */
	@ManyToOne
	@JoinColumn(name = "employe_idemploye")
	private Employe employeCde ;
	
	/**
	 * Status de la commande
	 */
	@ManyToOne
	@JoinColumn(name = "statut_livraison")
	private Status statusCde ;
	
	/**
	 * Client rattaché à la commande
	 */
	@ManyToOne
	@JoinColumn(name = "client_idCLient")
	private Client clientCde ;
	
	/**
	 * lignes de commande affectée à la commande
	 */
	@OneToMany(mappedBy = "commande")
	List<LigneCommande> lignesCommande ;

	public Commande() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employe getEmployeCde() {
		return employeCde;
	}

	public void setEmployeCde(Employe employeCde) {
		this.employeCde = employeCde;
	}

	public Status getStatusCde() {
		return statusCde;
	}

	public void setStatusCde(Status statusCde) {
		this.statusCde = statusCde;
	}

	public Client getClientCde() {
		return clientCde;
	}

	public void setClientCde(Client clientCde) {
		this.clientCde = clientCde;
	}

	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", employeCde=" + employeCde + ", statusCde=" + statusCde + ", clientCde="
				+ clientCde + ", lignesCommande=" + lignesCommande + "]";
	}
}
