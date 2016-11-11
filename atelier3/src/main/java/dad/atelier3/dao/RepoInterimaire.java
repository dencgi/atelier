package dad.atelier3.dao;

import org.springframework.stereotype.Repository;

import dad.atelier3.model.Individu;

@Repository
public class RepoInterimaire {

	public Individu find(Individu interimaireRecherche) {
		String idInterimaire = interimaireRecherche.getIdInterimaire();
		// On fait plein de choses avec l'idInterimaire, comme recherché en base.
		System.out.println("On fait plein de choses avec l'idInterimaire : " + idInterimaire);

		Individu interimaireTrouve = new Individu(interimaireRecherche);
		interimaireTrouve.setNom("Interim");
		interimaireTrouve.setType(Individu.Type.INTERIMAIRE);
		return interimaireTrouve;
	}

}
