package net.atos.projetFinal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Gère un status
 * 
 * @author kamel
 *
 */
@Entity
@Table(name = "status")
public class Status implements Serializable {

	/**
	 * serial version id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id de status correspond à "idStatus" dans la Bdd généré avec "AUTO"
	 * (@GeneratedValue(strategy = GenerationType.AUTO)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idStatus")
	private Long id;

	/**
	 * Nom du status identifé par la colone nomStatus
	 */
	@Column(name = "nomStatus", length = 100)
	private String nom;
	
	@OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
	List<LigneCommande> lignesCommande ;
	
	@OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
	List<Commande> commandes ;
	
	@OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
	List<Devis> devisList ;
	
	/**
	 * Constructeur par défaut
	 */
	public Status() {
		super();
	}

	/**
	 * 
	 * @return Les lignes de commandes ayant ce status
	 */
	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	/**
	 * 
	 * @param lignesCommande lignes de commandes à setter avec ce status
	 */
	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	/**
	 * 
	 * @return toutes les commandes qui ont ce status
	 */
	public List<Commande> getCommandes() {
		return commandes;
	}

	/**
	 * 
	 * @param commandes : commandes à setter avec ce status
	 */
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	/**
	 * 
	 * @return la liste de devis qui ont ce status
	 */
	public List<Devis> getDevisList() {
		return devisList;
	}

	/**
	 * 
	 * @param devisList : la liste de devis qui devrait être setter à ce status
	 */
	public void setDevisList(List<Devis> devisList) {
		this.devisList = devisList;
	}

	/**
	 * 
	 * @return l'id du status
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param id : la nouvelle valeur de l'id souhaitée
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return le nom du status
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * 
	 * @param nomStatus : le nom du status souhaité
	 */
	public void setNom(String nomStatus) {
		this.nom = nomStatus;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", nom=" + nom + "]";
	}
}
