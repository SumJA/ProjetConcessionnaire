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
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
<<<<<<< HEAD
 * Adresse d'un client
 * 
 * @author Jerome BRUNA
 * @author Kamel TRABELSI
 * @author Nils VO-VAN
 * @author Sumaira JAVAID
=======
 * 
 * @author JB
 * @author Kamal 
 * @author Nils 
>>>>>>> add setId for client and adresse + add equals and hashCode for adresse + Update from master
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

	/**
	 * hashCode with all attributes except idAdresse
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
		result = prime * result + ((complementAdresse == null) ? 0 : complementAdresse.hashCode());
		result = prime * result + ((idAdresse == null) ? 0 : idAdresse.hashCode());
		result = prime * result + ((libelleVoie == null) ? 0 : libelleVoie.hashCode());
		result = prime * result + numeroVoie;
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		return result;
	}

	/**
	 * Equals method with all attributes except for the following attributes id,
	 * dateCreation, dateDerniereMiseAJour and clients
	 * equals method with all attributes except for idAdresse
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		if (codePostal == null) {
			if (other.codePostal != null)
				return false;
		} else if (!codePostal.equals(other.codePostal))
			return false;
		if (complementAdresse == null) {
			if (other.complementAdresse != null)
				return false;
		} else if (!complementAdresse.equals(other.complementAdresse))
			return false;
		if (idAdresse == null) {
			if (other.idAdresse != null)
				return false;
		} else if (!idAdresse.equals(other.idAdresse))
			return false;
		if (libelleVoie == null) {
			if (other.libelleVoie != null)
				return false;
		} else if (!libelleVoie.equals(other.libelleVoie))
			return false;
		if (numeroVoie != other.numeroVoie)
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Adresse [idAdresse=" + idAdresse + ", numeroVoie=" + numeroVoie + ", libelleVoie=" + libelleVoie
				+ ", complementAdresse=" + complementAdresse + ", codePostal=" + codePostal + ", ville=" + ville
				+ "]";
	}
}