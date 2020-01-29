package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.RecepteurCommande;
import commun_client.mvc.Controleur;
import quatredesuite.modeles.partie.Partie;
import quatredesuite_client.commandes.jouer_ici.JouerIci;
import quatredesuite_client.commandes.jouer_ici.JouerIciRecue;
import quatredesuite_client.vues.VuePartieLocale;

public class ControleurPartieLocale extends Controleur<Partie, VuePartieLocale> {
	

	@Override
	public void installerCapteursEvenement() {
		J.appel(this);
		
		FabriqueCommande.installerRecepteur(JouerIci.class, new RecepteurCommande<JouerIciRecue>() {

			@Override
			public void executerCommande(JouerIciRecue evenement) {
				J.appel(this);
				

			}
		});
		
	}
	
	@Override
	public void detruire() {
		J.appel(this);
		
	} 
	
}
