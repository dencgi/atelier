package dad.atelier2.carte;

import dad.atelier2.exception.NoNextValueException;

public enum Valeur {

	DEUX("2"), TROIS("3"), QUATRE("4"), CINQ("5"), SIX("6"), SEPT("7"), HUIT("8"), NEUF("9"), DIX("10"), VALET("V"), DAME("D"), ROI("R"), AS("A");

	private String nom;

	private Valeur(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return nom;
	}

	public Valeur suivant() throws NoNextValueException {
		try {
			return values()[this.ordinal() + 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new NoNextValueException(e);
		}
	}

	public Valeur precedent() throws NoNextValueException {
		if (this.ordinal() - 1 < 0) {
			throw new NoNextValueException();
		}
		return values()[this.ordinal() - 1];
	}
}
