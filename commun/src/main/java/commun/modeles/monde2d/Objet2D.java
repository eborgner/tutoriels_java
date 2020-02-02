package commun.modeles.monde2d;

import commun.debogage.J;

public abstract class Objet2D implements Objet2DLectureSeule {
	
	protected double centreXMetres;
	protected double centreYMetres;
	protected double largeurMetres;
	protected double hauteurMetres;

	protected double vitesseMetreSecondes;
	protected double angleDegres;
	
	public Objet2D(double centreXMetres, 
				   double centreYMetres, 
				   double largeurMetres, 
				   double hauteurMetres) {
		
		J.appel(this);
		
		this.centreXMetres = centreXMetres;
		this.centreYMetres = centreYMetres;
		this.largeurMetres = largeurMetres;
		this.hauteurMetres = hauteurMetres;
		
		// FIXME: à faire pour vrai!
		vitesseMetreSecondes = 10;
		angleDegres = 0;
	}

	public void reagirTempsQuiPasse(double tempsEcouleSecondes) {
		J.appel(this);
		
		this.centreXMetres += vitesseMetreSecondes * tempsEcouleSecondes;
	}

	@Override
	public double getCentreXMetres() {
		J.appel(this);
		
		return centreXMetres;
	}

	@Override
	public double getCentreYMetres() {
		J.appel(this);
		
		return centreYMetres;
	}

	@Override
	public double getLargeurMetres() {
		J.appel(this);
		
		return largeurMetres;
	}

	@Override
	public double getHauteurMetres() {
		J.appel(this);
		
		return hauteurMetres;
	}
}
