package net.atos.projetFinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Gère un status
 * 
 * @author kamel
 *
 */
@Entity
@Table(name = "status")
public class Status implements Serializable {

	/**
	 * serial version id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id de status correspond à "idStatus" dans la Bdd généré avec "AUTO"
	 * (@GeneratedValue(strategy = GenerationType.AUTO)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idStatus")
	private Long id;

	@Column(length = 100)
	private String nomStatus;
	
	

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
	 * @return the nomStatus
	 */
	public String getNomStatus() {
		return nomStatus;
	}

	/**
	 * @param nomStatus the nomStatus to set
	 */
	public void setNomStatus(String nomStatus) {
		this.nomStatus = nomStatus;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", nomStatus=" + nomStatus + "]";
	}

}
