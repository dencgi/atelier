package dad.atelier2.joueur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import dad.atelier2.carte.Carte;
import dad.atelier2.exception.MainPleineException;

public class Main implements Iterable<Carte> {

	private static final int TAILLE_MAX = 5;

	private List<Carte> main = new ArrayList<>();

	public void add(Carte carte) throws MainPleineException {
		if (main.size() >= TAILLE_MAX) {
			throw new MainPleineException();
		}
		main.add(carte);
	}
	
	public boolean isMainPleine() {
		return main.size() == TAILLE_MAX;
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
