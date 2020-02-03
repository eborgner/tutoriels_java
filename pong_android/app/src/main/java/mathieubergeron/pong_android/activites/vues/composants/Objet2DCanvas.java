package mathieubergeron.pong_android.activites.vues.composants;

import commun.debogage.J;
import commun.enumerations.Forme;
import commun.modeles.monde2d.Objet2DLectureSeule;

public class Objet2DCanvas {

	private float centreXPixels;
	private float centreYPixels;
	private float largeurPixels;
	private float hauteurPixels;
	private Forme forme;

	public Objet2DCanvas(Objet2DLectureSeule objet2D,
						 float conversionMetresPixelsX,
						 float conversionMetresPixelsY,
						 float hauteurCanvasPixels){

		J.appel(this);

		this.largeurPixels = (float) objet2D.getLargeurMetres() * conversionMetresPixelsX;
		this.hauteurPixels = (float) objet2D.getHauteurMetres() * conversionMetresPixelsY;

		centreXPixels = (float) objet2D.getCentreXMetres() * conversionMetresPixelsX;
		centreYPixels = hauteurCanvasPixels - ((float) objet2D.getCentreYMetres() * conversionMetresPixelsY);

		this.forme = objet2D.getForme();
	}

	public float getCentreXPixels() {
		J.appel(this);
		return centreXPixels;
	}

	public float getCentreYPixels() {
		J.appel(this);
		return centreYPixels;
	}

	public float getLargeurPixels() {
		J.appel(this);
		return largeurPixels;
	}

	public float getHauteurPixels() {
		J.appel(this);
		return hauteurPixels;
	}

	public Forme getForme() {
		J.appel(this);
		return forme;
	}
}
