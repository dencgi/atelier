package dad.atelier1.voiture;

import dad.atelier1.constructeur.ModeleVoiture;

public interface Voiture {

	ModeleVoiture getModele();

	void demarrer(String cle);

	void arreter();

	void rouler(int distance);

	void remplirReservoir(int litre);
}
