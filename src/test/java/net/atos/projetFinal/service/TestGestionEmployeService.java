package net.atos.projetFinal.service;

import net.atos.projetFinal.exception.InvalidUserRole;
import net.atos.projetFinal.model.Employe;
import net.atos.projetFinal.model.Role;
import net.atos.projetFinal.repo.EmployeRepository;
import net.atos.projetFinal.utils.RoleEmploye;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGestionEmployeService {
    private static boolean dataCleaned = false;
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private GestionEmployeService gestionEmployeService;
    
    @Test
    public void testCreationEmployeAInexistant() throws InvalidUserRole {
        Employe employe = new Employe();
        Role role = new Role();
        employe.setNom("commercial");
        employe.setPrenom("Test");
        employe.setUsername("commercial1test");
        employe.setEmail("commercial1test@gmail.com");
        role.setNom(RoleEmploye.commercial);
        employe.setRole(role);
        
        Employe employeCreated = gestionEmployeService.creerEmploye(employe);
        Assert.assertNotNull(employeCreated);
        Assert.assertEquals(employeCreated, employe);
        Assert.assertEquals(employeCreated.getCreate_time(), employe.getCreate_time());
        Assert.assertEquals(employeCreated.getRole().getNom(), employe.getRole().getNom());
        Assert.assertNotNull(employeCreated.getPassword());
        Assert.assertNotNull(employeCreated.getPasswordConfirm());
    }
    
    @Test(expected = InvalidUserRole.class)
    public void testCreationEmployeParamsNull() throws InvalidUserRole {
        Employe employe = new Employe();
        gestionEmployeService.creerEmploye(employe);
    }
    
    @Test(expected = DataIntegrityViolationException.class)
    public void testCreationEmployeParamsNullExceptRole() throws InvalidUserRole {
        Employe employe = new Employe();
        Role role = new Role();
        role.setNom(RoleEmploye.magasinier);
        employe.setRole(role);
        gestionEmployeService.creerEmploye(employe);
    }
    
    @After
    public void clean() {
        if (dataCleaned) {
            Employe employe1 = employeRepository.findByUsername("commercial1test");
            employeRepository.deleteById(employe1.getId());
            dataCleaned = false;
        }
    }
}
