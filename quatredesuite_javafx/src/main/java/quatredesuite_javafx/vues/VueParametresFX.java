package quatredesuite_javafx.vues;

import commun.debogage.J;
import quatredesuite_client.vues.VueParametres;

public class VueParametresFX implements VueParametres {

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
	}

}
