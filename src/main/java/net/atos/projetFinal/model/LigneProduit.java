package net.atos.projetFinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Représente une ligne de produit
 * @author Administrateur
 *
 */
@Entity
@Table(name="ligneProduit")
public class LigneProduit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Identifiant de la ligne de produit
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idLigneProduit")
	private Long id ;
	
	/**
	 * Quantité voulu pour la ligne donnée
	 */
	@Column(name = "qteProduit")
	private int qte ;
	
	/**
	 * Prix totale pour la ligne
	 */
	@Column(name = "prixLigne")
	private float prixLigne ;
	
	/**
	 * Devis à laquelle la ligne appartient
	 */
	@ManyToOne
	@JoinColumn(name = "devis_idDevis")
	private Devis devisLigneProduit ;
	
	//TODO ManyToOne Stock

}
