package pong_client.afficheurs;

import java.util.Map;

import commun.debogage.J;
import commun_client.mvc.Afficheur;
import pong.enumerations.Cadran;
import pong.modeles.partie.PartieLectureSeule;
import pong.modeles.partie.monde2d.AfficheurMonde2D;
import pong_client.vues.VuePartieLocale;

public class AfficheurPartie extends Afficheur<PartieLectureSeule, VuePartieLocale> {

	@Override
	public void initialiserAffichage(PartieLectureSeule partie, VuePartieLocale vue) {
		J.appel(this);
		
		afficherTout(partie, vue);
	}

	@Override
	public void rafraichirAffichage(PartieLectureSeule partie, VuePartieLocale vue) {
		J.appel(this);

		afficherTout(partie, vue);
	}
	
	private void afficherTout(PartieLectureSeule partie, VuePartieLocale vue) {
		J.appel(this);
		
		AfficheurMonde2D.afficherMonde(partie.getMonde2D(), vue);
		
	}

}
