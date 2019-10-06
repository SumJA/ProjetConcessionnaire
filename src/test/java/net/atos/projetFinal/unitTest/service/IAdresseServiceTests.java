/**
 * MIT License

Copyright (c) [2019] [Sumaira JAVAID, Nils VO-VAN, Kamel TRABELSI, Jerome BRUNA]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package net.atos.projetFinal.unitTest.service;

import net.atos.projetFinal.model.Adresse;
import net.atos.projetFinal.repo.AdresseRepository;
import net.atos.projetFinal.service.IAdresseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test du service {@link IAdresseService}
 * 
 * @author Sumaira JAVAID
 * @author Emilie PANIAGUA
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class IAdresseServiceTests {
	@MockBean
	AdresseRepository adresseRepository;

	@InjectMocks
    IAdresseService IAdresseService;
	
	/**
	 * On invoque la {@code MockitoAnnotations.initMocks()} pour utiliser nos Mocks
	 */
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);

	}

	/**
	 * Test de la création d'une nouvelle Adresse via la méthode
	 * {@link IAdresseService#creerAdresse(Adresse)}
	 * 
	 * <p>
	 * 
	 * La méthode vérifie que la méthode
	 * {@link IAdresseService#creerAdresse(Adresse)} renvoie la même Adresse que
	 * celle que l'on souhaite créer.
	 * 
	 */
	@Test
	public void creationDAdresseRenvoieLaMemeAdresse() {
		Adresse adresseACreer = new Adresse();
		adresseACreer.setNumeroVoie((10));
		adresseACreer.setLibelleVoie("Downing Street");
		adresseACreer.setCodePostal("UK9999");
		adresseACreer.setVille("Londres");
        
        when(IAdresseService.creerAdresse(new Adresse())).thenReturn(new Adresse());
        assertEquals(IAdresseService.creerAdresse(adresseACreer), Adresse.class);
        
        Adresse adresseCreee = IAdresseService.creerAdresse(adresseACreer);

		assertThat(adresseCreee.getNumeroVoie()).isSameAs(adresseACreer.getNumeroVoie());
		assertThat(adresseCreee.getLibelleVoie()).isSameAs(adresseACreer.getLibelleVoie());
		assertThat(adresseCreee.getCodePostal()).isSameAs(adresseACreer.getCodePostal());
		assertThat(adresseCreee.getVille()).isSameAs(adresseACreer.getVille());
	}
}
