/**
 * Client du Concessionnaire
 */
package net.atos.projetFinal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author kamel
 *
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idClient", updatable = false, nullable = false)
	private Long id;

	/**
	 * Nom du client
	 */
	@Column(name = "nomClient", length = 100)
	private String nom;

	/**
	 * Prénom du client
	 */
	@Column(name = "prenomClient", length = 100)
	private String prenom;

	@Column(name = "telephone", length = 75)
	private String numeroTelClient;

	@Column(length = 100)
	private String adresseMail;

	@OneToOne
	@JoinColumn(name="adresse_idadresse")
	private Adresse adresse;
	

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	List<Commande> commades ;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	List<Devis> devis ;

	public Client() {
		super();
	}

	/**
	 * 
	 * @return Liste des commandes auxquelles le client est affecté
	 */
	public List<Commande> getCommades() {
		return commades;
	}

	/**
	 * 
	 * @param commades : la liste des commandes auxquelles le cleint doit être affecté
	 */
	public void setCommades(List<Commande> commades) {
		this.commades = commades;
	}

	/**
	 * 
	 * @return Liste des devis auxquelles le client est affecté
	 */
	public List<Devis> getDevis() {
		return devis;
	}

	/**
	 * 
	 * @param commades : la liste des devis auxquelles le cleint doit être affecté
	 */
	public void setDevis(List<Devis> devis) {
		this.devis = devis;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the numeroTelClient
	 */
	public String getNumeroTelClient() {
		return numeroTelClient;
	}

	/**
	 * @param numeroTelClient the numeroTelClient to set
	 */
	public void setNumeroTelClient(String numeroTelClient) {
		this.numeroTelClient = numeroTelClient;
	}

	/**
	 * @return the adresseMail
	 */
	public String getAdresseMail() {
		return adresseMail;
	}

	/**
	 * @param adresseMail the adresseMail to set
	 */
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numeroTelClient=" + numeroTelClient
				+ ", adresseMail=" + adresseMail + ", adresse=" + adresse + ", commades=" + commades + ", devis="
				+ devis + "]";
	}


}
