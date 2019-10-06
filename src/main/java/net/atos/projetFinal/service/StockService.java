package net.atos.projetFinal.service;

public interface StockService {
    Integer metAJourStockDisponiblePourProduit(String nomProduit);
    
    Integer metAJourStockReservePourProduit(String nomProduit);
}
