package net.atos.projetFinal.service;

import net.atos.projetFinal.exception.InvalidUserRole;
import net.atos.projetFinal.model.Employe;
import net.atos.projetFinal.model.Role;
import net.atos.projetFinal.repo.EmployeRepository;
import net.atos.projetFinal.service.auth.UserService;
import net.atos.projetFinal.utils.RoleEmploye;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUtilisateurService {
    private static boolean dataLoaded = false;
    @Autowired
    private EmployeRepository employeRepository;
    
    @Autowired
    private UserService userService;
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Test
    public void testCreationUtilisateurAInexistant() throws InvalidUserRole {
        Employe user = new Employe();
        Role role = new Role();
        user.setNom("Admin");
        user.setPrenom("Test");
        user.setUsername("admin1234test");
        user.setEmail("admintest@gmail.com");
        user.setPassword("admin1234test");
        user.setPasswordConfirm("admin1234test");
        role.setNom(RoleEmploye.admin);
        user.setRole(role);
        
        Employe userCreated = userService.save(user);
        
        Assert.assertNotNull(userCreated);
        Assert.assertEquals(userCreated, user);
        Assert.assertEquals(userCreated.getPassword(), user.getPassword());
        Assert.assertEquals(userCreated.getCreate_time(), user.getCreate_time());
        Assert.assertEquals(userCreated.getRole().getNom(), user.getRole().getNom());
    }
    
    @Test(expected = DataIntegrityViolationException.class)
    public void testCreationUtilisateurBExistant() throws InvalidUserRole {
        Employe user = new Employe();
        Role role = new Role();
        user.setNom("Admin");
        user.setPrenom("Test");
        user.setUsername("admin1234test");
        user.setEmail("admintest@gmail.com");
        user.setPassword("admin1234test");
        user.setPasswordConfirm("admin1234test");
        role.setNom(RoleEmploye.admin);
        user.setRole(role);
        
        userService.save(user);
        dataLoaded = true;
    }
    
    @Test(expected = InvalidUserRole.class)
    public void testCreationUtilisateurRoleNonValide() throws InvalidUserRole {
        Employe user = new Employe();
        user.setNom("Admin");
        user.setPrenom("Test");
        user.setUsername("admin1234test");
        user.setEmail("admintest@gmail.com");
        user.setPassword("admin1234test");
        user.setPasswordConfirm("admin1234test");
        user.setRole(null);
        
        userService.save(user);
    }
    
    @After
    public void clean() {
        if (dataLoaded) {
            Employe employe1 = employeRepository.findByUsername("admin1234test");
            employeRepository.deleteById(employe1.getId());
            dataLoaded = false;
        }
    }
}