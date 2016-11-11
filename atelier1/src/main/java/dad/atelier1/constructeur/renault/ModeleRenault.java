package dad.atelier1.constructeur.renault;

import dad.atelier1.constructeur.ModeleVoiture;

public enum ModeleRenault implements ModeleVoiture {

	R5("R5", "Renault", 50, "dad.atelier1.constructeur.renault.voiture.R5", 0.05);

	private String nom;
	private String constructeurAutomobile;
	private int capaciteMax;
	private String classe;
	private double consommation;

	private ModeleRenault(String nom, String constructeurAutomobile, int capaciteMax, String classe, double consommation) {
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
