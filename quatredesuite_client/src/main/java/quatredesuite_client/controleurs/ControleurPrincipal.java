package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.evenements.CapteurEvenement;
import commun_client.evenements.FabriqueEvenement;
import commun_client.evenements.FinalisateurEvenement;
import commun_client.mvc.Controleur;
import commun_client.mvc.FabriqueControleur;
import quatredesuite.modeles.ModelePartieLocale;
import quatredesuite.modeles.ModelePrincipal;
import quatredesuite_client.evenements.nouvelle_partie_locale.NouvellePartieLocale;
import quatredesuite_client.evenements.nouvelle_partie_locale.NouvellePartieLocaleCapte;
import quatredesuite_client.viderGrille.ViderGrille;
import quatredesuite_client.viderGrille.ViderGrilleLance;
import quatredesuite_client.vues.VuePartieLocale;
import quatredesuite_client.vues.VuePrincipale;

public class ControleurPrincipal extends Controleur<ModelePrincipal, VuePrincipale> {
	
	private ControleurPartieLocale controleurPartieLocale;

	@Override
	public void installerCapteursEvenement() {
		J.appel(this);
		
		FabriqueEvenement.installerCapteur(NouvellePartieLocale.class, new CapteurEvenement<NouvellePartieLocaleCapte>() {
			@Override
			public void capterEvenement(NouvellePartieLocaleCapte evenement) {
				J.appel(this);
				
				if(controleurPartieLocale != null) {
					FabriqueEvenement.installerFinalisateur(ViderGrille.class, new FinalisateurEvenement() {
						@Override
						public void reagirFinCaptation() {
							J.appel(this);

							nouvellePartieLocale();
							evenement.finCaptation();
						}
					});
					
					ViderGrilleLance viderGrille = FabriqueEvenement.creerEvenement(ViderGrilleLance.class);
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
