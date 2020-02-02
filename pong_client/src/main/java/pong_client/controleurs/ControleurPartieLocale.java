package pong_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import pong.modeles.partie.Partie;
import pong.modeles.partie.PartieLectureSeule;
import pong_client.afficheurs.AfficheurPartie;
import pong_client.commandes.aggrandir_table_pong.AggrandirTablePong;
import pong_client.commandes.aggrandir_table_pong.AggrandirTablePongRecue;
import pong_client.vues.VuePartieLocale;

public abstract class ControleurPartieLocale extends ControleurModeleVue<PartieLectureSeule,
															    Partie,
															    VuePartieLocale,
															    AfficheurPartie> {

	@Override
	public void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(AggrandirTablePong.class, new RecepteurCommandeMVC<AggrandirTablePongRecue>() {
			@Override
			public void executerCommandeMVC(AggrandirTablePongRecue commande) {
				J.appel(this);
				
				// modele.aggrandirMonde()
			}
		});
	}

	protected void reagirTempsQuiPasse(double tempsEcouleSecondes) {
		J.appel(this);

		modele.reagirTempsQuiPasse(tempsEcouleSecondes);
		afficheur.rafraichirAffichage((PartieLectureSeule) modele, vue);
	}

	@Override
	public void detruire() {
		J.appel(this);
		
	}

}
