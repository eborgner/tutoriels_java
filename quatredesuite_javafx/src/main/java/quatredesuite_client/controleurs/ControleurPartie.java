package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import quatredesuite.modeles.partie.Partie;
import quatredesuite.modeles.partie.PartieLectureSeule;
import quatredesuite_client.afficheurs.AfficheurPartie;
import quatredesuite_client.commandes.jouer_ici.JouerIci;
import quatredesuite_client.commandes.jouer_ici.JouerIciRecue;
import quatredesuite_client.vues.VuePartie;

public abstract class  ControleurPartie<PLS extends PartieLectureSeule, 
							    P extends Partie<PLS>,
                                V extends VuePartie, 
                                A extends AfficheurPartie<PLS, V>>

	            extends ControleurModeleVue<PLS, P, V, A> {

	@Override
	protected void demarrer() {
		J.appel(this);
	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
		
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
		
	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(JouerIci.class, new RecepteurCommandeMVC<JouerIciRecue>() {
			@Override
			public void executerCommandeMVC(JouerIciRecue commande) {
				J.appel(this);
				
				reagirCommandeJouerIci(commande);
			}
		});
	} 
	
	protected void reagirCommandeJouerIci(JouerIciRecue jouerIciRecue) {
		J.appel(this);

			modele.jouerIci(jouerIciRecue.getIndiceColonne());
	}
}
