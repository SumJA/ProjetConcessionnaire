package net.atos.projetFinal.controller;

import net.atos.projetFinal.model.Client;
import net.atos.projetFinal.service.IAdresseService;
import net.atos.projetFinal.service.IClientService;
import net.atos.projetFinal.validator.CreationClientValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nils VO-VAN
 */
@Controller
public class ClientController {
    private final String DATE_FORMAT = "dd/MM/yyyy";
    
    private final IClientService serviceClient;
    
    private final IAdresseService serviceAdresse;
    
    private final CreationClientValidator creationValidator;
    
    public ClientController(IClientService serviceClient, IAdresseService serviceAdresse,
                            CreationClientValidator creationValidator) {
        this.serviceClient = serviceClient;
        this.serviceAdresse = serviceAdresse;
        this.creationValidator = creationValidator;
    }
    
    /**
     * Method pour afficher touts les client
     *
     * @param pModel model envoyé à la JSP
     * @return le nom de la JSP
     */
    @GetMapping(value = "/admin/listeClients")
    public String clientList(final ModelMap pModel) {
        List<Client> clients = serviceClient.trouverTousLesClients();
        
        ModificationFormClient modifFormClient = new ModificationFormClient();
        List<ModificationClient> modifClientList = new ArrayList<>();
        
        for (Client client : clients) {
            ModificationClient modifClient = new ModificationClient();
            modifClient.insertClientIntoModif(client, DATE_FORMAT);
            modifClientList.add(modifClient);
        }
        modifFormClient.setModifClients(modifClientList);
        System.err.println("modifFormClient = " + modifFormClient.getModifClients().get(0));
        pModel.addAttribute("modifFormClient", modifFormClient);
        return "listeClients";
    }
    
    /**
     * Methode qui permet d'intialiser la fenêtre de modification des clients
     *
     * @param pModification formulaire indiquant les élément selectionné (ou pas) avec checkBox
     * @param pModel        model
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
                        client = serviceClient.trouverClientParId(modifClient.getIdClient());
                        modifClient.getClientFromModif(client, serviceAdresse, DATE_FORMAT);
                        checkedClients.add(client);
                        checkedModifClients.add(modifClient);
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
            
            if (checkedModifClients.size() > 0) {
                checkedModifForm.setModifClients(checkedModifClients);
                /* Erase the current values with the selected values with checkBox */
                pModel.addAttribute("modifFormClient", checkedModifForm);
                
                return "modifierClients";
            }
            
        }
        
        return (clientList(pModel));
        
    }
    
    
    /**
     * Une méthode qui retourne sur afficher client
     *
     * @param pModel
     * @return
     */
    @RequestMapping(value = "/admin/listeClients/gotoupdateclient", method = RequestMethod.GET)
    public String allerAModificationGet(final ModelMap pModel) {
        
        
        return (clientList(pModel));
        
    }
    
    /**
     * Méthode enclencher lorsque l'utilisateur lance une modification de différents clients
     *
     * @param pModification  contient toutes les modif que l'utilisateur a fait
     * @param pBindingResult
     * @param pModel
     * @return à la jsp d'affichage des clients
     * @throws NoSuchFieldException
     * @throws NoSuchFieldError
     */
    @RequestMapping(value = "/admin/listeClients/updateclient", method = RequestMethod.POST)
    public String modifier(@Valid @ModelAttribute(value = "modifFormClient") final ModificationFormClient pModification,
                           final BindingResult pBindingResult, final ModelMap pModel) throws NoSuchFieldError,
            NoSuchFieldException {
        
        if (!pBindingResult.hasErrors()) {
            final List<Client> clientsToModify = new ArrayList<>();
            
            for (final ModificationClient modifClient : pModification.getModifClients()) {
                
                Client client;
                
                try {
                    client = serviceClient.trouverClientParId(modifClient.getIdClient());
                    modifClient.getClientFromModif(client, serviceAdresse, DATE_FORMAT);
                    clientsToModify.add(client);
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
            
            serviceClient.modifierClients(clientsToModify);
            return clientList(pModel);
        } else {
            return ("modifierClients");
        }
        
    }
    
    /**
     * Méthode qui retourne sur la jsp afficherClient
     *
     * @param pModel
     * @return
     */
    @RequestMapping(value = "/admin/listeClients/updateclient", method = RequestMethod.GET)
    public String modifierGet(final ModelMap pModel) {
        
        
        return (clientList(pModel));
    }
    
    /**
     * Méthode enclencher lorsque l'utilisateur lance une création de différents clients
     *
     * @param pCreation      contient toutes les info nécessaire pour créer
     * @param pBindingResult
     * @param pModel
     * @return à la jsp d'affichage des clients
     */
    @RequestMapping(value = "/admin/listeClients/ajouterClient", method = RequestMethod.POST)
    public String creer(@ModelAttribute(value = "creationForm") final CreationClientForm pCreation,
                        final BindingResult pBindingResult, final ModelMap pModel) {
        
        
        creationValidator.validate(pCreation, pBindingResult);
        
        if (!pBindingResult.hasErrors()) {
            final Client clientToCreate;
            
            clientToCreate = pCreation.getClientFromCreat();
            
            clientToCreate.setAdresse(serviceAdresse.creerAdresse(clientToCreate.getAdresse()));
            serviceClient.creerClient(clientToCreate);
            
            return clientList(pModel);
        } else {
            return "ajouterClient";
        }
        
    }
    
    /**
     * Méthode enclencher lorsque l'utilisateur lance une création de différents clients
     *
     * @param pModel
     * @return à la jsp d'affichage des clients
     */
    @RequestMapping(value = "/admin/listeClients/ajouterClient", method = RequestMethod.GET)
    public String allerACreation(final ModelMap pModel) {
        CreationClientForm creationFormClient = new CreationClientForm();
        pModel.addAttribute("creationForm", creationFormClient);
        return ("ajouterClient");
    }
}
