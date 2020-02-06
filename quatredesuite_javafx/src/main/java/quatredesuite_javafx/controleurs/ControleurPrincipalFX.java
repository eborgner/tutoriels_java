package quatredesuite_javafx.controleurs;

import commun.debogage.J;
import commun.systeme.Systeme;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import quatredesuite_client.commandes.ouvrir_parametres.OuvrirParametres;
import quatredesuite_client.commandes.ouvrir_parametres.OuvrirParametresRecue;
import quatredesuite_client.commandes.quitter.Quitter;
import quatredesuite_client.commandes.quitter.QuitterRecue;
import quatredesuite_client.controleurs.ControleurPrincipal;
import quatredesuite_javafx.vues.VuePrincipaleFX;

public class ControleurPrincipalFX extends ControleurPrincipal<VuePrincipaleFX> {

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(Quitter.class, new RecepteurCommandeMVC<QuitterRecue>() {
			@Override
			public void executerCommandeMVC(QuitterRecue commande) {
				J.appel(this);
				
				Systeme.quitter();
			}
		});

		installerRecepteurCommande(OuvrirParametres.class, new RecepteurCommandeMVC<OuvrirParametresRecue>() {
			@Override
			public void executerCommandeMVC(OuvrirParametresRecue commande) {
				J.appel(this);
				
				ouvrirParametres();
			}
		});
	}
	
	private void ouvrirParametres() {
		J.appel(this);
		
	}

	@Override
	protected void demarrer() {
		J.appel(this);
		
	}

}
