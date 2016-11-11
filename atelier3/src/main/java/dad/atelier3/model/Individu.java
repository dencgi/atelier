package dad.atelier3.model;

public class Individu {

	private String idRef;
	private Type type;
	private String idInterimaire;
	private String idCandidat;
	private String nom;

	public enum Type {
		INTERIMAIRE, CANDIDAT;
	}

	public Individu() {

	}

	public Individu(Individu ind) {
		this.idRef = ind.idRef;
		this.type = ind.type;
		this.idInterimaire = ind.idInterimaire;
		this.idCandidat = ind.idCandidat;
		this.nom = ind.nom;
	}

	public String getIdRef() {
		return idRef;
	}

	public void setIdRef(String idRef) {
		this.idRef = idRef;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getIdInterimaire() {
		return idInterimaire;
	}

	public void setIdInterimaire(String idInterimaire) {
		this.idInterimaire = idInterimaire;
	}

	public String getIdCandidat() {
		return idCandidat;
	}

	public void setIdCandidat(String idCandidat) {
		this.idCandidat = idCandidat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Individu [idRef=" + idRef + ", type=" + type + ", idInterimaire=" + idInterimaire + ", idCandidat=" + idCandidat + ", nom=" + nom + "]";
	}

}
