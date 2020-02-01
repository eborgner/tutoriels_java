package pong.modeles.partie.table_pong;

import commun.debogage.J;
import pong.enumerations.Cadran;

public class Palette extends Objet2D implements PaletteLectureSeule {
	
	private Cadran monCadran;
	
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
