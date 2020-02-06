package quatredesuite_javafx.controleurs;

import commun.debogage.J;
import quatredesuite_client.controleurs.ControleurPrincipal;
import quatredesuite_javafx.vues.VuePrincipaleFX;

public class ControleurPrincipalFX extends ControleurPrincipal<VuePrincipaleFX> {

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
	}

	@Override
	protected void demarrer() {
		J.appel(this);
		
	}

}
