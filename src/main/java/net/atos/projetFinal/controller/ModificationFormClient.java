package net.atos.projetFinal.controller;

import java.util.List;

/**
 * 
 * @author Nils VO-VAN
 *
 */
public class ModificationFormClient {
    
    private List<ModificationClient> modifClients;

	public List<ModificationClient> getModifClients() {
		return modifClients;
	}

	public void setModifClients(List<ModificationClient> modifClients) {
		this.modifClients = modifClients;
	}
    
    @Override
    public String toString() {
        return "ModificationFormClient{" +
                "modifClients=" + modifClients +
                '}';
    }
}
