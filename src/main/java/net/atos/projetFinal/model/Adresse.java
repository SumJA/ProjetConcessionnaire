/**
 * Adresse d'un client
 */
package net.atos.projetFinal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author JB
 * @author Kamal 
 * @author Nils 
 * 
 */

@Entity
@Table(name = "adresse")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long idAdresse;

	@Column()
	private int numeroVoie;

	@Column(length = 200, nullable = false)
	private String libelleVoie;

	@Column(length = 200)
	private String complementAdresse;

	@Column(length = 45, nullable = false)
	private String codePostal;

	@Column(length = 75, nullable = false)
	private String ville;

	@OneToMany(mappedBy = "adresse")
	List<Client> clients;

	/**
	 * @return the numeroVoie
	 */
	public int getNumeroVoie() {
		return numeroVoie;
	}

	/**
	 * @param numeroVoie the numeroVoie to set
	 */
	public void setNumeroVoie(int numeroVoie) {
		this.numeroVoie = numeroVoie;
	}

	/**
	 * @return the libelleVoie
	 */
	public String getLibelleVoie() {
		return libelleVoie;
	}

	/**
	 * @param libelleVoie the libelleVoie to set
	 */
	public void setLibelleVoie(String libelleVoie) {
		this.libelleVoie = libelleVoie;
	}

	/**
	 * @return the complementAdresse
	 */
	public String getComplementAdresse() {
		return complementAdresse;
	}

	/**
	 * @param complementAdresse the complementAdresse to set
	 */
	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the clients
	 */
	public List<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	/**
	 * @return the idAdresse
	 */
	public Long getIdAdresse() {
		return idAdresse;
	}

	@Override
	public String toString() {
		return "Adresse [idAdresse=" + idAdresse + ", numeroVoie=" + numeroVoie + ", libelleVoie=" + libelleVoie
				+ ", complementAdresse=" + complementAdresse + ", codePostal=" + codePostal + ", ville=" + ville
				+ ", clients=" + clients + "]";
	}
}
