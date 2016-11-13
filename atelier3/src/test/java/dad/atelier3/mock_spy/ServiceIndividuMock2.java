package dad.atelier3.mock_spy;

import javax.naming.OperationNotSupportedException;

import org.springframework.stereotype.Service;

import dad.atelier3.model.Individu;
import dad.atelier3.service.ServiceIndividu;

@Service
public class ServiceIndividuMock2 extends ServiceIndividu {

	private Individu individu;

	@Override
	public Individu remplacer(String refIndividu, String commande) throws OperationNotSupportedException {
		return individu;
	}

	@Override
	public Individu ajouter(String refIndividu, String commande) throws OperationNotSupportedException {
		return individu;
	}

}
