package net.atos.projetFinal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.atos.projetFinal.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

	/**
	 * Retourne le produit dont le nom correspond à celui donné en paramètre
	 * 
	 * @param nomProduit le nom du produit à retrouver
	 * @return un Produit
	 */
	@Query("SELECT s FROM Stock s WHERE s.nomProduit = ?1")
	List <Stock> findByProductName(String nomProduit);
}
