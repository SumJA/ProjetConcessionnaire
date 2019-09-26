/**
 * MIT License

Copyright (c) [2019] [Sumaira JAVAID, Nils VO-VAN, Kamel TRABELSI, Jerome BRUNA]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package net.atos.projetFinal.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Description des employés du concessionnaire
 * 
 * @author Jerome BRUNA
 * @author Kamel TRABELSI
 * @author Nils VO-VAN
 * @author Sumaira JAVAID
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