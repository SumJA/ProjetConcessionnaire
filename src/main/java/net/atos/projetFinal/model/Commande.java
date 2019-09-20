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
	private Employe employe ;
	
	/**
	 * Status de la commande
	 */
	@ManyToOne
	@JoinColumn(name = "statut_livraison")
	private Status status ;
	
	/**
	 * Client rattaché à la commande
	 */
	@ManyToOne
	@JoinColumn(name = "client_idCLient")
	private Client client ;
	
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

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employeCde) {
		this.employe = employeCde;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status statusCde) {
		this.status = statusCde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client clientCde) {
		this.client = clientCde;
	}

	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", statusCde=" + status + ", lignesCommande=" + lignesCommande + "]";
	}
}
