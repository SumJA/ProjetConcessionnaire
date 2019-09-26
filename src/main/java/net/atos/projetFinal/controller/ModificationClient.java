package net.atos.projetFinal.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.model.Client;
import net.atos.projetFinal.service.IAdresseService;

/**
 * 
 * @author Nils VO-VAN
 *
 */
public class ModificationClient {
	
	private Long idClient ;
	
	private Long idAdresse ;
	
	private boolean checked ;
	
	@NotEmpty
	private String prenom ;

	@NotEmpty
	private String nom ;

	@NotEmpty
	private String libelle ;

	
	private int numeroAdresse ;

	private String complementAdresse ;

	@NotEmpty
	private String codePostal ;

	@NotEmpty
	private String ville ;

	@NotEmpty
	private String tel ;

	@NotEmpty
	private String mail ;

	@NotEmpty
	private String dateCreation ;

	@NotEmpty
	private String dateDerniereMiseAJour ;
	

	/**
	 * Update the ModificationClient attribute according to client
	 * @param client : the client that gets the different attributes value
	 * @param expectedDateFormat : the expected date format (how the date have to appeared)
	 */
	public void insertClientIntoModif(Client client, String expectedDateFormat) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(expectedDateFormat) ;
		
		idClient = client.getIdClient() ;
		prenom = client.getPrenomClient() ;
		nom = client.getNomClient() ;
		tel = client.getNumeroTelClient() ;
		mail = client.getAdresseMail() ;
		dateCreation = dateFormat.format(Date.from(client.getDateCreationClient().atZone(ZoneId.systemDefault()).toInstant())) ;
		dateDerniereMiseAJour = client.getDateDerniereMiseAJourClient().toString() ;
		
		libelle = client.getAdresse().getLibelleVoie() ;
		codePostal = client.getAdresse().getCodePostal() ;
		ville = client.getAdresse().getVille() ;
		idAdresse = client.getAdresse().getIdAdresse() ;
		numeroAdresse = client.getAdresse().getNumeroVoie() ;
		complementAdresse = client.getAdresse().getComplementAdresse() ;
		
		checked = false ;
	}
	
	/**
	 * get the client with the right attributes according to the actual ModificationClient
	 * @param expectedDateFormat : the expected date format (how the date have to appeared)
	 * @param clientToUpdate client that has to be modified
	 * @return the Client object with the updated attributes (clone)
	 * @throws ParseException : exception thrown when the date is not at the expected format
	 * @throws IllegalArgumentException 
	 * @throws NoSuchFieldException 
	 */
	public Client getClientFromModif(Client clientToUpdate, IAdresseService serviceAdresse, String expectedDateFormat) throws ParseException, NoSuchFieldException, IllegalArgumentException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(expectedDateFormat) ;
		Adresse adresseToUpdateCloned = clientToUpdate.getAdresse().clone();
		Adresse adresseAJour ;	
		
		adresseToUpdateCloned.setLibelleVoie(libelle);
		adresseToUpdateCloned.setCodePostal(codePostal);
		adresseToUpdateCloned.setVille(ville);
		adresseToUpdateCloned.setNumeroVoie(numeroAdresse);
		adresseToUpdateCloned.setComplementAdresse(complementAdresse);

		adresseAJour = serviceAdresse.modifierAdresse(adresseToUpdateCloned);	
		clientToUpdate.setAdresse(adresseAJour);
		
		clientToUpdate.setDateCreationClient(LocalDateTime.ofInstant(dateFormat.parse(dateCreation).toInstant(), ZoneId.systemDefault()));
		/* Je considère que le client vient d'être mis à jour */
		clientToUpdate.setDateDerniereMiseAJourClient(Instant.now());	
		clientToUpdate.setNomClient(nom);
		clientToUpdate.setPrenomClient(prenom);
		clientToUpdate.setNumeroTelClient(tel);
		clientToUpdate.setAdresseMail(mail);
		
		return clientToUpdate ;
	}

	public int getNumeroAdresse() {
		return numeroAdresse;
	}

	public void setNumeroAdresse(int numeroAdresse) {
		this.numeroAdresse = numeroAdresse;
	}

	public String getComplementAdresse() {
		return complementAdresse;
	}

	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}

	public String getDateDerniereMiseAJour() {
		return dateDerniereMiseAJour;
	}

	public void setDateDerniereMiseAJour(String dateDerniereMiseAJour) {
		this.dateDerniereMiseAJour = dateDerniereMiseAJour;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Long getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(Long idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long id) {
		this.idClient = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "ModificationClient [idClient=" + idClient + ", idAdresse=" + idAdresse + ", checked=" + checked
				+ ", prenom=" + prenom + ", nom=" + nom + ", libelle=" + libelle + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", tel=" + tel + ", mail=" + mail + ", dateCreation=" + dateCreation + "]";
	}
}
