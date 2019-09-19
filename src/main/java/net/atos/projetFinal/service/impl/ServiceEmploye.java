package net.atos.projetFinal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.projetFinal.model.Employe;
import net.atos.projetFinal.repo.EmployeRepository;
import net.atos.projetFinal.service.IEmployeService;

/**
 * Service de employé utilisant dao qui utilise une BDD
 * @author NVV
 *
 */
@Service
public class ServiceEmploye implements IEmployeService {

	@Autowired
	EmployeRepository dao;

	@Override
	@Transactional(readOnly=true)
	public List<Employe> findAllEmploye() {

		return dao.findAll();
	}

	@Override
	@Transactional
	public void creerEmploye(Employe employe) {
		dao.save(employe);

	}

	@Override
	@Transactional
	public void supprimerEmployeParId(Long idEmploye) {
		dao.deleteById(idEmploye);

	}

	@Override
	@Transactional
	public void modifierEmployes(List<Employe> employes) {
		dao.saveAll(employes);

	}

	public EmployeRepository getDao() {
		return dao;
	}
}
