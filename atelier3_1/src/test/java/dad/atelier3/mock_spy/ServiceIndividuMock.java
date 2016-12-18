package dad.atelier3.mock_spy;

import org.springframework.stereotype.Service;

import dad.atelier3.model.Individu;
import dad.atelier3.service.ServiceIndividu;

@Service
public class ServiceIndividuMock extends ServiceIndividu {

	@Override
	public Individu remplacer(String refIndividu, String commande) {
		return null;
	}

	@Override
	public Individu ajouter(String refIndividu, String commande) {
		return null;
	}

}
