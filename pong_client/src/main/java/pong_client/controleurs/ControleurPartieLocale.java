package pong_client.controleurs;

import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import javafx.animation.AnimationTimer;
import pong.modeles.partie.Partie;
import pong.modeles.partie.PartieLectureSeule;
import pong_client.afficheurs.AfficheurPartie;
import pong_client.commandes.aggrandir_table_pong.AggrandirTablePong;
import pong_client.commandes.aggrandir_table_pong.AggrandirTablePongRecue;
import pong_client.commandes.reagir_temps_qui_passe.ReagirTempsQuiPasse;
import pong_client.commandes.reagir_temps_qui_passe.ReagirTempsQuiPassePourEnvoi;
import pong_client.commandes.reagir_temps_qui_passe.ReagirTempsQuiPasseRecue;
import pong_client.vues.VuePartieLocale;

public class ControleurPartieLocale extends ControleurModeleVue<PartieLectureSeule,
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
		
		installerRecepteurCommande(ReagirTempsQuiPasse.class, new RecepteurCommandeMVC<ReagirTempsQuiPasseRecue>() {
			@Override
			public void executerCommandeMVC(ReagirTempsQuiPasseRecue commande) {
				J.appel(this);

				modele.reagirTempsQuiPasse(commande.getTempsEcouleSecondes());
			}
		});
	}

	@Override
	public void demarrer() {
		J.appel(this);
		
		ReagirTempsQuiPassePourEnvoi reagirTempsQuiPassePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(ReagirTempsQuiPasse.class);
		
		new AnimationTimer() {
			
			private long avant = System.nanoTime();

			@Override
			public void handle(long maintenant) {
				J.appel(this);
				
				double tempsEcouleSecondes = (maintenant - avant) / 1E9;
				
				reagirTempsQuiPassePourEnvoi.setTempsEcouleSecondes(tempsEcouleSecondes);
				reagirTempsQuiPassePourEnvoi.envoyerCommande();
				
				avant = maintenant;
			}
			
			
		}.start();
	}

	@Override
	public void detruire() {
		J.appel(this);
		
	}

}
