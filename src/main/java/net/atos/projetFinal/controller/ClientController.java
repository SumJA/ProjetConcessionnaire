package net.atos.projetFinal.controller;

import java.text.ParseException;
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
import net.atos.projetFinal.service.impl.ServiceClient;

/**
 * 
 * @author NVV
 *
 */
@Controller
public class ClientController {

	private final String DATE_FORMAT = "dd/MM/yyyy";

	@Autowired
	private ServiceClient serviceClient;

	@RequestMapping(value = "/admin/listeClients", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		if (pModel.get("listeClientAAfficher") == null) {
			// List<Client> clients = serviceClient.getAllClients();
			List<Client> clients = initialValues();
			ModificationFormClient modifFormClient = new ModificationFormClient();
			List<ModificationClient> modifClientList = new ArrayList<>();

			for (Client client : clients) {
				ModificationClient modifClient = new ModificationClient();

				modifClient.insertClientIntoModif(client, DATE_FORMAT);

				modifClientList.add(modifClient);
			}

			modifFormClient.setModifClients(modifClientList);

			pModel.addAttribute("modifFormClient", modifFormClient);
		}

		return "listeClients";
	}

	@RequestMapping(value = "/admin/listeClients/updateclient", method = RequestMethod.POST)
	public String modifier(@Valid @ModelAttribute(value = "modifFormClient") final ModificationFormClient pModification,
			final BindingResult pBindingResult, final ModelMap pModel) {

		if (!pBindingResult.hasErrors()) {
			final List<Client> lClients = new ArrayList<>();
			for (final ModificationClient modifClient : pModification.getModifClients()) {
				/* if the client has been selected by the checkBox */
				if (modifClient.getChecked()) {
					Client client;
					
					try {
						client = modifClient.getClientFromModif(DATE_FORMAT);
						lClients.add(client);
					} catch (ParseException e) {
						System.err.println(e.getMessage());
					}

				}

			}
			System.err.println("Nb selection : " + lClients.size());
			System.err.println(lClients);
			
			pModel.remove("modifFormClient") ;

		}

		return "listeClients";
	}

	List<Client> initialValues() {
		List<Client> clients = new ArrayList<Client>();
		Client client;
		Adresse adresse = new Adresse();

		adresse.setCodePostal("69120");
		adresse.setComplement("rien");
		adresse.setNumero(14);
		adresse.setId(3L);
		adresse.setLibelle("Rue Bonnevay");
		adresse.setVille("Vaulx");

		client = new Client();
		client.setAdresse(adresse);
		client.setId(1L);
		client.setPrenom("Nils");
		client.setNom("VO");
		client.setNumeroTelClient("0478809543");
		client.setAdresseMail("zaed@dza.com");

		clients.add(client);

		client = new Client();
		client.setAdresse(adresse);
		client.setId(2L);
		client.setPrenom("John");
		client.setNom("Connor");
		client.setNumeroTelClient("0478809543");
		client.setAdresseMail("Ill@bback.com");

		clients.add(client);

		return (clients);
	}

}
