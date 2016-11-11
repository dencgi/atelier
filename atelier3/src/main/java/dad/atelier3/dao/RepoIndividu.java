package dad.atelier3.dao;

import org.springframework.stereotype.Repository;

import dad.atelier3.model.Individu;

@Repository
public class RepoIndividu {

	public Individu find(String idIndividu) {
		// On fait plein de choses avec l'idIndividu, comme recherché en base.
		System.out.println("On fait plein de choses avec l'idIndividu : " + idIndividu);

		Individu individuTrouve = new Individu();
		individuTrouve.setIdRef(idIndividu);

		// On détermine s'il s'agit d'un intérimaire ou d'un candidat.
		if ((int) (Math.random() * 2) == 1) {
			individuTrouve.setIdInterimaire("idInterimaire-hfjdsk");
			individuTrouve.setType(Individu.Type.INTERIMAIRE);
		} else {
			individuTrouve.setIdCandidat("idCondidat-vcxnvbcx");
			individuTrouve.setType(Individu.Type.CANDIDAT);
		}

		return individuTrouve;
	}
}
