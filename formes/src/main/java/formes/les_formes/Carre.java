package formes.les_formes;

import java.util.Scanner;

import commun.debogage.J;
import formes.Dessin;
import formes.Forme;
import formes.MonDessin;

public class Carre extends Forme<MonDessin> {
	
	protected double taille;

	@Override
	public void lireAttributs(Scanner scannerForme) {
		J.appel(this);
		
		taille = scannerForme.nextDouble();
	}

	@Override
	public void dessinerForme(MonDessin dessin) {
		J.appel(this);
		
		dessin.dessinerCarre(centreX, centreY, taille);
	}
}
