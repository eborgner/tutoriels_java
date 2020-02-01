package pong.modeles.partie.table_pong;

import commun.debogage.J;
import pong.enumerations.Cadran;

public class Palette implements PaletteLectureSeule {
	
	private Cadran monCadran;

	private double centreXMetres = 0;
	private double centreYMetres = 50;
	private double largeurMetres = 10;
	private double hauteurMetres = 100;
	
	private double vitesseMetreSecondes = 1;
	
	public Palette(Cadran monCadran, double centreXMetres) {
		J.appel(this);
		
		this.monCadran = monCadran;

		this.centreXMetres = centreXMetres;
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

}
