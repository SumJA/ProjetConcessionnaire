package net.atos.projetFinal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.projetFinal.model.Status;
import net.atos.projetFinal.repo.StatusRepository;
import net.atos.projetFinal.service.IStatus;



@Service
public class ServiceStatus implements IStatus {

	

	@Autowired
	private StatusRepository dao;
	
	
	
	public StatusRepository getDao() {
		return dao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Status> getAllStatuts() {
		
		return dao.findAll();
	}

	@Override
	@Transactional
	public void creerStatus(Status status) {
		
		dao.save(status);

	}

	@Override
	@Transactional
	public void supprimerStatusById(int idStatus) {
		
		dao.deleteById(idStatus);

	}

	@Override
	@Transactional
	public void modifierStatus(List<Status> status) {
		
		

	}

}
