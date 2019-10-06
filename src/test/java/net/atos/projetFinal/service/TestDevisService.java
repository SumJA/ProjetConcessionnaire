package net.atos.projetFinal.service;

import net.atos.projetFinal.model.Devis;
import net.atos.projetFinal.model.Status;
import net.atos.projetFinal.repo.DevisRepository;
import net.atos.projetFinal.repo.StatusRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDevisService {
    @Autowired
    private DevisService devisService;
    
    @Autowired
    private DevisRepository devisRepository;
    
    @Autowired
    private StatusRepository statusRepository;
    
    @Before
    public void executeAvantChaque() {
        Devis devis = new Devis();
        Status statusInitDevis = new Status();
        statusInitDevis.setNom("test");
        devis.setStatus(statusInitDevis);
        devisRepository.saveAndFlush(devis);
        Status status = new Status();
        status.setNom("commande livre test");
        statusRepository.saveAndFlush(status);
        System.out.println("@BeforeEach");
    }
    
    @Test
    public void testMettreAJourStatut() {
//        Long idDevis = (long) devisRepository.findAll().size();
//        Optional<Status> statut = statusRepository.findByName("commande livre test");
//        Devis devis =
//        Devis devisAJour = devisService.mettreAJourStatut(statut.get(), devis);
//        Assert.assertNotNull("Statut du devis mis à jour est null", devisAJour);
//        Assert.assertEquals("Statut du devis n'est pas égales aux statut ciblé", devisAJour.getStatus(), statut.get
//        ());
    }
    
    @After
    public void executeApresChaque() {
        Status statut = statusRepository.findByName("commande livre test").get();
        statusRepository.deleteById(statut.getId());
        System.out.println("@AfterEach");
    }
}