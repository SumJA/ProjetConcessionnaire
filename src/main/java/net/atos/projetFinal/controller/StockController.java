package net.atos.projetFinal.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.atos.projetFinal.DTO.StockForm;
import net.atos.projetFinal.model.Stock;
import net.atos.projetFinal.repo.StockRepository;
import net.atos.projetFinal.service.IStockService;

@Controller
public class StockController {
	
	@Autowired
	private IStockService stockService;
	
	@Autowired
	private StockRepository stockrepo;
	
	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		List<Stock> stocks = stockService.trouverTousLesStocks();

		if (stocks.isEmpty()) {
			stocks = stockService.trouverTousLesStocks();
		}
		
		stocks = stockService.trouverTousLesStocks();

		ModificationFormStock modifFormStock = new ModificationFormStock();
		List<StockForm> modifStockList = new ArrayList<>();

		for (Stock stock : stocks) {
			StockForm modifStock = new StockForm();
			
			modifStock.insertStockIntoModif(stock);;

			modifStockList.add(modifStock);
		}

		modifFormStock.setModifStocks(modifStockList);

		pModel.addAttribute("modifFormStock", modifFormStock);

		return "stock";
	}
	
	@GetMapping("/stock/ajouterProduit")
	public String ajouterStock(Model model) {
		Stock stock = new Stock();
		model.addAttribute("ajouterProduit", stock);
        return "ajouterProduitStock";
	}
	
	@PostMapping("/stock/ajouterProduit")
	public String ajouterProduit(@ModelAttribute("ajouterProduit") Stock productForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "ajouterProduitStock";
		}
		
		stockService.creerProduit(productForm);

		return "redirect:/stock";
	}
	
	@RequestMapping(value = "/stock/updateStock", method = RequestMethod.POST)
	public String Modification(
			@Valid @ModelAttribute(value = "modifFormStock") final ModificationFormStock pModification,
			final BindingResult pBindingResult, final ModelMap pModel) {

		if (!pBindingResult.hasErrors()) {
			final List<Stock> checkedStocks = new ArrayList<>();
			List<StockForm> checkedModifStockss = new ArrayList<>();
			ModificationFormStock checkedModifForm = new ModificationFormStock();

			for (final StockForm modifStock : pModification.getModifStocks()) {
				/* if the client has been selected by the checkBox */
				if (modifStock.isChecked()) {
					Stock stock;

					try {
						stock = stockService.trouverProduitParId(modifStock.getIdStock());
						modifStock.getStockFromModif(stock);
						checkedStocks.add(stock);
						checkedModifStockss.add(modifStock);
					} catch (ParseException e) {
						System.err.println(e.getMessage());
					} catch (NoSuchFieldException e) {
						// TODO Auto-generated catch block
						System.err.println(e.getMessage());
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						System.err.println(e.getMessage());
						e.printStackTrace();
					}
				}
			}
			
			if(checkedModifStockss.size() > 0)
			{
				checkedModifForm.setModifStocks(checkedModifStockss);
				/* Erase the current values with the selected values with checkBox */
				pModel.addAttribute("modifFormStock", checkedModifForm);
				
				return "modifierProduitStock";
			}

		}
		
		return(afficher(pModel)) ;

	}
	
}
