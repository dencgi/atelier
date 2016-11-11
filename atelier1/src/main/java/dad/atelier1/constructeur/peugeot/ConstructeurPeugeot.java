package dad.atelier1.constructeur.peugeot;

import java.lang.reflect.Constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dad.atelier1.constructeur.CleVoiture;
import dad.atelier1.constructeur.ConstructeurAutomobile;
import dad.atelier1.constructeur.ConstructeurCle;
import dad.atelier1.voiture.Voiture;

@Service
public class ConstructeurPeugeot implements ConstructeurAutomobile<ModelePeugeot> {

	private static int sequenceNumeroSerie = 0;

	@Autowired
	private ConstructeurCle constructeurCle;

	@Override
	public CleVoiture fabriquerVoiture(ModelePeugeot modele) {
		try {
			Class<?> maClasse = Class.forName(modele.getClasse());
			Constructor<?> monConstructeur = maClasse.getConstructor(String.class, String.class);
			String cle = constructeurCle.getCle();
			Voiture maVoiture = (Voiture) monConstructeur.newInstance(cle, String.valueOf(++sequenceNumeroSerie));
			return new CleVoiture(cle, maVoiture);
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}

}
