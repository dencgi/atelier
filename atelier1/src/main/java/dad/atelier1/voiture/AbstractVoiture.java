package dad.atelier1.voiture;

import java.text.MessageFormat;

import dad.atelier1.constructeur.ModeleVoiture;
import dad.atelier1.util.Messages;

public class AbstractVoiture implements Voiture {

	protected ModeleVoiture modele;
	protected boolean moteurEnMarche = false;
	protected int kilometrage = 0;
	protected Reservoire reservoire;
	protected String cle;
	protected String numeroSerie;

	protected AbstractVoiture(ModeleVoiture modele, String cle, String numeroSerie) {
		this.modele = modele;
		this.cle = cle;
		this.numeroSerie = numeroSerie;
		reservoire = new Reservoire(modele.getCapaciteReservoire());
	}

	@Override
	public ModeleVoiture getModele() {
		return modele;
	}

	@Override
	public void demarrer(String cle) {
		if (reservoire.isVide()) {
			System.out.println(Messages.getString("voiture.reservoireVide")); //$NON-NLS-1$
		} else if (!this.cle.equals(cle)) {
			System.out.println(Messages.getString("voiture.mauvaiseCle")); //$NON-NLS-1$
		} else {
			moteurEnMarche = true;
			System.out.println(Messages.getString("voiture.demarree")); //$NON-NLS-1$
		}
	}

	@Override
	public void arreter() {
		moteurEnMarche = false;
		System.out.println(Messages.getString("voiture.arretee")); //$NON-NLS-1$
	}

	@Override
	public void rouler(int distance) {
		distance = Math.abs(distance);
		if (moteurEnMarche) {
			double manque = reservoire.vider(distance * modele.getConsommation());
			if (manque == 0) {
				kilometrage += distance;
			} else {
				kilometrage += distance - (manque * modele.getConsommation());
				arreter();
			}
		}
		System.out.println(MessageFormat.format(Messages.getString("voiture.kilometrage"), kilometrage)); //$NON-NLS-1$
	}

	@Override
	public void remplirReservoir(int litre) {
		System.out.println(MessageFormat.format(Messages.getString("voiture.reservoireRempli"), reservoire.remplir(litre))); //$NON-NLS-1$
	}

	@Override
	public String toString() {
		return "AbstractVoiture [modele=" + modele + ", moteurEnMarche=" + moteurEnMarche + ", kilometrage=" + kilometrage + ", reservoire=" + reservoire + ", cle=" + cle + ", numeroSerie=" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
				+ numeroSerie + "]"; //$NON-NLS-1$
	}

}
