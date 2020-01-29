package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.commandes.ActionCommandeTraitee;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.RecepteurCommande;
import commun_client.mvc.Controleur;
import commun_client.mvc.FabriqueControleur;
import quatredesuite.modeles.ModelePartieLocale;
import quatredesuite.modeles.ModelePrincipal;
import quatredesuite_client.commandes.nouvelle_partie_locale.NouvellePartieLocale;
import quatredesuite_client.commandes.nouvelle_partie_locale.NouvellePartieLocaleRecue;
import quatredesuite_client.commandes.vider_grille.ViderGrille;
import quatredesuite_client.commandes.vider_grille.ViderGrillePourEnvoi;
import quatredesuite_client.vues.VuePartieLocale;
import quatredesuite_client.vues.VuePrincipale;

public class ControleurPrincipal extends Controleur<ModelePrincipal, VuePrincipale> {
	
	private ControleurPartieLocale controleurPartieLocale;

	@Override
	public void installerCapteursEvenement() {
		J.appel(this);
		
		FabriqueCommande.installerRecepteur(NouvellePartieLocale.class, new RecepteurCommande<NouvellePartieLocaleRecue>() {
			@Override
			public void capterEvenement(NouvellePartieLocaleRecue evenement) {
				J.appel(this);
				
				if(controleurPartieLocale != null) {
					FabriqueCommande.installerFinalisateur(ViderGrille.class, new ActionCommandeTraitee() {
						@Override
						public void reagirMessageTraite() {
							J.appel(this);

							nouvellePartieLocale();
							evenement.finCaptation();
						}
					});
					
					ViderGrillePourEnvoi viderGrille = FabriqueCommande.creerEvenement(ViderGrillePourEnvoi.class);
					viderGrille.lancer();
					
				}else {
					
					nouvellePartieLocale();
					evenement.finCaptation();
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
		
		// FIXME: devrait être un creerAffichage appelé en créant l'afficheur!
		vuePartieLocale.creerGrille(4,6);

		ModelePartieLocale partieLocale = modele.nouvellePartieLocale();

		controleurPartieLocale = FabriqueControleur.creerControleur(ControleurPartieLocale.class, partieLocale, vuePartieLocale);
	}

	@Override
	public void detruire() {
		J.appel(this);
		
	} 
	
}
