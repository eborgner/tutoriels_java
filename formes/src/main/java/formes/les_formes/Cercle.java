package formes.les_formes;

import java.util.Scanner;

import commun.debogage.J;
import formes.Dessin;
import formes.Forme;
import formes.MonDessin;

public class Cercle extends Forme<MonDessin> {
	
	protected double rayon;

	@Override
	public void lireAttributs(Scanner scannerForme) {
		J.appel(this);
		
		rayon = scannerForme.nextDouble();
	}

	@Override
	public void dessinerForme(MonDessin dessin) {
		J.appel(this);
		
		dessin.dessinerCercle(centreX, centreY, rayon);
	}
}
