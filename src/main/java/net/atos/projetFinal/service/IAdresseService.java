package net.atos.projetFinal.service;

import java.util.List;

import net.atos.projetFinal.model.Adresse;

public interface IAdresseService {
	
	
	List<Adresse> getAllAdresses();
	
	void creerAdresse(Adresse adresse);
	
	void supprimerAdresse(final int idAdresse);
	
	void modifierAdresse(final List<Adresse> adresses);
	

}
