package dad.atelier2.carte;

public final class Carte implements Comparable<Carte> {

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

	@Override
	public String toString() {
		return valeur.toString() + "-" + couleur.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result + ((valeur == null) ? 0 : valeur.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		return couleur == other.couleur && valeur == other.valeur;
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
