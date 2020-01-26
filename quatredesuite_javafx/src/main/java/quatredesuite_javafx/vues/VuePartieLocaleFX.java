package quatredesuite_javafx.vues;

import commun.debogage.J;
import quatredesuite_client.vues.VuePartieLocale;

public class VuePartieLocaleFX implements VuePartieLocale {

	@Override
	public void creerEvenements() {
		J.appel(this);

	}

	@Override
	public void installerListeners() {
		J.appel(this);
		
	}

}
