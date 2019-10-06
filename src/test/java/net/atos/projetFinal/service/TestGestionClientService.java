package net.atos.projetFinal.service;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.model.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Instant;
import java.time.LocalDateTime;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestGestionClientService {
    @Autowired
    private GestionClientService serviceClient;
    
    @Test
    public void TestCreerEtSupprimerClientInexistant() {
        Adresse adresse1 = new Adresse();
        adresse1.setCodePostal("69120");
        adresse1.setComplementAdresse("rien");
        adresse1.setNumeroVoie(14);
        adresse1.setLibelleVoie("Rue Bonnevay");
        adresse1.setVille("Vaulx");
        adresse1.setPays("France");
        
        Client client1 = new Client();
        client1.setAdresse(adresse1);
        client1.setDateCreationClient(LocalDateTime.now().minusYears(50));
        client1.setDateDerniereMiseAJourClient(Instant.now());
        client1.setPrenom("Nils");
        client1.setNom("VO");
        client1.setNumeroTel("0606060606");
        client1.setEmail("zaed@dza.com");
        Client clientCreated = serviceClient.creerClient(client1);
        
        assertNotNull(clientCreated);
        Assert.assertEquals(clientCreated, client1);
    }
}
