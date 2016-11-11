package dad.atelier3.mockito;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dad.atelier3.controller.MonControleur;
import dad.atelier3.dto.FormulaireDTO;
import dad.atelier3.model.Individu;
import dad.atelier3.service.ServiceIndividu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")
public class ServiceIndividuTest_1 {

	@Autowired
	private ServiceIndividu serviceIndividu;

	@Autowired
	private MonControleur monControleur;

	@Test(expected = NullPointerException.class)
	public void monControleurTest() {
		monControleur.traiterAction(new FormulaireDTO());
	}
	
	@Test
	public void serviceTest() {
		Individu ind = serviceIndividu.find("idRef-489");
		assertNotNull("L'individu est null !", ind);
	}

}
