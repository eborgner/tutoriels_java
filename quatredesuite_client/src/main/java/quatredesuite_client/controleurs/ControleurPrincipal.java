package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.evenements.CapteurEvenement;
import commun_client.evenements.FabriqueEvenement;
import commun_client.mvc.Controleur;
import quatredesuite.modeles.ModelePrincipal;
import quatredesuite_client.evenements.nouvelle_partie_locale.NouvellePartieLocale;
import quatredesuite_client.evenements.nouvelle_partie_locale.NouvellePartieLocaleCapte;
import quatredesuite_client.vues.VuePartieLocale;
import quatredesuite_client.vues.VuePrincipale;

public class ControleurPrincipal extends Controleur<ModelePrincipal, VuePrincipale> {
	
	//private ControleurPartieLocale controleurPartieLocale;

	@Override
	public void installerCapteursEvenement() {
		J.appel(this);
		
		FabriqueEvenement.installerCapteur(NouvellePartieLocale.class, new CapteurEvenement<NouvellePartieLocaleCapte>() {
			@Override
			public void capterEvenement(NouvellePartieLocaleCapte evenement) {
				J.appel(this);
				
				transitionPartieLocale();

				evenement.finCaptation();
			}
		});
		
	}
	
	private void transitionPartieLocale() {
		J.appel(this);
		
		VuePartieLocale vuePartieLocale = vue.creerVuePartieLocale();
		
		
		
		/*
		PartieLocale partieLocale = modele.nouvellePartieLocale();
		VuePartieLocale = vuePartieLocale = vue.creerVuePartieLocale();
		*/
		
		
		
		/*
		
		if(controleurPartieLocale != null) {
			controleurPartieLocale.detruire();
		}
		
		
		*/
		
		
		// FIXME: et la VuePartieLocale ... elle est chargée où? Elle est installé où dans l'Afficheur?
		
		
		
	}

	@Override
	public void detruire() {
		J.appel(this);
		
	} 
	
}
