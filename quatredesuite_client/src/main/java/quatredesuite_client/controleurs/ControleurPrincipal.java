package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.evenements.CapteurEvenement;
import commun_client.evenements.FabriqueEvenement;
import commun_client.structure.Controleur;
import quatredesuite.modeles.ModelePrincipal;
import quatredesuite_client.evenements.nouvelle_partie_locale.NouvellePartieLocale;
import quatredesuite_client.evenements.nouvelle_partie_locale.NouvellePartieLocaleCapte;

public class ControleurPrincipal extends Controleur<ModelePrincipal> {

	public ControleurPrincipal(ModelePrincipal modele) {
		super(modele);
		J.appel(this);
	}

	@Override
	public void installerCapteursEvenement() {
		J.appel(this);
		
		FabriqueEvenement.installerCapteur(NouvellePartieLocale.class, new CapteurEvenement<NouvellePartieLocaleCapte>() {
			@Override
			public void capterEvenement(NouvellePartieLocaleCapte evenement) {
				J.appel(this);
				
				// Créer un contrôleur pour partie locale
				// Le FinalisateurEvenement va modifier la VuePrincipale en conséquence

				evenement.finCaptation();
			}
		});
		
	}

	@Override
	public void detruire() {
		J.appel(this);
		
	} 
	
}
