package pong.modeles.partie.table_pong;

import commun.debogage.J;
import commun.enumerations.Direction;
import commun.modeles.monde2d.Objet2D;
import pong.enumerations.Cadran;

public class Palette extends Objet2D {
	
	private Cadran monCadran;
	
	public Palette(Cadran monCadran, double centreXMetres) {
		super(centreXMetres, 300, 10, 100);
		J.appel(this);
		
		this.monCadran = monCadran;
	}
	
	public void reagirAuTempsQuiPasse(double secondesEcoulees) {
		J.appel(this);
		
		centreYMetres += secondesEcoulees * vitesseMetreSecondes;
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

	public void deplacer(Direction direction) {
		J.appel(this);
		
		vitesseMetreSecondes = 10;
		
		switch(direction) {
			case HAUT:
				angleDegres = 90;
			break;

			case BAS:
				angleDegres = 270;
			break;
		
		}
	}

	public void stopper() {
		J.appel(this);
		
		vitesseMetreSecondes = 0;
		angleDegres = 0;
	}

}
