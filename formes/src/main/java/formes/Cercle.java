package formes;

import java.util.Scanner;

import commun.debogage.J;

public class Cercle extends Forme {
	
	protected double rayon;

	@Override
	public void lireAttributs(Scanner scannerForme) {
		J.appel(this);
		
		rayon = scannerForme.nextDouble();
	}

	@Override
	public void dessinerForme(Dessin dessin) {
		J.appel(this);
		
		dessin.dessinerCercle(centreX, centreY, rayon);
	}
}
