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

/**
 * Description de l'entité devis géré par le commercial
 * @author Administrateur
 *
 */
@Entity
@Table(name="devis")
public class Devis implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Id du devis qui pointe sur la clé primaire
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idDevis")
	private Long id ;
	
	/**
	 * Date de création du devis
	 */
	@Column(name="dateCreationDevis")
	private LocalDateTime dateCreation ;
	
	/**
	 * Délai du devis en jours
	 */
	@Column(name="delaiDevis")
	private int delaiDevis ;
	
	/**
	 * Prix HT affiché sur le devis
	 */
	@Column(name ="prixHT")
	private float prixHt ;
	
	/**
	 * Prix TTC affiché sur le devis
	 */
	@Column(name ="prixTTC")
	private float prixTtc ;
	
	/**
	 * Le client du devis
	 */
	@ManyToOne
	@JoinColumn(name="client_idclient")
	private Client client ;
	
	/**
	 * L'employé qui a géré le devis
	 */
	@ManyToOne
	@JoinColumn(name="user_idUser")
	private Employe employe ;
	
	/**
	 * Le status du devis
	 */
	@ManyToOne
	@JoinColumn(name = "status_devis")
	private Status status ;
	
	/**
	 * Les lignes du devis
	 */
	@OneToMany(mappedBy = "devis")
	private List<LigneProduit> lignesProduit ;
	
	public Devis() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public int getDelaiDevis() {
		return delaiDevis;
	}

	public void setDelaiDevis(int delaiDevis) {
		this.delaiDevis = delaiDevis;
	}

	public float getPrixHt() {
		return prixHt;
	}

	public void setPrixHt(float prixHt) {
		this.prixHt = prixHt;
	}

	public float getPrixTtc() {
		return prixTtc;
	}

	public void setPrixTtc(float prixTtc) {
		this.prixTtc = prixTtc;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client clientDevis) {
		this.client = clientDevis;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employeDevis) {
		this.employe = employeDevis;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<LigneProduit> getLignesProduit() {
		return lignesProduit;
	}

	public void setLignesProduit(List<LigneProduit> lignesProduit) {
		this.lignesProduit = lignesProduit;
	}

	@Override
	public String toString() {
		return "Devis [id=" + id + ", dateCreation=" + dateCreation + ", delaiDevis=" + delaiDevis + ", prixHt="
				+ prixHt + ", prixTtc=" + prixTtc + ", status=" + status + ", lignesProduit=" 
				+ lignesProduit + "]";
	}
}
