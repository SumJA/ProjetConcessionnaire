package net.atos.projetFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.atos.projetFinal.model.Stock;
import net.atos.projetFinal.repo.StockRepository;
import net.atos.projetFinal.service.IStockService;

@Controller
public class StockController {
	
	@Autowired
	private IStockService stockService;
	
	@Autowired
	private StockRepository stockrepo;
	
	@GetMapping("/stock")
	public String viewListeStock(Model model) {
		model.addAttribute("stocks", stockrepo.findAll());
        return "stock";
	}
	
	@GetMapping("/stock/ajouterProduit")
	public String ajouterStock(Model model) {
		Stock stock = new Stock();
		model.addAttribute("ajouterProduit", stock);
        return "ajouterProduitStock";
	}
	
	@PostMapping("/stock/ajouterProduit")
	public String registration(@ModelAttribute("ajouterProduit") Stock productForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "ajouterProduitStock";
		}
		
		stockService.creerProduit(productForm);

		return "redirect:/stock";
	}
}
