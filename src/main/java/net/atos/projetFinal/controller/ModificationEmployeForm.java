package net.atos.projetFinal.controller;

import javax.validation.Valid;
import java.util.List;


public class ModificationEmployeForm {
    
    
    @Valid
    private List<ModificationEmploye> modifEmployes;
    
    public List<ModificationEmploye> getModifEmployes() {
        return modifEmployes;
    }
    
    public void setModifEmployes(List<ModificationEmploye> modifEmployes) {
        this.modifEmployes = modifEmployes;
    }
    
}
