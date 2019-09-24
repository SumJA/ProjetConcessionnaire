package net.atos.projetFinal.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.Transient;

/**
 * 
 * @author JB
 * @author Kamal 
 * @author Nils 
 * 
 */
@Entity
@Table(name = "employe")
public class Employe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long idEmploye;

	@Column(length = 100, nullable = false)
	private String nom;

	@Column(length = 100)
	private String email;

	@Column(length = 100, nullable = false)
	private String password;

	@Transient
	private String passwordConfirm;

	@Column(nullable = false)
	private Instant create_time;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Role_idRole", referencedColumnName = "idRole")
    private Role role;
    
	@OneToMany(mappedBy = "employeDevis")
	List<Devis> listeDevis ;
	
	@OneToMany(mappedBy = "clientCommande")
	List<Commande> commande ;



	@OneToMany(mappedBy = "employe", fetch = FetchType.LAZY)
	private List<Devis> devisList;

	@OneToMany(mappedBy = "employe", fetch = FetchType.LAZY)
	private List<Commande> commandes;

	public Employe() {
		super();
		this.create_time = Instant.now();
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the passwordConfirm
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * @param passwordConfirm the passwordConfirm to set
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	/**
	 * @return the create_time
	 */
	public Instant getCreate_time() {
		return create_time;
	}

	/**
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(Instant create_time) {
		this.create_time = create_time;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the listeDevis
	 */
	public List<Devis> getListeDevis() {
		return listeDevis;
	}

	/**
	 * @param listeDevis the listeDevis to set
	 */
	public void setListeDevis(List<Devis> listeDevis) {
		this.listeDevis = listeDevis;
	}

	/**
	 * @return the commandes
	 */
	public List<Commande> getCommande() {
		return commande;
	}

	/**
	 * @param commandes the commandes to set
	 */
	public void setCommande(List<Commande> commande) {
		this.commande = commande;
	}

	/**
	 * @return the idEmploye
	 */
	public Long getIdEmploye() {
		return idEmploye;
	}

	@Override
	public String toString() {
		return "Employe [idEmploye=" + idEmploye + ", nom=" + nom + ", email=" + email + ", password=" + password
				+ ", passwordConfirm=" + passwordConfirm + ", create_time=" + create_time + ", role=" + role
				+ ", listeDevis=" + listeDevis + ", commande=" + commande + "]";
	}
		

}
