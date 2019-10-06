package net.atos.projetFinal.controller;

import net.atos.projetFinal.exception.InvalidUserRole;
import net.atos.projetFinal.model.Employe;
import net.atos.projetFinal.service.GestionEmployeServiceImpl;
import net.atos.projetFinal.service.ServiceRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeController {
    @Autowired
    private GestionEmployeServiceImpl gestionEmployeServiceImpl;
    
    @Autowired
    private ServiceRole serviceRole;
    
    @RequestMapping(value = "/admin/listeEmployes", method = RequestMethod.GET)
    public String afficher(final ModelMap pModel) {
        List<Employe> employes = gestionEmployeServiceImpl.trouverTousLesEmployes();
        
        ModificationEmployeForm modifFormEmploye = new ModificationEmployeForm();
        List<ModificationEmploye> modifEmployeList = new ArrayList<>();
        for (Employe employe : employes) {
            
            ModificationEmploye modifEmploye = new ModificationEmploye();
            modifEmploye.insertEmployeIntoModif(employe);
            
            modifEmployeList.add(modifEmploye);
        }
        modifFormEmploye.setModifEmployes(modifEmployeList);
        pModel.addAttribute("modifFormEmploye", modifFormEmploye);
        return "listeEmployes";
    }
    
    
    @RequestMapping(value = "/admin/listeEmployes/gotoupdateemploye", method = RequestMethod.POST)
    public String creer(@Valid @ModelAttribute(value = "modifFormEmploye") final ModificationEmployeForm pModification,
                        final BindingResult pBindingResult, final ModelMap pModel) {
        
        if (!pBindingResult.hasErrors()) {
            final List<Employe> checkedEmployes = new ArrayList<>();
            List<ModificationEmploye> checkedModifEmployes = new ArrayList<>();
            ModificationEmployeForm checkedModifForm = new ModificationEmployeForm();
            for (final ModificationEmploye modifEmploye : pModification.getModifEmployes()) {
                
                if (modifEmploye.getChecked()) {
                    Employe employe;
                    try {
                        checkedModifEmployes.add(modifEmploye);
                    } catch (Exception e) {
                        System.err.println("erreur de modification: voir methode creer de la classe EmployeController");
                    }
                }
            }
            
            if (checkedModifEmployes.size() > 0) {
                checkedModifForm.setModifEmployes(checkedModifEmployes);
                pModel.addAttribute("modifFormEmploye", checkedModifForm);
                
                serviceRole.getAllRoles();
                pModel.addAttribute("roleListe", serviceRole.getAllRoles());
                
                return "modifierEmployes";
            }
        }
        
        return afficher(pModel);
    }
    
    @RequestMapping(value = "/admin/listeEmployes/updateemploye", method = RequestMethod.POST)
    public String modifier(
            @Valid @ModelAttribute(value = "modifFormEmploye") final ModificationEmployeForm pModification,
            
            final BindingResult pBindingResult, final ModelMap pModel) {
        
        if (!pBindingResult.hasErrors()) {
            
            final List<Employe> employesToModify = new ArrayList<>();
            
            for (final ModificationEmploye modifEmploye : pModification.getModifEmployes()) {
                
                Employe employe;
                
                try {
    
    
                    employe = gestionEmployeServiceImpl.getEmployeRepository().findById(modifEmploye.getId()).get();
                    modifEmploye.getEmployeFromModif(employe, serviceRole);
                    
                    employesToModify.add(employe);
                    
                    
                } catch (Exception e) {
                    System.err.println("erreur: voir methode modifier de la classe EmployeController " + e.getMessage());
                }
    
    
                gestionEmployeServiceImpl.modifierEmployes(employesToModify);
                
                
            }
            
        }
        return afficher(pModel);
    }
    
    @RequestMapping(value = "/admin/ajouterEmploye", method = RequestMethod.POST)
    public String creer(@Valid @ModelAttribute(value = "creationForm") final CreationEmployeForm pCreation,
                        final BindingResult pBindingResult, final ModelMap pModel) throws InvalidUserRole {
        if (!pBindingResult.hasErrors()) {
            final Employe employesToCreate;
            employesToCreate = pCreation.getEmployeFromCreat(serviceRole);
            gestionEmployeServiceImpl.creerEmploye(employesToCreate);
        }
        return afficher(pModel);
    }
    
    @RequestMapping(value = "/admin/listeEmployes/ajouterEmploye", method = RequestMethod.GET)
    public String allerACreation(final ModelMap pModel) {
        CreationEmployeForm creationEmployeForm = new CreationEmployeForm();
        pModel.addAttribute("creationForm", creationEmployeForm);
        pModel.addAttribute("roleListe", serviceRole.getAllRoles());
        
        return "ajouterEmploye";
    }
}