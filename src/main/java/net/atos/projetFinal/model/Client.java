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
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Client du Concessionnaire
 * 
 * @author Jerome BRUNA
 * @author Kamel TRABELSI
 * @author Nils VO-VAN
 * @author Sumaira JAVAID
 * 
 */

@Entity
@Table(name = "client")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long idClient;

	@Column(length = 100, nullable = false)
	private String nomClient;

	@Column(length = 100, nullable = false)
	private String prenomClient;

	@Column(length = 75, unique = true)
	private String numeroTelClient;

	@Column(length = 100, nullable = false, unique = true)
	private String adresseMail;

	@Column(nullable = false)
	private LocalDateTime dateCreationClient;

	@Column(nullable = false)
	private Instant dateDerniereMiseAJourClient;

	@ManyToOne
	@JoinColumn(name = "adresse_idAdresse")
	private Adresse adresse;

	@OneToMany(mappedBy = "clientCommande")
	List<Commande> commandes;

	@OneToMany(mappedBy = "clientDevis")
	List<Devis> devis;
	public Client() {
		super();
		
		dateCreationClient = LocalDateTime.now() ;
		dateDerniereMiseAJourClient = Instant.now();
	}

	/**
	 * @return the nomClient
	 */
	public String getNomClient() {
		return nomClient;
	}

	/**
	 * @param nomClient the nomClient to set
	 */
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	/**
	 * @return the prenomClient
	 */
	public String getPrenomClient() {
		return prenomClient;
	}

	/**
	 * @param prenomClient the prenomClient to set
	 */
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	/**
	 * @return the numeroTelClient
	 */
	public String getNumeroTelClient() {
		return numeroTelClient;
	}

	/**
	 * @param numeroTelClient the numeroTelClient to set
	 */
	public void setNumeroTelClient(String numeroTelClient) {
		this.numeroTelClient = numeroTelClient;
	}

	/**
	 * @return the adresseMail
	 */
	public String getAdresseMail() {
		return adresseMail;
	}

	/**
	 * @param adresseMail the adresseMail to set
	 */
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	/**
	 * @return the dateCreationClient
	 */
	public LocalDateTime getDateCreationClient() {
		return dateCreationClient;
	}

	/**
	 * @param dateCreationClient the dateCreationClient to set
	 */
	public void setDateCreationClient(LocalDateTime dateCreationClient) {
		this.dateCreationClient = dateCreationClient;
	}

	/**
	 * @return the dateDerniereMiseAJourClient
	 */
	public Instant getDateDerniereMiseAJourClient() {
		return dateDerniereMiseAJourClient;
	}

	/**
	 * @param dateDerniereMiseAJourClient the dateDerniereMiseAJourClient to set
	 */
	public void setDateDerniereMiseAJourClient(Instant dateDerniereMiseAJourClient) {
		this.dateDerniereMiseAJourClient = dateDerniereMiseAJourClient;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the commandes
	 */
	public List<Commande> getCommandes() {
		return commandes;
	}

	/**
	 * @param commandes the commandes to set
	 */
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	/**
	 * @return the devis
	 */
	public List<Devis> getDevis() {
		return devis;
	}

	/**
	 * @param devis the devis to set
	 */
	public void setDevis(List<Devis> devis) {
		this.devis = devis;
	}

	/**
	 * @return the idClient
	 */
	public Long getIdClient() {
		return idClient;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
				+ ", numeroTelClient=" + numeroTelClient + ", adresseMail=" + adresseMail + ", dateCreationClient="
				+ dateCreationClient + ", dateDerniereMiseAJourClient=" + dateDerniereMiseAJourClient + ", adresse="
				+ adresse + ", commandes=" + commandes + ", devis=" + devis + "]";
	}

}