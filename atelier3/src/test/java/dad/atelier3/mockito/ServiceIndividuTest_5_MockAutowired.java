package dad.atelier3.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import dad.atelier3.controller.MonControleur;
import dad.atelier3.dto.FormulaireDTO;
import dad.atelier3.model.Individu;
import dad.atelier3.service.ServiceIndividu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")
public class ServiceIndividuTest_5_MockAutowired {

	@Autowired
	private MonControleur controleur;
	
	@Test
	public void controleurTest() {
		// Création du mock.
		ServiceIndividu serviceIndividu = new ServiceIndividu() {
			@Override
			public Individu find(String idRef) {
				System.out.println("Mock serviceIndividu !");
				return new Individu();
			}
		};
		// Injection du mock dans l'objet.
		ReflectionTestUtils.setField(controleur, "serviceIndividu", serviceIndividu);
		
		FormulaireDTO form = new FormulaireDTO();
		form.setSessionId("jsessionid-78976");
		controleur.traiterAction(form);
	}

}
