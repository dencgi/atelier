package dad.atelier1.constructeur.peugeot;

import dad.atelier1.constructeur.ModeleVoiture;

public enum ModelePeugeot implements ModeleVoiture {

	P305("305", "Peugeot", 50, "dad.atelier1.constructeur.peugeot.voiture.P305", 0.07),
	P306("306", "Peugeot", 55, "dad.atelier1.constructeur.peugeot.voiture.P306", 0.02),
	P307("307", "Peugeot", 32, "dad.atelier1.constructeur.peugeot.voiture.P307", 0.04);

	private String nom;
	private String constructeurAutomobile;
	private int capaciteMax;
	private String classe;
	private double consommation;

	private ModelePeugeot(String nom, String constructeurAutomobile, int capaciteMax, String classe, double consommation) {
		this.nom = nom;
		this.constructeurAutomobile = constructeurAutomobile;
		this.capaciteMax = capaciteMax;
		this.classe = classe;
		this.consommation = consommation;
	}

	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public String getConstructeurAutomobile() {
		return constructeurAutomobile;
	}

	@Override
	public int getCapaciteReservoire() {
		return capaciteMax;
	}

	@Override
	public String getClasse() {
		return classe;
	}

	@Override
	public double getConsommation() {
		return consommation;
	}

}
