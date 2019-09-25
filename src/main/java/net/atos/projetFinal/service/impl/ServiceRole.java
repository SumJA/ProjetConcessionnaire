package net.atos.projetFinal.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.atos.projetFinal.model.Role;
import net.atos.projetFinal.service.IRoleService;

/**
 * Service utilisant un DAO communiquant avec une BDD en MySQL
 * @author NVV
 *
 */
@Service
public class ServiceRole implements IRoleService{

	@Override
	public List<Role> trouverTousLesRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creerRole(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerRoleParId(Long idRole) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierRoles(List<Role> roles) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierRole(Role role) {
		// TODO Auto-generated method stub
		
	}
	
}
