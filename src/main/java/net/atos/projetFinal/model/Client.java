package net.atos.projetFinal.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;




/**
 * Entity Client
 * attribut en private, getter/setter en public
 * implémentation de Serializable
 * constructeur par défaut
 * correspond à la table "client" dans la Bdd
 * @author kamel
 *
 */
@Entity
@Table(name="client")
public class Client {
	
	
	
	/**
	 * serial version id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * attribut id de Client
	 * généré en "AUTO" (strategy = GenerationType.AUTO)
	 * correspond à idClient dans la Bdd
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idClient")
	private Long id;
	
	@Column(name="nomClient", length = 100)
	private String nom;
	
	@Column(name="prenomClient", length = 100)
	private String prenom;
	
	/**
	 * attribut numeroTelClient
	 * le nom de l'attribut est le même que celui de la Bdd
	 */
	@Column(length = 75)
	private String numeroTelClient;
	
	/**
	 * attribut adresseMail
	 * le nom de l'attribut est le même que celui de la Bdd
	 */
	@Column(length = 75)
	private String adresseMail;
	
	/**
	 * attribut adresse
	 * annoté en OneToOne
	 */
	@OneToOne
	@MapsId
	private Adresse adresse;
	
	
	/**
	 * constructeur par défaut
	 */
	public Client() {
		super();
	}

	

	/**
	 * Getter de id de Client
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter de id de Client
	 * @return
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter de nom de Client
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter de nom de Client
	 * @return
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter de prenom de Client
	 * @return
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter de prenom de Client
	 * @return
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter de numeroTelClient de Client
	 * @return
	 */
	public String getNumeroTelClient() {
		return telephone;
	}

	/**
	 * Setter de numeroTelClient de Client
	 * @return
	 */
	public void setNumeroTelClient(String numeroTelClient) {
		this.telephone = numeroTelClient;
	}

	/**
	 * Getter de adresseMail de Client
	 * @return
	 */
	public String getAdresseMail() {
		return email;
	}

	/**
	 * Setter de adresseMail de Client
	 * @return
	 */
	public void setAdresseMail(String adresseMail) {
		this.email = adresseMail;
	}



	/**
	 * Getter de adresse de Client
	 * @return
	 */
	public Adresse getAdresse() {
		return adresse;
	}



	/**
	 * Setter de adresse de Client
	 * @return
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	
	
	
	
	
	
	

}
