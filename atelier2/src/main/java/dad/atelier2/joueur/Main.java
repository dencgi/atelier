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

	private List<Carte> main = new ArrayList<>();

	public Main() {
	}

	public Main(Main other) {
		for (Carte carte : other) {
			add(carte);
		}
	}

	public void add(Carte carte) {
		if (main.size() >= TAILLE_MAX) {
			throw new MainPleineException();
		}
		main.add(carte);
	}

	public boolean isPleine() {
		return main.size() == TAILLE_MAX;
	}

	public boolean isVide() {
		return main.size() == TAILLE_VIDE;
	}

	public void trier() {
		Collections.sort(main);
	}

	@Override
	public String toString() {
		return main.toString();
	}

	@Override
	public Iterator<Carte> iterator() {
		return main.iterator();
	}

}
