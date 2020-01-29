package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.commandes.ReactionApresCommande;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.RecepteurCommande;
import commun_client.mvc.controleurs.ControleurVue;
import commun_client.mvc.controleurs.FabriqueControleur;
import quatredesuite.modeles.partie.Partie;
import quatredesuite_client.afficheurs.AfficheurPartie;
import quatredesuite_client.commandes.nouvelle_partie_locale.NouvellePartieLocale;
import quatredesuite_client.commandes.nouvelle_partie_locale.NouvellePartieLocaleRecue;
import quatredesuite_client.commandes.vider_grille.ViderGrille;
import quatredesuite_client.commandes.vider_grille.ViderGrillePourEnvoi;
import quatredesuite_client.vues.VuePartieLocale;
import quatredesuite_client.vues.VuePrincipale;

public abstract class ControleurPrincipal extends ControleurVue<VuePrincipale> {
	
	// FIXME: va uniquement dans FX  (Android, c'est l'Activité qui est propriétaire du controleur)
	protected ControleurPartieLocale controleurPartieLocale;

	@Override
	public void installerReceptionCommandes() {
		J.appel(this);
		
		FabriqueCommande.installerRecepteur(NouvellePartieLocale.class, new RecepteurCommande<NouvellePartieLocaleRecue>() {
			@Override
			public void executerCommande(NouvellePartieLocaleRecue commande) {
				J.appel(this);
				
				// FIXME
				if(controleurPartieLocale != null) {
					FabriqueCommande.installerReactionApresCommande(ViderGrille.class, new ReactionApresCommande() {
						@Override
						public void reagirApresCommande() {
							J.appel(this);

							nouvellePartieLocale();
							commande.notifierCommandeTraitee();
						}
					});
					
					ViderGrillePourEnvoi viderGrille = FabriqueCommande.obtenirCommandePourEnvoi(ViderGrillePourEnvoi.class);
					viderGrille.envoyerCommande();
					
				}else {
					
					nouvellePartieLocale();
					commande.notifierCommandeTraitee();
				}
			}
		});
		
	}
	
	protected abstract void nouvellePartieLocale();

	@Override
	public void detruire() {
		J.appel(this);

		// FIXME: c'est uniquement dans FX (Android c'est sur ActivitePartieLocale.onDestroy)
		controleurPartieLocale.detruire();
	}

	@Override
	public void demarrer() {
		J.appel(this);
		
		// rien; à moins qu'on démarrer un AnimationTimer pour lancer
		//       des commandes ReagirAuTempsQuiPasse

	} 
	
}
