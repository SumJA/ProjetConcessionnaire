package net.atos.projetFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.repo.AdresseRepository;


@Service
public class ServiceAdresse implements IAdresseService {
	
	@Autowired
	private AdresseRepository dao;
	
	
	public AdresseRepository getDao() {
		return dao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Adresse> getAllAdresses() {
		
		return dao.findAll();
	}

	@Override
	@Transactional
	public void creerAdresse(Adresse adresse) {
		
		
		dao.save(adresse);

	}

	@Override
	@Transactional
	public void supprimerAdresse(int idAdresse) {
		
		dao.deleteById(idAdresse);

	}

	@Override
	@Transactional
	public void modifierAdresse(List<Adresse> adresses) {
		

	}

}
