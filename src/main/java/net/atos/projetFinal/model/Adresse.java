package net.atos.projetFinal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="adresse")
public class Adresse {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idadresse")
	private int id;
	
	private int numero;
	
	@Column(length = 200)
	private String libelleVoie;
	
	@Column(length = 200)
	private String complementAdresse;
	
	@Column(length = 45)
	private String codePostal;
	
	@Column(length = 75)
	private String ville;
	
	
	@OneToOne(mappedBy = "adresse", cascade = CascadeType.ALL)
	private Client client;

	public Adresse() {
		super();
	}

	public Adresse(int id, int numero, String libelleVoie, String complementAdresse, String codePostal, String ville,
			Client client) {
		super();
		this.id = id;
		this.numero = numero;
		this.libelleVoie = libelleVoie;
		this.complementAdresse = complementAdresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLibelleVoie() {
		return libelleVoie;
	}

	public void setLibelleVoie(String libelleVoie) {
		this.libelleVoie = libelleVoie;
	}

	public String getComplementAdresse() {
		return complementAdresse;
	}

	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
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
	
	
	
	
	
	

}
