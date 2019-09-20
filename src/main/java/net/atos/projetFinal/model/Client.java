/**
 * Client du Concessionnaire
 */
package net.atos.projetFinal.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	@Column(length = 75)
	private String numeroTelClient;

	@Column(length = 100)
	private String adresseMail;

	@Column
	private LocalDateTime dateCreation;

	@Column(name = "dateMiseAJour")
	private Instant dateDerniereMiseAJour;

	@OneToOne
	@JoinColumn(name="adresse_idadresse")
	private Adresse adresse;

	public Client() {
		super();
	}

	/**
	 * @return the dateCreation
	 */
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * @return the dateDerniereMiseAJour
	 */
	public Instant getDateDerniereMiseAJour() {
		return dateDerniereMiseAJour;
	}

	/**
	 * @param dateDerniereMiseAJour the dateDerniereMiseAJour to set
	 */
	public void setDateDerniereMiseAJour(Instant dateDerniereMiseAJour) {
		this.dateDerniereMiseAJour = dateDerniereMiseAJour;
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
				+ ", adresseMail=" + adresseMail + ", dateCreation=" + dateCreation + ", dateDerniereMiseAJour="
				+ dateDerniereMiseAJour + ", adresse=" + adresse + "]";
	}

}
