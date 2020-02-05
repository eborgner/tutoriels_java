package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import quatredesuite.modeles.partie.PartieLocale;
import quatredesuite.modeles.partie.PartieLocaleLectureSeule;
import quatredesuite_client.afficheurs.AfficheurPartieLocale;
import quatredesuite_client.commandes.jouer_ici.JouerIci;
import quatredesuite_client.commandes.jouer_ici.JouerIciRecue;
import quatredesuite_client.vues.VuePartieLocale;

public class ControleurPartieLocale extends ControleurModeleVue<PartieLocaleLectureSeule, 
															    PartieLocale, 
															    VuePartieLocale, 
															    AfficheurPartieLocale> {
	@Override
	protected void demarrer() {
		J.appel(this);
	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(JouerIci.class, new RecepteurCommandeMVC<JouerIciRecue>() {
			@Override
			public void executerCommandeMVC(JouerIciRecue commande) {
				J.appel(this);
				
				modele.jouerIci(commande.getIndiceColonne());
				
			}
		});
	} 
	
}
