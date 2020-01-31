package pong_client.afficheurs;

import commun.debogage.J;
import commun_client.mvc.Afficheur;
import pong.modeles.partie.PartieLectureSeule;
import pong_client.vues.VuePartieLocale;

public class AfficheurPartie extends Afficheur<PartieLectureSeule, VuePartieLocale>{

	@Override
	public void initialiserAffichage(PartieLectureSeule modeleLectureSeule, VuePartieLocale vue) {
		J.appel(this);
		
		vue.dessinerPalette(100);
	}

	@Override
	public void rafraichirAffichage(PartieLectureSeule modeleLectureSeule, VuePartieLocale vue) {
		J.appel(this);
	}

}
