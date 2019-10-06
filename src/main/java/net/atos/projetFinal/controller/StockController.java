package net.atos.projetFinal.controller;

import org.springframework.stereotype.Controller;

@Controller
public class StockController {

//	@Autowired
//	private IStockService stockService;
//
//	@Autowired
//	private StockRepository stockrepo;
//
//	@GetMapping("/stock")
//	public String viewListeStock(Model model) {
//		model.addAttribute("stocks", stockrepo.findAll());
//        return "stock";
//	}
//
//	@GetMapping("/stock/ajouterProduit")
//	public String ajouterStock(Model model) {
//		Stock stock = new Stock();
//		model.addAttribute("ajouterProduit", stock);
//        return "ajouterProduitStock";
//	}
//
//	@PostMapping("/stock/ajouterProduit")
//	public String registration(@ModelAttribute("ajouterProduit") Stock productForm, BindingResult bindingResult) {
//
//		if (bindingResult.hasErrors()) {
//			return "ajouterProduitStock";
//		}
//
//		stockService.creerProduit(productForm);
//
//		return "redirect:/stock";
//	}
}
