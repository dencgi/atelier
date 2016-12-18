package dad.atelier3.mock_spy;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dad.atelier3.model.Individu;
import dad.atelier3.service.ServiceIndividu;

@Service
public class ServiceIndividuSpy extends ServiceIndividu {

	@Resource
	private ServiceIndividu serviceIndividu;

	public Individu remplacer(String refIndividu, String commande) {
		return serviceIndividu.remplacer(refIndividu, commande);
	}

	public Individu ajouter(String refIndividu, String commande) {
		return serviceIndividu.ajouter(refIndividu, commande);
	}

}
