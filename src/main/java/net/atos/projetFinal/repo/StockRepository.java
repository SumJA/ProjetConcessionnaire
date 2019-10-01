package net.atos.projetFinal.repo;

import net.atos.projetFinal.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository pour un stock et qui est une extension de {@link org.springframework.data.jpa.repository.JpaRepository}.
 * {@inheritDoc}
 */
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
