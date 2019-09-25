package net.atos.projetFinal.controller;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.model.Client;
import net.atos.projetFinal.service.IAdresseService;
import net.atos.projetFinal.service.IClientService;

/**
 * 
 * @author Nils VO-VAN
 *
 */
@Controller
public class ClientController {

	private final String DATE_FORMAT = "dd/MM/yyyy";

	@Autowired
	private IClientService serviceClient;

	@Autowired
	private IAdresseService serviceAdresse;

	/**
	 * Method pour afficher touts les client
	 * @param pModel model envoyé à la JSP
	 * @return le nom de la JSP
	 */
	@RequestMapping(value = "/admin/listeClients", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		List<Client> clients = serviceClient.getAllClients();

		/* pour la phase test... */
		if (clients.isEmpty()) {
			/* Add default value in the BDD */
			initialValues();
			clients = serviceClient.getAllClients();
		}

		ModificationFormClient modifFormClient = new ModificationFormClient();
		List<ModificationClient> modifClientList = new ArrayList<>();

		for (Client client : clients) {
			ModificationClient modifClient = new ModificationClient();

			modifClient.insertClientIntoModif(client, DATE_FORMAT);

			modifClientList.add(modifClient);
		}

		modifFormClient.setModifClients(modifClientList);

		pModel.addAttribute("modifFormClient", modifFormClient);

		return "listeClients";
	}

	/**
	 * Methode qui permet d'intialiser la fenêtre de modification des clients
	 * @param pModification formulaire indiquant les élément selectionné avec checkBox
	 * @param pBindingResult
	 * @param pModel model
	 * @return Va à la jsp d'affichage si aucune selection et va à la jsp de modif sinon
	 */
	@RequestMapping(value = "/admin/listeClients/gotoupdateclient", method = RequestMethod.POST)
	public String allerAModification(
			@Valid @ModelAttribute(value = "modifFormClient") final ModificationFormClient pModification,
			final BindingResult pBindingResult, final ModelMap pModel) {

		if (!pBindingResult.hasErrors()) {
			final List<Client> checkedClients = new ArrayList<>();
			List<ModificationClient> checkedModifClients = new ArrayList<>();
			ModificationFormClient checkedModifForm = new ModificationFormClient();

			for (final ModificationClient modifClient : pModification.getModifClients()) {
				/* if the client has been selected by the checkBox */
				if (modifClient.getChecked()) {
					Client client;

					try {
						client = modifClient.getClientFromModif(DATE_FORMAT);
						checkedClients.add(client);
						checkedModifClients.add(modifClient);
					} catch (ParseException e) {
						System.err.println(e.getMessage());
					}
				}
			}
			
			if(checkedModifClients.size() > 0)
			{
				checkedModifForm.setModifClients(checkedModifClients);
				/* Erase the current values with the selected values with checkBox */
				pModel.addAttribute("modifFormClient", checkedModifForm);
				
				return "modifierClients";
			}

		}
		
		return(afficher(pModel)) ;

	}

	/**
	 * Méthode enclencher lorsque l'utilisateur lance une modification de différents clients
	 * @param pModification contient toutes les modif que l'utilisateur a fait
	 * @param pBindingResult
	 * @param pModel
	 * @return à la jsp d'affichage des clients
	 */
	@RequestMapping(value = "/admin/listeClients/updateclient", method = RequestMethod.POST)
	public String modifier(@Valid @ModelAttribute(value = "modifFormClient") final ModificationFormClient pModification,
			final BindingResult pBindingResult, final ModelMap pModel) {

		if (!pBindingResult.hasErrors()) {
			final List<Client> clientsToModify = new ArrayList<>();

			for (final ModificationClient modifClient : pModification.getModifClients()) {

				Client client;

				try {
					client = modifClient.getClientFromModif(DATE_FORMAT);
					clientsToModify.add(client);
				} catch (ParseException e) {
					System.err.println(e.getMessage());
				}
			}

			System.err.println("Avant modifierClient dans modifier de ClientController");
			
			serviceClient.modifierClients(clientsToModify);
		}

		return afficher(pModel);
	}

	/**
	 * !!!!! FOR TEST ONLY !!!!!
	 * Initialise la base de donnée avec des valeur par défaut
	 */
	void initialValues() {
		Client client;
		Adresse adresse = new Adresse();
		LocalDateTime localDate ;

		adresse.setCodePostal("69120");
		adresse.setComplement("rien");
		adresse.setNumero(14);
		adresse.setLibelle("Rue Bonnevay");
		adresse.setVille("Vaulx");
		serviceAdresse.creerAdresse(adresse);
		
		localDate = LocalDateTime.now();
		localDate = localDate.minusYears(50) ;

		client = new Client();
		client.setAdresse(adresse);
		client.setDateCreation(localDate);
		client.setPrenom("Nils");
		client.setNom("VO");
		client.setNumeroTelClient("0478809543");
		client.setAdresseMail("zaed@dza.com");
		serviceClient.creerClient(client);

		adresse = new Adresse();
		adresse.setCodePostal("69100");
		adresse.setComplement("rien");
		adresse.setNumero(14);
		adresse.setLibelle("Rue Henry Barbusse");
		adresse.setVille("Villeurbanne");
		serviceAdresse.creerAdresse(adresse);

		localDate = LocalDateTime.now();
		localDate = localDate.minusYears(10) ;
		
		client = new Client();
		client.setAdresse(adresse);
		client.setDateCreation(localDate);
		client.setPrenom("John");
		client.setNom("Connor");
		client.setNumeroTelClient("0478809543");
		client.setAdresseMail("Ill@bback.com");
		serviceClient.creerClient(client);

		adresse = new Adresse();
		adresse.setCodePostal("74000");
		adresse.setComplement("rien");
		adresse.setNumero(50);
		adresse.setLibelle("Rue du lac");
		adresse.setVille("Annecy");
		serviceAdresse.creerAdresse(adresse);

		localDate = LocalDateTime.now();
		localDate = localDate.minusYears(20) ;
		
		client = new Client();
		client.setAdresse(adresse);
		client.setDateCreation(localDate);
		client.setPrenom("Jim");
		client.setNom("Carrey");
		client.setNumeroTelClient("0478809543");
		client.setAdresseMail("splen@did.com");
		serviceClient.creerClient(client);

		localDate = LocalDateTime.now();
		localDate = localDate.minusYears(5) ;
		
		client = new Client();
		client.setAdresse(adresse);
		client.setDateCreation(localDate);
		client.setPrenom("Corinne");
		client.setNom("Manificat");
		client.setNumeroTelClient("0478809543");
		client.setAdresseMail("splen@did.com");
		serviceClient.creerClient(client);
	}

}
