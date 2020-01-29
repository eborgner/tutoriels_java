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

public class ControleurPrincipal extends ControleurVue<VuePrincipale> {
	
	private ControleurPartieLocale controleurPartieLocale;

	@Override
	public void installerReceptionCommandes() {
		J.appel(this);
		
		FabriqueCommande.installerRecepteur(NouvellePartieLocale.class, new RecepteurCommande<NouvellePartieLocaleRecue>() {
			@Override
			public void executerCommande(NouvellePartieLocaleRecue evenement) {
				J.appel(this);
				
				// FIXME
				if(controleurPartieLocale != null) {
					FabriqueCommande.installerReactionApresCommande(ViderGrille.class, new ReactionApresCommande() {
						@Override
						public void reagirApresCommande() {
							J.appel(this);

							nouvellePartieLocale();
							evenement.notifierCommandeTraitee();
						}
					});
					
					ViderGrillePourEnvoi viderGrille = FabriqueCommande.obtenirCommandePourEnvoi(ViderGrillePourEnvoi.class);
					viderGrille.envoyerCommande();
					
				}else {
					
					nouvellePartieLocale();
					evenement.notifierCommandeTraitee();
				}
			}
		});
		
	}
	
	private void nouvellePartieLocale() {
		J.appel(this);

		if(controleurPartieLocale != null) {
			controleurPartieLocale.detruire();
			vue.detruireVuePartieLocale();
		}
		
		VuePartieLocale vuePartieLocale = vue.creerVuePartieLocale();
		
		// FIXME: devrait faire appel à un EntrepotDeModeles (qui est dans quatredesuite_javafx)
		Partie partieLocale = new Partie();
		
		AfficheurPartie afficheurPartie = new AfficheurPartie();

		controleurPartieLocale = FabriqueControleur.creerControleur(ControleurPartieLocale.class, 
				partieLocale, 
				vuePartieLocale,
				afficheurPartie);
	}

	@Override
	public void detruire() {
		J.appel(this);
		
		controleurPartieLocale.detruire();
	}

	@Override
	public void demarrer() {
		J.appel(this);
		
		// rien; à moins qu'on démarrer un AnimationTimer pour lancer
		//       des commandes ReagirAuTempsQuiPasse

	} 
	
}
