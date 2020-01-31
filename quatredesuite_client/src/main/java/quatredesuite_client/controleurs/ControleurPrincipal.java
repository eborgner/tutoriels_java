package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.RecepteurCommande;
import commun_client.mvc.controleurs.ControleurVue;
import quatredesuite_client.commandes.nouvelle_partie_locale.NouvellePartieLocale;
import quatredesuite_client.commandes.nouvelle_partie_locale.NouvellePartieLocaleRecue;
import quatredesuite_client.commandes.ouvrir_parametres.OuvrirParametres;
import quatredesuite_client.commandes.quitter.Quitter;
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
		
		FabriqueCommande.installerRecepteur(Quitter.class, new RecepteurCommande<Quitter>() {
			@Override
			public void executerCommande(Quitter commande) {
				J.appel(this);
				
				quitter();
			}
		});
		
		FabriqueCommande.installerRecepteur(OuvrirParametres.class, new RecepteurCommande<OuvrirParametres>() {
			@Override
			public void executerCommande(OuvrirParametres commande) {
				J.appel(this);
				
				ouvrirParametres();
			}
		});
	}
	
	protected abstract void ouvrirParametres();
	protected abstract void quitter();
	protected abstract void nouvellePartieLocale(NouvellePartieLocaleRecue commande);
}
