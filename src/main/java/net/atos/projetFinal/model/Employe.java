package net.atos.projetFinal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

/**
 * Description des employés du concessionnaire
 * 
 */
@Entity
@Table(name = "employe", uniqueConstraints =
@UniqueConstraint(columnNames = {"nom", "prenom", "username", "email"}))
public class Employe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
    private Long id;

	@Column(length = 100, nullable = false)
	private String nom;
    
    @Column(length = 100, nullable = false)
    private String prenom;
    
    @Column(length = 100, nullable = false, unique = true)
    private String username;
    
    @Column(length = 100, nullable = false, unique = true)
	private String email;

	@Column(length = 100, nullable = false)
	private String password;

	@Transient
	private String passwordConfirm;

	@Column(nullable = false)
    private Instant create_time = Instant.now();
    
    @ManyToOne
    @JoinColumn(name = "Role_id", nullable = false)
    private Role role;
    
    @OneToMany(mappedBy = "employe")
    private Set<Devis> listeDevis;
    
    @OneToMany(mappedBy = "employe")
    private Set<Commande> commande;
    
    /**
     * Gets passwordConfirm.
     *
     * @return Value of passwordConfirm.
     */
    public String getPasswordConfirm() {
        return passwordConfirm;
    }
    
    /**
     * Sets new passwordConfirm.
     *
     * @param passwordConfirm New value of passwordConfirm.
     */
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    
    /**
     * Gets role.
     *
     * @return Value of role.
     */
    public Role getRole() {
        return role;
    }
    
    /**
     * Sets new role.
     *
     * @param role New value of role.
     */
    public void setRole(Role role) {
        this.role = role;
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
     * Gets create_time.
     *
     * @return Value of create_time.
     */
    public Instant getCreate_time() {
        return create_time;
    }
    
    /**
     * Sets new create_time.
     *
     * @param create_time New value of create_time.
     */
    public void setCreate_time(Instant create_time) {
        this.create_time = create_time;
    }
    
    /**
	 * Gets nom.
     *
     * @return Value of nom.
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
     * Gets password.
     *
     * @return Value of password.
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Sets new password.
     *
     * @param password New value of password.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Gets prenom.
     *
     * @return Value of prenom.
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
     * Gets commande.
     *
     * @return Value of commande.
     */
    public Set<Commande> getCommande() {
        return commande;
    }
    
    /**
     * Sets new commande.
     *
     * @param commande New value of commande.
     */
    public void setCommande(Set<Commande> commande) {
		this.commande = commande;
    }
    
    /**
     * Gets listeDevis.
     *
     * @return Value of listeDevis.
     */
    public Set<Devis> getListeDevis() {
        return listeDevis;
	}
	
	/**
	 * Sets new listeDevis.
     *
     * @param listeDevis New value of listeDevis.
     */
    public void setListeDevis(Set<Devis> listeDevis) {
		this.listeDevis = listeDevis;
    }
    
    /**
     * Gets username.
     *
     * @return Value of username.
     */
    public String getUsername() {
        return username;
    }
    
    /**
	 * Sets new username.
	 *
	 * @param username New value of username.
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
				", passwordConfirm='" + passwordConfirm + '\'' +
				", create_time=" + create_time +
				", role=" + role +
				'}';
	}
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return nom.equals(employe.nom) &&
                prenom.equals(employe.prenom) &&
                username.equals(employe.username) &&
                email.equals(employe.email) &&
                role.equals(employe.role);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, username, email, role);
    }
    
    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(Long id) {
        this.id = id;
    }
}