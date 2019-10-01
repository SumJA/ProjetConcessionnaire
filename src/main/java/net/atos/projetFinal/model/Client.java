package net.atos.projetFinal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Client du Concessionnaire
 * 
 * @author Jerome BRUNA
 * @author Kamel TRABELSI
 * @author Nils VO-VAN
 * @author Sumaira JAVAID
 */
@Entity
@Table(name = "client", uniqueConstraints =
@UniqueConstraint(columnNames = {"nom", "prenom", "numeroTel", "email", "adresse_id"}))
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column(length = 100, nullable = false)
	private String nom;

	@Column(length = 100, nullable = false)
	private String prenom;

	@Column(length = 75, unique = true)
	private String numeroTel;

	@Column(length = 100, nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private LocalDateTime dateCreationClient = LocalDateTime.now();

	@Column(nullable = false)
	private Instant dateDerniereMiseAJourClient = Instant.now();

	@ManyToOne
	@JoinColumn(name = "adresse_id", nullable = false)
	private Adresse adresse;
	
	@OneToMany(mappedBy = "client")
	private Set<Commande> commandes;
	
	@OneToMany(mappedBy = "client")
	private Set<Devis> devis;
	
	/**
	 * Gets dateCreationClient.
	 *
	 * @return Value of dateCreationClient.
	 */
	public LocalDateTime getDateCreationClient() {
		return dateCreationClient;
	}
	
	/**
	 * Sets new dateCreationClient.
	 *
	 * @param dateCreationClient New value of dateCreationClient.
	 */
	public void setDateCreationClient(LocalDateTime dateCreationClient) {
		this.dateCreationClient = dateCreationClient;
	}
	
	/**
	 * Gets id.
	 *
	 * @return Value of id.
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Gets nomClient.
	 *
	 * @return Value of nomClient.
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Sets new nom.
	 *
	 * @param nom New value of nom.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Gets prenomClient.
	 *
	 * @return Value of prenomClient.
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Sets new prenom.
	 *
	 * @param prenom New value of prenom.
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * Gets email.
	 *
	 * @return Value of email.
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets new email.
	 *
	 * @param email New value of email.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets commandes.
	 *
	 * @return Value of commandes.
	 */
	public Set<Commande> getCommandes() {
		return commandes;
	}
	
	/**
	 * Sets new commandes.
	 *
	 * @param commandes New value of commandes.
	 */
	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	
	/**
	 * Gets devis.
	 *
	 * @return Value of devis.
	 */
	public Set<Devis> getDevis() {
		return devis;
	}
	
	/**
	 * Sets new devis.
	 *
	 * @param devis New value of devis.
	 */
	public void setDevis(Set<Devis> devis) {
		this.devis = devis;
	}
	
	/**
	 * Gets dateDerniereMiseAJourClient.
	 *
	 * @return Value of dateDerniereMiseAJourClient.
	 */
	public Instant getDateDerniereMiseAJourClient() {
		return dateDerniereMiseAJourClient;
	}
	
	/**
	 * Sets new dateDerniereMiseAJourClient.
	 *
	 * @param dateDerniereMiseAJourClient New value of dateDerniereMiseAJourClient.
	 */
	public void setDateDerniereMiseAJourClient(Instant dateDerniereMiseAJourClient) {
		this.dateDerniereMiseAJourClient = dateDerniereMiseAJourClient;
	}
	
	/**
	 * Gets numeroTel.
	 *
	 * @return Value of numeroTel.
	 */
	public String getNumeroTel() {
		return numeroTel;
	}
	
	/**
	 * Sets new numeroTelClient.
	 *
	 * @param numeroTel New value of numeroTelClient.
	 */
	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	
	/**
	 * Gets adresse.
	 *
	 * @return Value of adresse.
	 */
	public Adresse getAdresse() {
		return adresse;
	}
	
	/**
	 * Sets new adresse.
	 *
	 * @param adresse New value of adresse.
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	@Override
	public String toString() {
		return "Client [idClient=" + id + ", nomClient=" + nom + ", prenomClient=" + prenom
				+ ", numeroTelClient=" + numeroTel + ", adresseMail=" + email + ", dateCreationClient="
				+ dateCreationClient + ", dateDerniereMiseAJourClient=" + dateDerniereMiseAJourClient + ", adresse="
				+ adresse + "]";
	}
}