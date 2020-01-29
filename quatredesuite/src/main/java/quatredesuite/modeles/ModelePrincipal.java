package quatredesuite.modeles;

import commun.debogage.J;
import commun.mvc.Modele;
import quatredesuite.modeles.partie.Partie;

public class ModelePrincipal extends Modele {

	public Partie nouvellePartieLocale() {
		J.appel(this);

		return new Partie();
	}

}
