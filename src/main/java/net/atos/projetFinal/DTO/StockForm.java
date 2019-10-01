package net.atos.projetFinal.DTO;

import java.text.ParseException;

import net.atos.projetFinal.model.Stock;

public class StockForm {
	
	private Long idStock;
	private String nomProduit;
	private float prixProduit;
	private int qteProduitDispo;
	private int qteReserve;
	private boolean checked;
	
	public void insertStockIntoModif(Stock stock) {
		
		idStock = stock.getIdStock();
		nomProduit = stock.getNomProduit();
		prixProduit = stock.getPrixProduit();
		qteProduitDispo = stock.getQteProduitDispo();
		qteReserve = stock.getQteReserve();
		
		checked = false ;
	}
	
	public Stock getStockFromModif(Stock stockToUpdate) throws ParseException, NoSuchFieldException, IllegalArgumentException {
		
		stockToUpdate.setNomProduit(nomProduit);
		stockToUpdate.setPrixProduit(prixProduit);
		stockToUpdate.setQteProduitDispo(qteProduitDispo);
		stockToUpdate.setQteReserve(qteReserve);
		
		return stockToUpdate;
	}
	
	/**
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked;
	}

	/**
	 * @param checked the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	/**
	 * @return the idStock
	 */
	public Long getIdStock() {
		return idStock;
	}

	/**
	 * @return the nomProduit
	 */
	public String getNomProduit() {
		return nomProduit;
	}
	/**
	 * @param nomProduit the nomProduit to set
	 */
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	/**
	 * @return the prixProduit
	 */
	public float getPrixProduit() {
		return prixProduit;
	}
	/**
	 * @param prixProduit the prixProduit to set
	 */
	public void setPrixProduit(float prixProduit) {
		this.prixProduit = prixProduit;
	}
	/**
	 * @return the qteProduitDispo
	 */
	public int getQteProduitDispo() {
		return qteProduitDispo;
	}
	/**
	 * @param qteProduitDispo the qteProduitDispo to set
	 */
	public void setQteProduitDispo(int qteProduitDispo) {
		this.qteProduitDispo = qteProduitDispo;
	}
	/**
	 * @return the qteReserve
	 */
	public int getQteReserve() {
		return qteReserve;
	}
	/**
	 * @param qteReserve the qteReserve to set
	 */
	public void setQteReserve(int qteReserve) {
		this.qteReserve = qteReserve;
	}

	@Override
	public String toString() {
		return "StockForm [idStock=" + idStock + ", nomProduit=" + nomProduit + ", prixProduit=" + prixProduit
				+ ", qteProduitDispo=" + qteProduitDispo + ", qteReserve=" + qteReserve + ", checked=" + checked + "]";
	}

}
