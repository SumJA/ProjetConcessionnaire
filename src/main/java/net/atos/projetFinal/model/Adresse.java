package net.atos.projetFinal.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adresse")
public class Adresse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idadresse")
	private Long id;

	private int numero;

	@Column(length = 200)
	private String libelle;

	@Column(length = 200)
	private String complement;

	private LocalDateTime dateCreation;

	private LocalDateTime dateDerniereMiseAJour;

	/**
	 * attribut codepostal 45 caractères correspond à codepostal dans la Bdd
	 */
	@Column(name = "codePostal", length = 45)
	private String codePostal;

	@Column(length = 75)
	private String ville;

	@OneToOne(mappedBy = "adresse", cascade = CascadeType.ALL)
	private Client client;

	public Adresse() {
		super();
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
	 * Setter id de Adresse
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLibelleVoie() {
		return libelle;
	}

	public void setLibelleVoie(String libelleVoie) {
		this.libelle = libelleVoie;
	}

	public String getComplementAdresse() {
		return complement;
	}

	public void setComplementAdresse(String complementAdresse) {
		this.complement = complementAdresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public LocalDateTime getDateDerniereMiseAJour() {
		return dateDerniereMiseAJour;
	}

	public void setDateDerniereMiseAJour(LocalDateTime dateDerniereMiseAJour) {
		this.dateDerniereMiseAJour = dateDerniereMiseAJour;
	}

}
