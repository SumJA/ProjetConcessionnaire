package net.atos.projetFinal.controller;

import java.util.List;

import javax.validation.Valid;

import net.atos.projetFinal.DTO.StockForm;

public class ModificationFormStock {

	@Valid
	List<StockForm> modifStocks ;

public List<StockForm> getModifStocks() {
		return modifStocks;
	}

	public void setModifStocks(List<StockForm> modifStocks) {
		this.modifStocks = modifStocks;
	}
}