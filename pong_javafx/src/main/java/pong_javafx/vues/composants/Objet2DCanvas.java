package pong_javafx.vues.composants;

import commun.debogage.J;
import commun.enumerations.Forme;
import commun.modeles.monde2d.Objet2DLectureSeule;

public class Objet2DCanvas {
	
	private double coinHautGaucheXPixels;
	private double coinHautGaucheYPixels;
	private double largeurPixels;
	private double hauteurPixels;
	private Forme forme;
	
	public Objet2DCanvas(Objet2DLectureSeule objet2D,
						 double conversionMetresPixelsX,
						 double conversionMetresPixelsY,
						 double hauteurCanvasPixels) {

		J.appel(this);
		
		this.largeurPixels = objet2D.getLargeurMetres() * conversionMetresPixelsX;
		this.hauteurPixels = objet2D.getHauteurMetres() * conversionMetresPixelsY;
		
		double centreXPixels = objet2D.getCentreXMetres() * conversionMetresPixelsX;
		double centreYPixels = hauteurCanvasPixels - (objet2D.getCentreYMetres() * conversionMetresPixelsY);
		
		this.coinHautGaucheXPixels = centreXPixels - largeurPixels / 2;
		this.coinHautGaucheYPixels = centreYPixels - hauteurPixels / 2;
		
		this.forme = objet2D.getForme();
	}
	
	
	public double getCoinHautGaucheXPixels() {
		J.appel(this);

		return coinHautGaucheXPixels;
	}

	public double getCoinHautGaucheYPixels() {
		J.appel(this);

		return coinHautGaucheYPixels;
	}

	public double getLargeurPixels() {
		J.appel(this);

		return largeurPixels;
	}

	public double getHauteurPixels() {
		J.appel(this);

		return hauteurPixels;
	}
	
	public Forme getForme() {
		J.appel(this);
		
		return forme;
	}
}
