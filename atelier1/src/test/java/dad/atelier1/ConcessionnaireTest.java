package dad.atelier1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dad.atelier1.constructeur.CleVoiture;
import dad.atelier1.constructeur.peugeot.ModelePeugeot;
import dad.atelier1.constructeur.peugeot.voiture.P305;
import dad.atelier1.constructeur.renault.ConstructeurRenault;
import dad.atelier1.constructeur.renault.ModeleRenault;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "../../application-context.xml")
public class ConcessionnaireTest {

	@Autowired
	private Concessionnaire concessionnaire;

	@Test
	public void commanderPeugeotTest() {
		assertEquals(ModelePeugeot.P305, concessionnaire.commanderVoiture(ModelePeugeot.P305).getVoiture().getModele());
	}

	@Test
	public void commanderRenautTest() {
		concessionnaire.setRenault(new ConstructeurRenault() {
			@Override
			public CleVoiture fabriquerVoiture(ModeleRenault modele) {
				return new CleVoiture("toto", new P305("tata", "tutu"));
			}
		});
		assertEquals(ModelePeugeot.P305, concessionnaire.commanderVoiture(ModeleRenault.R5).getVoiture().getModele());
	}

}
