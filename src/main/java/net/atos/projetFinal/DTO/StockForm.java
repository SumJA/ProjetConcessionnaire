package net.atos.projetFinal.DTO;

public class StockForm {
	
	private Long id;
	private String nomProduit;
	private float prixProduit;
	private int qteProduitDispo;
	private int qteReserve;
	
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
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
}
