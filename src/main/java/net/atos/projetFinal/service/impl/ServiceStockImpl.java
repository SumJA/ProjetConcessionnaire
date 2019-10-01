package net.atos.projetFinal.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.projetFinal.model.Stock;
import net.atos.projetFinal.repo.StockRepository;
import net.atos.projetFinal.service.IStockService;

@Service
public class ServiceStockImpl implements IStockService{
	
	@Autowired
	StockRepository stockRepository;
	
    @Override
    @Transactional(readOnly = true)
    public Optional<Stock> trouverProduitParId(@NotNull final Long id) {
        if (id != null) {
            return stockRepository.findById(id);
        } else {
            throw new NullPointerException("L'identifiant du produit fournie en paramètre est null");
        }
    }

	/**
	 * Retourne la liste de tous les lignes de stock sauvegardé en base
	 * 
	 * @return la liste de toutes les lignes de stock en base
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Stock> trouverTousLesStocks() {
		return stockRepository.findAll();
	}

	/**
	 * Créer un nouveau produit
	 * 
	 * @param la ligne de stock à créer en base, ne doit pas etre un {@literal null}
	 * @throws DataIntegrityViolationException si la ligne est déjà existant dans
	 *                                         la base
	 * @throws NullPointerException            si la ligne donnée en paramètre est
	 *                                         null
	 * @return un produit
	 */
	@Override
	public Stock creerProduit(@NotNull Stock stock) {
		if (stock != null) {
			// Vérfication du respect de la contrainte d'unicité sur le username et l'email
			// de l'employé :
			List<Stock> stockVerificationDoublon = stockRepository.findByProductName(stock.getNomProduit());
			
			if (stockVerificationDoublon.isEmpty()) {
				return stockRepository.saveAndFlush(stock);
			} else {
				throw new DataIntegrityViolationException("Produit déjà existant");
			}
		} else {
			throw new NullPointerException("Le produit fournie en paramètre est null");
		}
	}

	/**
	 * Supprimer une ligne identifiée par l'identifiant donnée en paramètre
	 * 
	 * @param idStock : l'identifiant de la ligne à supprimer, ne doit pas etre
	 *                  un {@literal null}
	 * @throws IllegalArgumentException dans le cas où {@code idStock} donné est
	 *                                  {@literal null}
	 * @throws NullPointerException     si l'id de la ligne donnée en paramètre est
	 *                                  null
	 */
	@Override
	public void supprimerLigneParId(@NotNull Long idStock) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Met à jour une ligne de stock
	 * 
	 * @param stock : la ligne à mettre à jour, ne doit pas etre un
	 *                {@literal null}
	 * @throws IllegalArgumentException dans le cas où {@code stock} est un
	 *                                  {@literal null}
	 * @throws NoSuchElementException   si une ligne n'existe pas en base
	 */
	@Override
	public void modifierStock(@NotNull Stock stock) {
		// TODO Auto-generated method stub
		
	}

}
