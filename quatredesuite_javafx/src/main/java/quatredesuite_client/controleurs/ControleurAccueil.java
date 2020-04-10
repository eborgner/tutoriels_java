package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurVue;
import quatredesuite_client.vues.VueAccueil;

public abstract class ControleurAccueil<V extends VueAccueil> extends ControleurVue<V> {
	
	
	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
		
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
		
	}
	
}
