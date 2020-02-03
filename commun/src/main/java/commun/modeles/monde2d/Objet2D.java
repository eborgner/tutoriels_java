package commun.modeles.monde2d;

import commun.debogage.J;
import commun.enumerations.Forme;

public abstract class Objet2D implements Objet2DLectureSeule {
	
	protected double centreXMetres;
	protected double centreYMetres;
	protected double largeurMetres;
	protected double hauteurMetres;

	protected double vitesseMetreSecondes;
	protected double angleDegres;
	
	protected Forme forme = Forme.RECTANGLE;
	
	public Objet2D(double centreXMetres, 
				   double centreYMetres, 
				   double largeurMetres, 
				   double hauteurMetres,
				   Forme forme) {
		
		J.appel(this);
		
		this.centreXMetres = centreXMetres;
		this.centreYMetres = centreYMetres;
		this.largeurMetres = largeurMetres;
		this.hauteurMetres = hauteurMetres;
		this.forme = forme;
		
		vitesseMetreSecondes = 0;
		angleDegres = 0;
	}

	public void reagirTempsQuiPasse(double tempsEcouleSecondes) {
		J.appel(this);
		
		this.centreXMetres += Math.cos(Math.toRadians(angleDegres)) * vitesseMetreSecondes * tempsEcouleSecondes;
		this.centreYMetres += Math.sin(Math.toRadians(angleDegres)) * vitesseMetreSecondes * tempsEcouleSecondes;
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
	
	@Override 
	public Forme getForme() {
		J.appel(this);
		
		return forme;
		
	}
}
