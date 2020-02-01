package pong_client.afficheurs;

import java.util.Map;

import commun.debogage.J;
import commun_client.mvc.Afficheur;
import pong.enumerations.Cote;
import pong.modeles.partie.PaletteLectureSeule;
import pong.modeles.partie.PartieLectureSeule;
import pong_client.vues.VuePartieLocale;

public class AfficheurPartie extends Afficheur<PartieLectureSeule, VuePartieLocale>{

	@Override
	public void initialiserAffichage(PartieLectureSeule modeleLectureSeule, VuePartieLocale vue) {
		J.appel(this);
		
		afficherTout(modeleLectureSeule, vue);
	}

	@Override
	public void rafraichirAffichage(PartieLectureSeule modeleLectureSeule, VuePartieLocale vue) {
		J.appel(this);

		vue.viderDessin();

		afficherTout(modeleLectureSeule, vue);
	}
	
	private void afficherTout(PartieLectureSeule modeleLectureSeule, VuePartieLocale vue) {
		J.appel(this);
		
		afficherPalettes(modeleLectureSeule.getPalettes(), vue);
		
	}
	
	private void afficherPalettes(Map<Cote, PaletteLectureSeule> palettes, VuePartieLocale vue) {
		J.appel(this);
		
		for(PaletteLectureSeule palette : palettes.values()) {
			vue.dessinerPalette(palette);
		}
	}
}
