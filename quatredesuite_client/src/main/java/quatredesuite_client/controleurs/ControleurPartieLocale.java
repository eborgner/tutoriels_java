package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import quatredesuite.modeles.partie.Partie;
import quatredesuite.modeles.partie.PartieLectureSeule;
import quatredesuite_client.afficheurs.AfficheurPartie;
import quatredesuite_client.commandes.jouer_ici.JouerIci;
import quatredesuite_client.commandes.jouer_ici.JouerIciRecue;
import quatredesuite_client.vues.VuePartieLocale;

public class ControleurPartieLocale extends ControleurModeleVue<PartieLectureSeule, 
															    Partie, 
															    VuePartieLocale, 
															    AfficheurPartie> {
	
	@Override
	public void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(JouerIci.class, new RecepteurCommandeMVC<JouerIciRecue>() {
			@Override
			public void executerCommandeMVC(JouerIciRecue commande) {
				J.appel(this);

				int idColonne = commande.getIdColonne();
				modele.jouerIci(idColonne);
			}
		});
	}

	@Override
	public void detruire() {
		J.appel(this);
		
	}

	@Override
	public void demarrer() {
		J.appel(this);
	} 
	
}
