package dad.atelier3.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dad.atelier3.controller.MonControleur;
import dad.atelier3.dto.FormulaireDTO;
import dad.atelier3.mock_manuel.config.Config_4_MockAutowired;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config_4_MockAutowired.class)
public class ServiceIndividuTest_4_MockAutowired {

	@Autowired
	private MonControleur controleur;

	@Test
	public void controleurTest() {
		FormulaireDTO form = new FormulaireDTO();
		form.setSessionId("jsessionid-78976");
		controleur.traiterAction(form);
	}

}
