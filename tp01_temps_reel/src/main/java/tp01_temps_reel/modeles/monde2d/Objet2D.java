package tp01_temps_reel.modeles.monde2d;

import commun.debogage.J;

public abstract class Objet2D {
	
	protected double centreXMetres;
	protected double centreYMetres;
	protected double vitesseXMetresSecondes;
	protected double vitesseYMetresSecondes;
	protected double accelerationXMetresSecondesCarres;
	protected double accelerationYMetresSecondesCarres;
	
	public Objet2D(double centreXMetres, double centreYMetres) {
		J.appel(this);
		
		this.centreXMetres = centreXMetres;
		this.centreYMetres = centreYMetres;
		
		this.vitesseXMetresSecondes = 0;
		this.vitesseYMetresSecondes = 0;
		
		this.accelerationXMetresSecondesCarres = 0;
		this.accelerationYMetresSecondesCarres = 0;
	}
	

	public void reagirAuTempsQuiPasse(double secondesEcoulees) {
		J.appel(this);

		vitesseXMetresSecondes += accelerationXMetresSecondesCarres * secondesEcoulees;
		vitesseYMetresSecondes += accelerationYMetresSecondesCarres * secondesEcoulees;

		centreXMetres += vitesseXMetresSecondes * secondesEcoulees;
		centreYMetres += vitesseYMetresSecondes * secondesEcoulees;
	}
	
	public abstract void afficher(double facteurMetresEnPixelsX, 
			                      double facteurMetresEnPixelsY, 
			                      double hauteurPixels,
			                      Dessin2D dessin2d);
}
