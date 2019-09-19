package net.atos.projetFinal.service;

import java.util.List;

import net.atos.projetFinal.model.Adresse;

public interface IAdresseService {
	
	
	List<Adresse> getAllAdresses();
	
	void creerAdresse(final Adresse adresse);
	
	void supprimerAdresse(final Long idAdresse);
	
	void modifierAdresse(final List<Adresse> adresses);
	

}
