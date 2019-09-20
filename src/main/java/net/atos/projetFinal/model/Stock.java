package net.atos.projetFinal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id de Commande correspond à "idStatus"
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idStock")
	private Long id;

	/**
	 * Nom du produit
	 */
	@Column(name = "nomProduit")
	private String nom;

	/**
	 * Prix unitaire du produit
	 */
	@Column(name = "prixProduit")
	private String prix;

	/**
	 * Quantité du produit disponible
	 */
	@Column(name = "qteProduit")
	private int qteDispo;

	/**
	 * Quantité réservé du produit (quantité réservée pour un client)
	 */
	@Column(name = "qteReserve")
	private int qteReserve;

	/**
	 * Lignes présenté dans un devis correspondant au stock
	 */
	@OneToMany(mappedBy = "stock")
	List<LigneProduit> lignesProduit;

	/**
	 * Lignes présenté dans un devis correspondant au stock
	 */
	@OneToMany(mappedBy = "stock")
	List<LigneCommande> lignesCommande;

	public Stock() {
		super();
	}

	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public int getQteDispo() {
		return qteDispo;
	}

	public void setQteDispo(int qteDispo) {
		this.qteDispo = qteDispo;
	}

	public int getQteReserve() {
		return qteReserve;
	}

	public void setQteReserve(int qteReserve) {
		this.qteReserve = qteReserve;
	}

	public List<LigneProduit> getLignesProduit() {
		return lignesProduit;
	}

	public void setLignesProduit(List<LigneProduit> lignesProduit) {
		this.lignesProduit = lignesProduit;
	}

}
