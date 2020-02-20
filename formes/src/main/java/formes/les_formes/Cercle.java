package formes.les_formes;

import java.util.Scanner;

import commun.debogage.J;
import formes.Dessin;
import formes.Forme;

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
