package dad.atelier1.constructeur;

import dad.atelier1.util.Couple;
import dad.atelier1.voiture.Voiture;

public class CleVoiture {
	private Couple<String, Voiture> couple;

	public CleVoiture(String cle, Voiture voiture) {
		couple = new Couple<>(cle, voiture);
	}

	public String getCle() {
		return couple.getElement1();
	}

	public Voiture getVoiture() {
		return couple.getElement2();
	}
}
