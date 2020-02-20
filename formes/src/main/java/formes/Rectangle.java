package formes;

import java.util.Scanner;

import commun.debogage.J;

public class Rectangle extends Forme {
	
	protected double largeur;
	protected double hauteur;

	@Override
	public void lireAttributs(Scanner scannerForme) {
		J.appel(this);
		
		largeur = scannerForme.nextDouble();
		hauteur = scannerForme.nextDouble();
	}

	@Override
	public void dessinerForme(Dessin dessin) {
		J.appel(this);
		
		dessin.dessinerRectangle(centreX, centreY, largeur, hauteur);
	}

}
