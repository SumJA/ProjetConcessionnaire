package net.atos.projetFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table
public class Client {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idClient")
	private int id;
	
	@Column(name="nomClient")
	private String nom;
	
	@Column(name="prenomClient")
	private String prenom;
	
	@Column
	private String numeroTelClient;
	
	@Column
	private String adresseMail;
	
	@OneToOne
	private Adresse adresse;
	
	
	
	public Client() {
		super();
	}

	
	
	public Client(int id, String nom, String prenom, String numeroTelClient, String adresseMail) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numeroTelClient = numeroTelClient;
		this.adresseMail = adresseMail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumeroTelClient() {
		return numeroTelClient;
	}

	public void setNumeroTelClient(String numeroTelClient) {
		this.numeroTelClient = numeroTelClient;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}



	public Adresse getAdresse() {
		return adresse;
	}



	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	
	
	
	
	
	
	

}
