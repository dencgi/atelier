package dad.atelier3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dad.atelier3.dto.FormulaireDTO;
import dad.atelier3.model.Individu;
import dad.atelier3.service.ServiceIndividu;

@Controller
public class MonControleur {

	@Autowired
	private ServiceIndividu serviceIndividu;

	public void traiterAction(FormulaireDTO form) {
		String idRef = getIdRef(form.getSessionId());
		Individu individu = serviceIndividu.find(idRef);
		// Je fais plein de choses avec mon individu.
		System.out.println(individu);
	}

	private String getIdRef(String jSessionId) {
		if (jSessionId == null) {
			throw new NullPointerException("jSessionId is null");
		}
		return "idRef-" + jSessionId;
	}
}
