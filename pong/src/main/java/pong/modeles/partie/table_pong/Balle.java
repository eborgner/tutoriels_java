package pong.modeles.partie.table_pong;

import java.util.Map;

import commun.debogage.J;
import commun.enumerations.Dimension;
import commun.enumerations.Forme;
import commun.modeles.monde2d.Objet2D;
import pong.enumerations.Cadran;

public class Balle extends Objet2D {
	
	public Balle() {
		super(400, 150, 10, 10, Forme.CERCLE);
		J.appel(this);
		
		vitesseMetreSecondes = 100;
		angleDegres = 0;
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
	


	public void replacerApresAggrandissement(Dimension dimension, double facteurAggrandissement) {
		J.appel(this);
		
		switch(dimension) {
			case HAUTEUR:
				centreYMetres *= facteurAggrandissement;
			break;
			
			case LARGEUR:
				centreXMetres *= facteurAggrandissement;
			break;
		}
	}

	public void reagirSiCollision(Map<Cadran, Palette> palettes) {
		J.appel(this);
		
		for(Palette palette : palettes.values()) {
			
			double distanceX = Math.abs(palette.getCentreXMetres() - centreXMetres);
			
			if(distanceX <= (palette.getLargeurMetres()/2 + largeurMetres/2)) {
				
				reagirSiCollision(palette);

			}
		}
	}

	private void reagirSiCollision(Palette palette) {
		J.appel(this);
		
		switch(palette.getCadran()) {
		
			case GAUCHE:
				
				centreXMetres = palette.getCentreXMetres() + palette.getLargeurMetres()/2 + largeurMetres/2;
				angleDegres = 0;
			break;

			case DROIT:

				centreXMetres = palette.getCentreXMetres() - palette.getLargeurMetres()/2 - largeurMetres/2;
				angleDegres = 180;
			break;
		}
	}
}
