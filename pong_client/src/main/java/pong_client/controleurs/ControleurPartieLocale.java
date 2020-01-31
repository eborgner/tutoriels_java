package pong_client.controleurs;

import commun.debogage.J;
import commun.mvc.Modele;
import commun_client.mvc.controleurs.ControleurModeleVue;
import pong.modeles.partie.PartieLectureSeule;
import pong_client.afficheurs.AfficheurPartie;
import pong_client.vues.VuePartieLocale;

public class ControleurPartieLocale extends ControleurModeleVue<PartieLectureSeule,
															    Modele<PartieLectureSeule>,
															    VuePartieLocale,
															    AfficheurPartie> {

	@Override
	public void installerReceptionCommandes() {
		J.appel(this);
		
	}

	@Override
	public void demarrer() {
		J.appel(this);
		
	}

	@Override
	public void detruire() {
		J.appel(this);
		
	}

}
