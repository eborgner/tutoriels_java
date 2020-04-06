package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurVue;
import quatredesuite_client.vues.VuePrincipale;

public abstract class ControleurPrincipal<V extends VuePrincipale> extends ControleurVue<V> {
	
	
	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
		
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
		
	}
	
}
