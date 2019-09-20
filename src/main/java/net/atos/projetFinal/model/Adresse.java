/**
 * Adresse d'un client
 */
package net.atos.projetFinal.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Adresse d'un client
 * @author Administrateur
 *
 */
@Entity
@Table(name = "adresse")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Id de l'adresse
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idAdresse", updatable = false, nullable = false)
	private Long id;

	@Column(name = "numeroVoie")
	private int numero;

	@Column(name = "libelleVoie", length = 200)
	private String libelle;

	@Column(name = "complementAdresse", length = 200)
	private String complement;

	@Column(length = 45)
	private String codePostal;

	@Column(length = 100)
	private String ville;

	@Column
	private LocalDateTime dateCreation;

	@Column(name = "dateMiseAJour")
	private Instant dateDerniereMiseAJour;

	@OneToOne(mappedBy = "adresse", cascade = CascadeType.ALL)
	private Client client;

	public Adresse() {
		super();
		this.dateCreation = LocalDateTime.now();
		this.dateDerniereMiseAJour = Instant.now();
	}

	/**
	 * Getters id de Adresse
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the complement
	 */
	public String getComplement() {
		return complement;
	}

	/**
	 * @param complement the complement to set
	 */
	public void setComplement(String complement) {
		this.complement = complement;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
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
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", numero=" + numero + ", libelle=" + libelle + ", complement=" + complement
				+ ", codePostal=" + codePostal + ", ville=" + ville + ", dateCreation=" + dateCreation
				+ ", dateDerniereMiseAJour=" + dateDerniereMiseAJour + ", client=" + client + "]";
	}

}
