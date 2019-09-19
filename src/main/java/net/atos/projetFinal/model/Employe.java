package net.atos.projetFinal.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Description de la classe employe qui font partie du concessionnaire
 * Pointe sur la table employe
 * @author NVV
 *
 */
@Entity
@Table(name = "employe")
public class Employe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id qui point sur la primary key de la table role qui est programmée en auto incremental
	 */
	@Id
	@Column(name="idClient")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	
	/**
	 * Nom de l'employé qui point sur la colonne username de la table
	 */
	@Column(name="username", length = 16)
	private String nom ;
	
	/**
	 * Email de l'employé
	 */
	@Column(length = 255)
	private String email ;
	
	/**
	 * Mot de passe de l'employé lui permettant de s'identifier
	 */
	@Column(length = 32)
	private String password ;
	
	/**
	 * Date de création du profil
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createTime ;
	
	/**
	 * Role provenant de la table "role" via la foreign key
	 */
	@OneToOne
	@JoinColumn(name="Role_idRole")
	private Role role ;

	
	/**
	 * Constructeur vide : initialise createTime à la date du moment
	 */
	public Employe() {
		super();
		
		/* Date de creation du profil par default : la date d'aujourd'hui */
		createTime = LocalDateTime.now() ;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
