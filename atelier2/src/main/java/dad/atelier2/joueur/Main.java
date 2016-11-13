package dad.atelier2.joueur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import dad.atelier2.carte.Carte;
import dad.atelier2.exception.MainPleineException;

public class Main implements Iterable<Carte> {

	private static final int TAILLE_VIDE = 0;
	private static final int TAILLE_MAX = 5;

	private List<Carte> cartes = new ArrayList<>();

	public Main() {
		super();
	}

	public Main(Main other) {
		for (Carte carte : other) {
			add(carte);
		}
	}

	public void add(Carte carte) {
		if (cartes.size() >= TAILLE_MAX) {
			throw new MainPleineException();
		}
		cartes.add(carte);
	}

	public boolean isPleine() {
		return cartes.size() == TAILLE_MAX;
	}

	public boolean isVide() {
		return cartes.size() == TAILLE_VIDE;
	}

	public void trier() {
		Collections.sort(cartes);
	}

	@Override
	public String toString() {
		return cartes.toString();
	}

	@Override
	public Iterator<Carte> iterator() {
		return cartes.iterator();
	}

}
