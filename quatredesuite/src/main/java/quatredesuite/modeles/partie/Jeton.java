package quatredesuite.modeles.partie;

import commun.debogage.J;
import quatredesuite.enumerations.Couleur;

public class Jeton {
	
	private Couleur couleur;

	public void initialiser(Couleur couleur) {
		J.appel(this);

		this.couleur = couleur;
	}


}
