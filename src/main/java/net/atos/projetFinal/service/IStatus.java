package net.atos.projetFinal.service;

import java.util.List;

import net.atos.projetFinal.model.Status;

public interface IStatus {
	
	List<Status> getAllStatuts();
	
	void creerStatus(Status status);
	
	void supprimerStatusById(final int idStatus);
	
	void modifierStatus(final List<Status> status);

}
