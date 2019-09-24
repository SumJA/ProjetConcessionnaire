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

/**
 * 
 * @author JB
 * @author Kamal 
 * @author Nils 
 * 
 */

@Entity
@Table(name = "status")
public class Status implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long idStatus;

	@Column(length = 100, nullable = false)
	private String nomStatus;

	@OneToMany(mappedBy = "status")
	List<LigneCommande> lignesCommande;
	
	@OneToMany(mappedBy = "status")
	List<Devis> devis;
	
	@OneToMany(mappedBy = "statusCommande")
	List<Commande> commandes;

	/**
	 * @return the nomStatus
	 */
	public String getNomStatus() {
		return nomStatus;
	}

	/**
	 * @param nomStatus the nomStatus to set
	 */
	public void setNomStatus(String nomStatus) {
		this.nomStatus = nomStatus;
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
	 * @return the devis
	 */
	public List<Devis> getDevis() {
		return devis;
	}

	/**
	 * @param devis the devis to set
	 */
	public void setDevis(List<Devis> devis) {
		this.devis = devis;
	}

	/**
	 * @return the commandes
	 */
	public List<Commande> getCommandes() {
		return commandes;
	}

	/**
	 * @param commandes the commandes to set
	 */
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	/**
	 * @return the idStatus
	 */
	public Long getIdStatus() {
		return idStatus;
	}

	@Override
	public String toString() {
		return "Status [idStatus=" + idStatus + ", nomStatus=" + nomStatus + ", lignesCommande=" + lignesCommande
				+ ", devis=" + devis + ", commandes=" + commandes + "]";
	}
	
}
