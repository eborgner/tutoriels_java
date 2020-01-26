package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.evenements.CapteurEvenement;
import commun_client.evenements.FabriqueEvenement;
import commun_client.mvc.Controleur;
import quatredesuite.modeles.ModelePartieLocale;
import quatredesuite_client.evenements.jouer_ici.JouerIci;
import quatredesuite_client.evenements.jouer_ici.JouerIciCapte;
import quatredesuite_client.vues.VuePartieLocale;

public class ControleurPartieLocale extends Controleur<ModelePartieLocale, VuePartieLocale> {
	

	@Override
	public void installerCapteursEvenement() {
		J.appel(this);
		
		FabriqueEvenement.installerCapteur(JouerIci.class, new CapteurEvenement<JouerIciCapte>() {

			@Override
			public void capterEvenement(JouerIciCapte evenement) {
				J.appel(this);
				

			}
		});
		
	}
	
	@Override
	public void detruire() {
		J.appel(this);
		
	} 
	
}
