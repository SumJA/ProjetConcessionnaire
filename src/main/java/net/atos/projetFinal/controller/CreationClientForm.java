package net.atos.projetFinal.controller;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.model.Client;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author Nils VO-VAN
 */
public class CreationClientForm {
    
    private String prenom;
    
    private String nom;
    
    private String libelle;
    
    private int numeroAdresse;
    
    private String complementAdresse;
    
    private String codePostal;
    
    private String ville;
    
    private String pays;
    
    private String tel;
    
    private String mail;
    
    
    /**
     * Update the CretationClientFrom attribute according to client
     *
     * @param client : the client that gets the different attributes value
     */
    public void insertClientIntoCreat(Client client) {
        
        prenom = client.getPrenom();
        nom = client.getNom();
        tel = client.getNumeroTel();
        mail = client.getEmail();
        
        libelle = client.getAdresse().getLibelleVoie();
        codePostal = client.getAdresse().getCodePostal();
        ville = client.getAdresse().getVille();
        pays = client.getAdresse().getPays();
        numeroAdresse = client.getAdresse().getNumeroVoie();
        complementAdresse = client.getAdresse().getComplementAdresse();
    }
    
    /**
     * get the client with the right attributes according to the actual CreationClientForm
     *
     * @return the Client object with the updated attributes
     */
    public Client getClientFromCreat() {
        Client clientToCreate = new Client();
        Adresse adresse = new Adresse();
        
        adresse.setLibelleVoie(libelle);
        adresse.setCodePostal(codePostal);
        adresse.setVille(ville);
        adresse.setPays(pays);
        adresse.setNumeroVoie(numeroAdresse);
        adresse.setComplementAdresse(complementAdresse);
        clientToCreate.setAdresse(adresse);
        
        clientToCreate.setNom(nom);
        clientToCreate.setDateCreationClient(LocalDateTime.now());
        clientToCreate.setDateDerniereMiseAJourClient(Instant.now());
        clientToCreate.setPrenom(prenom);
        clientToCreate.setNumeroTel(tel);
        clientToCreate.setEmail(mail);
        
        return clientToCreate;
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
        return "CreationClientForm [prenom=" + prenom + ", nom=" + nom + ", libelle=" + libelle + ", numeroAdresse="
                + numeroAdresse + ", complementAdresse=" + complementAdresse + ", codePostal=" + codePostal + ", ville="
                + ville + ", tel=" + tel + ", mail=" + mail + "]";
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
