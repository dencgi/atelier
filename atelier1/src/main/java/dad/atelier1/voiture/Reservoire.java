package dad.atelier1.voiture;

public class Reservoire {

	private static final int CAPACITE_MIN = 0;
	private final int CAPACITE_MAX;
	private double capaciteActuelle = CAPACITE_MIN;

	public Reservoire(int capaciteMax) {
		this.CAPACITE_MAX = capaciteMax;
	}

	public int getCapaciteMax() {
		return CAPACITE_MAX;
	}

	public double getCapaciteActuelle() {
		return capaciteActuelle;
	}

	public double remplir(int litre) {
		double enTrop = 0;
		capaciteActuelle += litre;
		if (capaciteActuelle > CAPACITE_MAX) {
			enTrop = capaciteActuelle - CAPACITE_MAX;
			capaciteActuelle = CAPACITE_MAX;
		}
		return enTrop;
	}

	public double vider(double litre) {
		double manque = 0;
		capaciteActuelle -= litre;
		if (capaciteActuelle < CAPACITE_MIN) {
			manque = CAPACITE_MIN - capaciteActuelle;
			capaciteActuelle = CAPACITE_MIN;
		}
		return manque;
	}

	public boolean isVide() {
		return capaciteActuelle == CAPACITE_MIN;
	}

	public boolean isPlein() {
		return capaciteActuelle == CAPACITE_MAX;
	}

	@Override
	public String toString() {
		return "Reservoire [capaciteMax=" + CAPACITE_MAX + ", capaciteActuelle=" + capaciteActuelle + "]";
	}

}
