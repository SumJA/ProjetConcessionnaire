package net.atos.projetFinal.controller;

import java.util.List;

import javax.validation.Valid;

/**
 * 
 * @author NVV
 *
 */
public class ModificationFormClient {

	@Valid
	List<ModificationClient> modifClients ;

	public List<ModificationClient> getModifClients() {
		return modifClients;
	}

	public void setModifClients(List<ModificationClient> modifClients) {
		this.modifClients = modifClients;
	}
}
