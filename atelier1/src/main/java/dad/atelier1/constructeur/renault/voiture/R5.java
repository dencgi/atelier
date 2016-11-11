package dad.atelier1.constructeur.renault.voiture;

import dad.atelier1.constructeur.renault.ModeleRenault;
import dad.atelier1.voiture.AbstractVoiture;
import dad.atelier1.voiture.Voiture;

public class R5 extends AbstractVoiture implements Voiture {

	public R5(String cle, String numeroSerie) {
		super(ModeleRenault.R5, cle, numeroSerie);
	}
}
