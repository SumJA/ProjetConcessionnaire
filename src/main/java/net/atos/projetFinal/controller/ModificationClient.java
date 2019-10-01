package net.atos.projetFinal.controller;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.model.Client;
import net.atos.projetFinal.service.IAdresseService;

import javax.validation.constraints.NotEmpty;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Nils VO-VAN
 */
public class ModificationClient {
    private Long idClient;
    
    private Long idAdresse;
    
    private Boolean checked;
    
    @NotEmpty
    private String prenom;
    
    @NotEmpty
    private String nom;
    
    @NotEmpty
    private String libelle;
    
    
    private int numeroAdresse;
    
    private String complementAdresse;
    
    @NotEmpty
    private String codePostal;
    
    @NotEmpty
    private String ville;
    
    @NotEmpty
    private String pays;
    
    @NotEmpty
    private String tel;
    
    @NotEmpty
    private String mail;
    
    @NotEmpty
    private String dateCreation;
    
    @NotEmpty
    private String dateDerniereMiseAJour;
    
    
    /**
     * Update the ModificationClient attribute according to client
     *
     * @param client             : the client that gets the different attributes value
     * @param expectedDateFormat : the expected date format (how the date have to appeared)
     */
    void insertClientIntoModif(Client client, String expectedDateFormat) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(expectedDateFormat);
        
        idClient = client.getId();
        prenom = client.getPrenom();
        nom = client.getNom();
        tel = client.getNumeroTel();
        mail = client.getEmail();
        dateCreation =
                dateFormat.format(Date.from(client.getDateCreationClient().atZone(ZoneId.systemDefault()).toInstant()));
        dateDerniereMiseAJour = client.getDateDerniereMiseAJourClient().toString();
        
        libelle = client.getAdresse().getLibelleVoie();
        codePostal = client.getAdresse().getCodePostal();
        ville = client.getAdresse().getVille();
        pays = client.getAdresse().getPays();
        idAdresse = client.getAdresse().getId();
        numeroAdresse = client.getAdresse().getNumeroVoie();
        complementAdresse = client.getAdresse().getComplementAdresse();
        
        checked = false;
    }
    
    /**
     * get the client with the right attributes according to the actual ModificationClient
     *
     * @param clientToUpdate     client that has to be modified
     * @param serviceAdresse     the service of Adresse to save the modification
     * @param expectedDateFormat : the expected date format (how the date have to appeared)
     * @throws ParseException           : exception thrown when the date is not at the expected format
     * @throws IllegalArgumentException
     * @throws NoSuchFieldException
     */
    void getClientFromModif(Client clientToUpdate, IAdresseService serviceAdresse, String expectedDateFormat) throws ParseException, NoSuchFieldException, IllegalArgumentException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(expectedDateFormat);
        Adresse adresseToUpdateCloned = clientToUpdate.getAdresse().clone();
        Adresse adresseAJour;
        
        adresseToUpdateCloned.setLibelleVoie(libelle);
        adresseToUpdateCloned.setCodePostal(codePostal);
        adresseToUpdateCloned.setVille(ville);
        adresseToUpdateCloned.setNumeroVoie(numeroAdresse);
        adresseToUpdateCloned.setPays(pays);
        adresseToUpdateCloned.setComplementAdresse(complementAdresse);
        
        adresseAJour = serviceAdresse.modifierAdresse(adresseToUpdateCloned);
        clientToUpdate.setAdresse(adresseAJour);
        
        clientToUpdate.setDateCreationClient(LocalDateTime.ofInstant(dateFormat.parse(dateCreation).toInstant(),
                ZoneId.systemDefault()));
        /* Je considère que le client vient d'être mis à jour */
        clientToUpdate.setDateDerniereMiseAJourClient(Instant.now());
        clientToUpdate.setNom(nom);
        clientToUpdate.setPrenom(prenom);
        clientToUpdate.setNumeroTel(tel);
        clientToUpdate.setEmail(mail);
        
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
    
    public Boolean getChecked() {
        return checked;
    }
    
    public void setChecked(boolean checked) {
        this.checked = checked;
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
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ModificationClient [idClient=" + idClient + ", idAdresse=" + idAdresse + ", checked=" + checked
                + ", prenom=" + prenom + ", nom=" + nom + ", libelle=" + libelle + ", codePostal=" + codePostal
                + ", ville=" + ville + ", tel=" + tel + ", mail=" + mail + ", dateCreation=" + dateCreation + "]";
    }
    
    /**
     * Gets pays.
     *
     * @return Value of pays.
     */
    public String getPays() {
        return pays;
    }
    
    /**
     * Sets new pays.
     *
     * @param pays New value of pays.
     */
    public void setPays(String pays) {
        this.pays = pays;
    }
}
