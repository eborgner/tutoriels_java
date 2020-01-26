package commun_client.structure;

import commun.debogage.J;
import commun.structure.Modele;

public abstract class Controleur<M extends Modele> {
	
	protected M modele;
	
	public Controleur(M modele) {
		J.appel(this);

		this.modele = modele;
		
	}
	
	public abstract void installerCapteursEvenement();

	public abstract void detruire();
	
	// capte les événements et modifie le modèle en
	// appelant les méthodes publiques

}
