package net.atos.projetFinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author JB
 * @author Kamal 
 * @author Nils 
 * 
 */

@Entity
@Table(name = "role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long idRole;

	@Column(length = 100, unique = true)
	private String nomRole;
	
	@OneToOne(mappedBy = "role")
	private Employe employe;

	/**
	 * @return the nomRole
	 */
	public String getNomRole() {
		return nomRole;
	}

	/**
	 * @param nomRole the nomRole to set
	 */
	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

	/**
	 * @return the employe
	 */
	public Employe getEmploye() {
		return employe;
	}

	/**
	 * @param employe the employe to set
	 */
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	/**
	 * @return the idRole
	 */
	public Long getIdRole() {
		return idRole;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", nomRole=" + nomRole + ", employe=" + employe + "]";
	}
	
}
