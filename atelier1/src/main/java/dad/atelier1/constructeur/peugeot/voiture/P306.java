package dad.atelier1.constructeur.peugeot.voiture;

import dad.atelier1.constructeur.peugeot.ModelePeugeot;
import dad.atelier1.voiture.AbstractVoiture;
import dad.atelier1.voiture.Voiture;

public class P306 extends AbstractVoiture implements Voiture {

	public P306(String cle, String numeroSerie) {
		super(ModelePeugeot.P306, cle, numeroSerie);
	}
}
