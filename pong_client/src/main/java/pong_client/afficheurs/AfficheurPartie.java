package pong_client.afficheurs;

import java.util.Map;

import commun.debogage.J;
import commun.modeles.monde2d.Monde2DLectureSeule;
import commun.modeles.monde2d.Objet2DLectureSeule;
import commun_client.mvc.Afficheur;
import pong.enumerations.Cadran;
import pong.modeles.partie.PartieLectureSeule;
import pong_client.vues.Objet2DCanvas;
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

		vue.viderMonde();

		afficherTout(partie, vue);
	}
	
	private void afficherTout(PartieLectureSeule partie, VuePartieLocale vue) {
		J.appel(this);

		int largeurCanvasPixels = vue.getLargeurCanvasPixels();
		int hauteurCanvasPixels = vue.getHauteurCanvasPixels();
		
		Monde2DLectureSeule monde2d = partie.getMonde2D();
		
		double largeurMetres = monde2d.getLageurMetres();
		double hauteurMetres = monde2d.getHauteurMetres();

		double conversionMetresPixelsX = ((double) largeurCanvasPixels) / largeurMetres;
		double conversionMetresPixelsY = ((double) hauteurCanvasPixels) / hauteurMetres;
		
		for(Objet2DLectureSeule objet2d : monde2d.getObjets2D()) {
			
			Objet2DCanvas objet2dCanvas = new Objet2DCanvas(objet2d,
													        conversionMetresPixelsX,
													        conversionMetresPixelsY,
													        largeurCanvasPixels,
													        hauteurCanvasPixels);

			vue.afficherObjet2D(objet2dCanvas);
		}
	}

}
