package pong_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import pong.modeles.partie.Partie;
import pong.modeles.partie.PartieLectureSeule;
import pong_client.afficheurs.AfficheurPartie;
import pong_client.commandes.aggrandir_table_pong.AggrandirTablePong;
import pong_client.commandes.aggrandir_table_pong.AggrandirTablePongRecue;
import pong_client.commandes.deplacer_palette.DeplacerPalette;
import pong_client.commandes.deplacer_palette.DeplacerPaletteRecue;
import pong_client.commandes.stopper_palette.StopperPalette;
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
				
				modele.aggrandirTablePong(commande.getDimension(), commande.getFacteurAggrandissement());
			}
		});
		
		installerRecepteurCommande(DeplacerPalette.class, new RecepteurCommandeMVC<DeplacerPaletteRecue>() {
			@Override
			public void executerCommandeMVC(DeplacerPaletteRecue commande) {
				J.appel(this);
				
				modele.deplacerPalette(commande.getCadran(), commande.getDirection());
			}
		});
		
		installerRecepteurCommande(StopperPalette.class, new RecepteurCommandeMVC<StopperPalette>() {
			@Override
			public void executerCommandeMVC(StopperPalette commande) {
				J.appel(this);
				
				modele.stopperPalette(commande.getCadran());
				
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
