package dad.atelier1;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dad.atelier1.constructeur.CleVoiture;
import dad.atelier1.constructeur.peugeot.ConstructeurPeugeot;
import dad.atelier1.constructeur.peugeot.ModelePeugeot;
import dad.atelier1.constructeur.renault.ConstructeurRenault;
import dad.atelier1.constructeur.renault.ModeleRenault;

@Service
public class Concessionnaire {

	@Resource
	private ConstructeurPeugeot peugeot;

	@Resource
	private ConstructeurRenault renault;

	public CleVoiture commanderVoiture(ModelePeugeot modele) {
		return peugeot.fabriquerVoiture(modele);
	}

	public CleVoiture commanderVoiture(ModeleRenault modele) {
		return renault.fabriquerVoiture(modele);
	}

	public void setRenault(ConstructeurRenault renault) {
		this.renault = renault;
	}
	
}
