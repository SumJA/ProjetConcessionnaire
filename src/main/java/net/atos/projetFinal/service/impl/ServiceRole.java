package net.atos.projetFinal.service.impl;

import net.atos.projetFinal.model.Role;
import net.atos.projetFinal.repo.RoleRepository;
import net.atos.projetFinal.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service utilisant un DAO communiquant avec une BDD en MySQL
 */
@Service
public class ServiceRole implements IRoleService {
    @Autowired
    RoleRepository dao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        return dao.findAll();
    }
    
    @Override
    @Transactional
    public void creerRole(Role role) {
        dao.save(role);
    }
    
    @Override
    @Transactional
    public void supprimerRoleById(Long idRole) {
        dao.deleteById(idRole);
        
    }
    
    
    @Override
    @Transactional
    public void modifierRole(final Role role) {
        
        
        if (role.getId() != null) {
            Optional<Role> roleToUpdate;
            System.err.println("id role: " + role.getId());
            roleToUpdate = dao.findById(role.getId());
            
            
            roleToUpdate.get().setNom(role.getNom());
            
            dao.saveAndFlush(roleToUpdate.get());
            dao.saveAndFlush(roleToUpdate.get());
        } else
            dao.saveAndFlush(role);
    }
    
    public RoleRepository getDao() {
        return dao;
    }
}
