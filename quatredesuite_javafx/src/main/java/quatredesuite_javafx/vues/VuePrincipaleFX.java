package quatredesuite_javafx.vues;

import commun.debogage.J;
import quatredesuite_client.vues.VuePrincipale;

public class VuePrincipaleFX implements VuePrincipale {

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
	}

}
