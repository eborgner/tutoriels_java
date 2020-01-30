package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.RecepteurCommande;
import commun_client.mvc.controleurs.ControleurVue;
import quatredesuite_client.commandes.nouvelle_partie_locale.NouvellePartieLocale;
import quatredesuite_client.commandes.nouvelle_partie_locale.NouvellePartieLocaleRecue;
import quatredesuite_client.vues.VuePrincipale;

public abstract class ControleurPrincipal extends ControleurVue<VuePrincipale> {
	
	@Override
	public void installerReceptionCommandes() {
		J.appel(this);
		
		FabriqueCommande.installerRecepteur(NouvellePartieLocale.class, new RecepteurCommande<NouvellePartieLocaleRecue>() {
			@Override
			public void executerCommande(NouvellePartieLocaleRecue commande) {
				J.appel(this);
				nouvellePartieLocale(commande);
			}
		});
	}
	
	protected abstract void nouvellePartieLocale(NouvellePartieLocaleRecue commande);


	@Override
	public void demarrer() {
		J.appel(this);
		
		// rien; à moins qu'on démarrer un AnimationTimer pour lancer
		//       des commandes ReagirAuTempsQuiPasse

	} 
	
}
