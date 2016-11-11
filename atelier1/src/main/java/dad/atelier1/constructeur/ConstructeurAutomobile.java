package dad.atelier1.constructeur;

public interface ConstructeurAutomobile<T extends ModeleVoiture> {
	CleVoiture fabriquerVoiture(T modele);
}
