package net.atos.projetFinal;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.atos.projetFinal.auth.controller.AuthController;
import net.atos.projetFinal.controller.AdminController;

/**
 * Classe de type: JUnit Test Case
 * 
 * @author Sumaira JAVAID
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjetFinalApplicationTests {

	@Autowired
	private AuthController authController;

	@Autowired
	private AdminController adminController;

	@Test
	public void contexLoads() throws Exception {
		// On vérifie que le contexte créé nos controleurs.
		assertThat(authController).isNotNull();
		assertThat(adminController).isNotNull();

	}

}
