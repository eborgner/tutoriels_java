package pong_javafx.vues;

import commun.debogage.J;
import pong_client.vues.VuePrincipale;

public class VuePrincipaleFX implements VuePrincipale {

	@Override
	public void obtenirCommandes() {
		J.appel(this);
		
	}

	@Override
	public void installerCapteurs() {
		J.appel(this);
		
	}

}
