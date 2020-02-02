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
		
		vitesseMetreSecondes = 0;
		angleDegres = 0;
	}

	public abstract void reagirAuTempsQuiPasse(double secondesEcoulees);

	@Override
	public double getCentreXMetres() {
		return centreXMetres;
	}

	@Override
	public double getCentreYMetres() {
		return centreYMetres;
	}

	@Override
	public double getLargeurMetres() {
		return largeurMetres;
	}

	@Override
	public double getHauteurMetres() {
		return hauteurMetres;
	}
}
