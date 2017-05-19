package dad.atelier3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_individu")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCandidat == null) ? 0 : idCandidat.hashCode());
		result = prime * result + ((idInterimaire == null) ? 0 : idInterimaire.hashCode());
		result = prime * result + ((idRef == null) ? 0 : idRef.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Individu other = (Individu) obj;
		if (idCandidat == null) {
			if (other.idCandidat != null)
				return false;
		} else if (!idCandidat.equals(other.idCandidat))
			return false;
		if (idInterimaire == null) {
			if (other.idInterimaire != null)
				return false;
		} else if (!idInterimaire.equals(other.idInterimaire))
			return false;
		if (idRef == null) {
			if (other.idRef != null)
				return false;
		} else if (!idRef.equals(other.idRef))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
