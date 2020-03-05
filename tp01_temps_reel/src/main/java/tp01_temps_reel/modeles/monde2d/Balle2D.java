package tp01_temps_reel.modeles.monde2d;

import commun.debogage.J;

public class Balle2D extends Objet2D {
	
	private double rayonMetres = 0.2;

	public Balle2D(double centreXMetres, double centreYMetres, double vitesseInitialeMetresSecondes, double angleInitialDegre) {
		super(centreXMetres, centreYMetres);
		
		double angleInitialRadians = Math.toRadians(angleInitialDegre);
		
		this.vitesseXMetresSecondes = vitesseInitialeMetresSecondes * Math.cos(angleInitialRadians);
		this.vitesseYMetresSecondes = vitesseInitialeMetresSecondes * Math.sin(angleInitialRadians);
		
		double accelerationGraviteTerrestreMetresSecondesCarres =  9.81;
		
		this.accelerationYMetresSecondesCarres = - accelerationGraviteTerrestreMetresSecondesCarres;
	}

	@Override
	public void afficher(double facteurMetresEnPixelsX, 
			             double facteurMetresEnPixelsY, 
			             double hauteurPixels,
			             Dessin2D dessin2d) {
		J.appel(this);
		
		double centreXPixels = centreXMetres * facteurMetresEnPixelsX;
		double centreYPixels = hauteurPixels - (centreYMetres * facteurMetresEnPixelsY);
		
		double rayonPixels = rayonMetres * facteurMetresEnPixelsX;

		if(facteurMetresEnPixelsY < facteurMetresEnPixelsX) {

			rayonPixels = rayonMetres * facteurMetresEnPixelsY;
		}
		
		dessin2d.dessinerCercle(centreXPixels, centreYPixels, rayonPixels);
	}

}
