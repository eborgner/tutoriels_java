package quatredesuite.modeles;

import commun.debogage.J;
import commun.mvc.Modele;

public class ModelePrincipal extends Modele {

	public ModelePartieLocale nouvellePartieLocale() {
		J.appel(this);

		return new ModelePartieLocale();
	}

}
