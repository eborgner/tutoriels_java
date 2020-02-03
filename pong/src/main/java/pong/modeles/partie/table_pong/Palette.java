package pong.modeles.partie.table_pong;

import commun.debogage.J;
import commun.enumerations.Direction;
import commun.enumerations.Forme;
import commun.modeles.monde2d.Objet2D;
import pong.enumerations.Cadran;

public class Palette extends Objet2D {
	
	private Cadran monCadran;
	
	public Palette(Cadran monCadran, double centreXMetres) {
		super(centreXMetres, 150, 10, 100, Forme.RECTANGLE);
		J.appel(this);
		
		this.monCadran = monCadran;
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
	public double getHauteurMetres() {
		J.appel(this);
		return hauteurMetres;
	}

	@Override
	public double getLargeurMetres() {
		J.appel(this);
		return largeurMetres;
	}
	
	public void placerPresDuMur(double largeurMonde) {
		J.appel(this);
		
		switch(monCadran) {

			case GAUCHE:
				centreXMetres = 20;
			break;

			case DROIT:
				centreXMetres = largeurMonde - 20;
			break;
	
		
		}
		
	}
	

	@SuppressWarnings("incomplete-switch")
	public void deplacer(Direction direction) {
		J.appel(this);
		
		vitesseMetreSecondes = 100;
		
		switch(direction) {
			case HAUT:
				angleDegres = 90;
			break;

			case BAS:
				angleDegres = 270;
			break;
		
		}
	}

	public void replacerEnHauteur(double facteurAggrandissement) {
		J.appel(this);
		
		centreYMetres *= facteurAggrandissement;
	}

	public void stopper() {
		J.appel(this);
		
		vitesseMetreSecondes = 0;
		angleDegres = 0;
	}

	public Cadran getCadran() {
		J.appel(this);

		return monCadran;
	}

}
