package net.atos.projetFinal.controller;

import net.atos.projetFinal.model.Commande;
import net.atos.projetFinal.model.Devis;
import net.atos.projetFinal.model.Employe;
import net.atos.projetFinal.model.Role;
import net.atos.projetFinal.service.impl.ServiceRole;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;


public class ModificationEmploye {
    
    
    @Autowired
    private boolean checked;
    
    
    private Long idRole;
    
    private String nomRole;
    
    
    private Long id;
    
    
    private String nom;
    
    
    private String email;
    
    
    private String password;
    
    
    private String passwordConfirm;
    
    
    private Instant createTime;
    
    
    private List<Devis> devisList;
    
    
    private List<Commande> commandes;
    
    
    public boolean getChecked() {
        return checked;
    }
    
    public void setChecked(boolean isChecked) {
        this.checked = isChecked;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
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
    
    public String getPasswordConfirm() {
        return passwordConfirm;
    }
    
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    
    public Instant getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

//	public Role getRole() {
//		return role;
//	}

//	public void setRole(Role role) {
//		this.role = role;
//	}
    
    public List<Devis> getDevisList() {
        return devisList;
    }
    
    public void setDevisList(List<Devis> devisList) {
        this.devisList = devisList;
    }
    
    public List<Commande> getCommandes() {
        return commandes;
    }
    
    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
    
    
    public void insertEmployeIntoModif(Employe employe) {
        id = employe.getId();
        nom = employe.getNom();
        email = employe.getEmail();
        password = employe.getPassword();
        nomRole = employe.getRole().getNom();
        
        idRole = employe.getRole().getId();
        checked = false;
        
        
    }
    
    public Employe getEmployeFromModif(Employe employe, ServiceRole serviceRole) {
        employe.setNom(nom);
        employe.setEmail(email);
        employe.setPassword(password);
        Role role = serviceRole.getDao().findById(idRole).get();
        
        idRole = employe.getRole().getId();
        //role.setIdRole(idRole);
        
        employe.setRole(role);
        
        
        return employe;
        
        
    }
    
    @Override
    public String toString() {
        return "ModificationEmploye [checked=" + checked + ", id=" + id + ", nom=" + nom + ", email=" + email
                + ", password=" + password + ", nomRole=" + nomRole + "]";
    }
    
    
    public String getNomRole() {
        return nomRole;
    }
    
    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }
    
    public Long getIdRole() {
        return idRole;
    }
    
    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }
    
    
}
