package pong_client.afficheurs;

import java.util.Map;

import commun.debogage.J;
import commun_client.mvc.Afficheur;
import pong.enumerations.Cadran;
import pong.modeles.partie.PartieLectureSeule;
import pong.modeles.partie.table_pong.PaletteLectureSeule;
import pong.modeles.partie.table_pong.TablePongLectureSeule;
import pong_client.vues.VuePartieLocale;

public class AfficheurPartie extends Afficheur<PartieLectureSeule, VuePartieLocale>{

	@Override
	public void initialiserAffichage(PartieLectureSeule partie, VuePartieLocale vue) {
		J.appel(this);
		
		afficherTout(partie, vue);
	}

	@Override
	public void rafraichirAffichage(PartieLectureSeule partie, VuePartieLocale vue) {
		J.appel(this);

		vue.viderDessin();

		afficherTout(partie, vue);
	}
	
	private void afficherTout(PartieLectureSeule partie, VuePartieLocale vue) {
		J.appel(this);
		
		afficherTablePong(partie.getTablePong(), vue);
		
	}

	private void afficherTablePong(TablePongLectureSeule tablePong, VuePartieLocale vue) {
		J.appel(this);

		afficherPalettes(tablePong.getPalettes(), vue);

	}
	
	private void afficherPalettes(Map<Cadran, PaletteLectureSeule> palettes, VuePartieLocale vue) {
		J.appel(this);
		
		for(PaletteLectureSeule palette : palettes.values()) {
			vue.dessinerPalette(palette);
		}
	}
}
