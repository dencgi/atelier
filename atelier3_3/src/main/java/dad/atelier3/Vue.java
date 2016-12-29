package dad.atelier3;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dad.atelier3.model.Individu;
import dad.atelier3.service.ServiceIndividu;

@RestController
public class Vue {

	@Resource
	private ServiceIndividu serviceIndividu;

	@RequestMapping("/individu/{id}")
	public Individu getIndividu(@PathVariable String id) {
		return serviceIndividu.getIndividu(id);
	}

	@RequestMapping("/interimaire/{id}")
	public Individu getInterimaire(@PathVariable String id) {
		return serviceIndividu.getInterimaire(id);
	}

	@RequestMapping("/candidat/{id}")
	public Individu getCandidat(@PathVariable String id) {
		return serviceIndividu.getCandidat(id);
	}

}
