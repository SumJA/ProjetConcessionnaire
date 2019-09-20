package net.atos.projetFinal.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Description de la classe employe qui font partie du concessionnaire
 * 
 * @author NVV
 *
 */
@Entity
@Table(name = "employe")
public class Employe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idEmploye", updatable = false, nullable = false)
	private Long id;

	@Column(name = "username", length = 100)
	private String nom;

	@Column(length = 255)
	private String email;

	@Column(length = 32)
	private String password;

	@Transient
	private String passwordConfirm;

	@Basic
	private LocalDateTime createTime;

	@ManyToOne
	@JoinColumn(name = "Role_idRole")
	private Role role;


	@OneToMany(mappedBy = "employe", fetch = FetchType.LAZY)
	private List<Devis> devisList;

	@OneToMany(mappedBy = "employe", fetch = FetchType.LAZY)
	private List<Commande> commandes;

	public Employe() {
		super();
		// Date de creation du profil par default : la date d'aujourd'hui
		this.createTime = LocalDateTime.now();
	}

	/**
	 * 
	 * @return la liste des devis que l'employé a et est en train de géré
	 */
	public List<Devis> getDevisList() {
		return devisList;
	}

	/**
	 * 
	 * @param devisList : la liste des devis que l'employé a et est en train de géré à setter
	 */
	public void setDevisList(List<Devis> devisList) {
		this.devisList = devisList;
	}

	/**
	 * 
	 * @return la liste des commandes que l'employé a et est en train de géré
	 */
	public List<Commande> getCommandes() {
		return commandes;
	}

	/**
	 * 
	 * @param commandes : la liste des commandes que l'employé a et est en train de géré à setter
	 */
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
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
	 * @return the createTime
	 */
	public LocalDateTime getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
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

	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", email=" + email + ", password=" + password + ", createTime="
				+ createTime + ", role=" + role + "]";
	}

}
