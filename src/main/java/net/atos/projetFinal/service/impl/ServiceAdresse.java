package net.atos.projetFinal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.repo.AdresseRepository;
import net.atos.projetFinal.service.IAdresseService;


/**
 * Classe ServiceAdresse
 * implément IAdresseService
 * annotation:  @Service
 * @author kamel
 *
 */
@Service
public class ServiceAdresse implements IAdresseService {

	/**
	 * @Autowired de AdresseRepository
	 */
	@Autowired
	private AdresseRepository dao;
	
	
	
	public AdresseRepository getDao() {
		return dao;
	}

	/**
	 * méthode getAllAdresses
	 * Annotations: @Override, @Transactional(readOnly=true)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Adresse> getAllAdresses() {
		
		return dao.findAll();
	}

	/**
	 * méthode creerAdresse
	 * Annotations: @Override, @Transactional
	 */
	@Override
	@Transactional
	public void creerAdresse(Adresse adresse) {
		dao.save(adresse);
	}

	/**
	 * méthode supprimerAdresse
	 * Annotations: @Override, @Transactional
	 */
	@Override
	@Transactional
	public void supprimerAdresse(Long idAdresse) {
		dao.deleteById(idAdresse);

	}

	@Override
	@Transactional
	public void modifierAdresse(List<Adresse> adresses) {
		
		
		

	}

}
