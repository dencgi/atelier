package dad.atelier2.carte;

final public class Carte implements Comparable<Carte> {

	private final Couleur couleur;
	private final Valeur valeur;

	public Carte(Couleur couleur, Valeur valeur) {
		super();
		this.couleur = couleur;
		this.valeur = valeur;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public Valeur getValeur() {
		return valeur;
	}

	public String toString() {
		return valeur.toString() + "-" + couleur.toString();
	}

	@Override
	public int compareTo(Carte other) {
		if (other == null) {
			return -1;
		} else if (this.valeur != other.valeur) {
			return this.valeur.compareTo(other.valeur);
		} else {
			return this.couleur.compareTo(other.couleur);
		}
	}

}
