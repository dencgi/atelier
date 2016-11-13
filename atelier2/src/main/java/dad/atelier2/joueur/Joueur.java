package dad.atelier2.joueur;

import dad.atelier2.carte.Carte;

public class Joueur {

	private String nom;
	private Main main;

	public Joueur(String nom) {
		this.nom = nom;
		main = new Main();
	}

	public void recevoirCarte(Carte carte) {
		main.add(carte);
	}

	public Main montrerMain() {
		return new Main(main);
	}

	public void jeterMain() {
		main = new Main();
	}

	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", main=" + main + "]\n";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
