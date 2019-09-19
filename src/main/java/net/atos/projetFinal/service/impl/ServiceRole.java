package net.atos.projetFinal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.projetFinal.model.Role;
import net.atos.projetFinal.repo.RoleRepository;
import net.atos.projetFinal.service.IRoleService;

/**
 * Service utilisant un DAO communiquant avec une BDD en MySQL
 * @author NVV
 *
 */
@Service
public class ServiceRole implements IRoleService{
	@Autowired
	RoleRepository dao ;

	@Override
	@Transactional(readOnly = true)
	public List<Role> getAllRoles() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public void creerRole(Role role) {
		dao.save(role) ;
	}

	@Override
	@Transactional
	public void supprimerRoleById(int idRole) {
		dao.deleteById(idRole);
		
	}

	@Override
	@Transactional
	public void modifierRoles(List<Role> roles) {
		dao.saveAll(roles) ;		
	}

	public RoleRepository getDao() {
		return dao;
	}
}
