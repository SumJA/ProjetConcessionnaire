package net.atos.projetFinal.controller;

import net.atos.projetFinal.model.Employe;
import net.atos.projetFinal.service.impl.ServiceRole;

public class CreationEmployeForm {
    
    private Long idRole;
    
    private String nomRole;
    
    private String nom;
    
    private String email;
    
    private String password;
    
    
    public void insertemployeIntoCreat(Employe employe) {
        
        
        nom = employe.getNom();
        email = employe.getEmail();
        password = employe.getPassword();
        System.err.println("employe.getRole().getIdRole() " + employe.getRole().getId());
        idRole = employe.getRole().getId();
        nomRole = employe.getRole().getNom();                //getNom();
        
    }
    
    
    public Employe getEmployeFromCreat(ServiceRole serviceRole) {
        
        Employe employe = new Employe();
        
        //Role role=new Role();
        
        //role.setNomRole(nomRole);		//setNom(nomRole);
        employe.setNom(nom);
        employe.setEmail(email);
        employe.setPassword(password);
        
        //role);
        employe.setRole(serviceRole.getDao().findById(idRole).get());
        
        return employe;
        
    }
    
    
    public Long getIdRole() {
        return idRole;
    }
    
    
    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }
    
    
    public String getNomRole() {
        return nomRole;
    }
    
    
    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }
    
    
    public String getNom() {
        return nom;
    }
    
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    public String getEmail() {
        return email;
    }
    
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String getPassword() {
        return password;
    }
    
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    @Override
    public String toString() {
        return "CreationEmployeForm [nomRole=" + nomRole + ", nom=" + nom + ", email=" + email + ", password="
                + password + "]";
    }
    
    
}
