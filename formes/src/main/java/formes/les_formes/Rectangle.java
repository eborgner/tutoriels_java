package formes.les_formes;

import java.util.Scanner;

import commun.debogage.J;
import formes.Dessin;
import formes.Forme;
import formes.MonDessin;

public class Rectangle extends Forme<MonDessin>{
	
	protected double largeur;
	protected double hauteur;

	@Override
	public void lireAttributs(Scanner scannerForme) {
		J.appel(this);
		
		largeur = scannerForme.nextDouble();
		hauteur = scannerForme.nextDouble();
	}

	@Override
	public void dessinerForme(MonDessin dessin) {
		J.appel(this);
		
		dessin.dessinerRectangle(centreX, centreY, largeur, hauteur);
	}

}
