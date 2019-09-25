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

	@Override
	public List<Status> trouverTousLesStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status trouverStatusParId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status trouverStatusParNom(String nomStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
