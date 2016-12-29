package dad.atelier3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_individu")
public class Individu {

	@Id
	@Column(name = "id_ref")
	private String idRef;
	@Column
	private Type type;
	@Column(name = "id_interimaire")
	private String idInterimaire;
	@Column(name = "id_candidat")
	private String idCandidat;
	@Column
	private String nom;
	@Column
	private String prenom;

	public enum Type {
		INTERIMAIRE, CANDIDAT;
	}

	public Individu() {
		super();
	}

	public Individu(Individu ind) {
		this.idRef = ind.idRef;
		this.type = ind.type;
		this.idInterimaire = ind.idInterimaire;
		this.idCandidat = ind.idCandidat;
		this.nom = ind.nom;
		this.prenom = ind.prenom;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Individu [idRef=" + idRef + ", type=" + type + ", idInterimaire=" + idInterimaire + ", idCandidat=" + idCandidat + ", nom=" + nom + ", prenom="
				+ prenom + "]";
	}

}
