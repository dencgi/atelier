package dad.atelier2.joueur;

import dad.atelier2.carte.Carte;
import dad.atelier2.exception.MainPleineException;

public class Joueur {

	private String nom;
	private Main main;

	public Joueur(String nom) {
		this.nom = nom;
		main = new Main();
	}

	public void recevoirCarte(Carte carte) throws MainPleineException {
		main.add(carte);
	}

	public void montrerMain() {
		System.out.println(main.toString());
	}
	
	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ",\n main=" + main + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Main getMain() {
		return main;
	}

}
