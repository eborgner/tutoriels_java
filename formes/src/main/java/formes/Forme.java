package formes;

import java.util.Scanner;

import commun.debogage.J;

public abstract class Forme {
	
	protected String couleur;
	protected double centreX;
	protected double centreY;
	
	public void chargerForme(Scanner scannerForme) {
		J.appel(this);
		
		couleur = scannerForme.next();
		centreX = scannerForme.nextDouble();
		centreY = scannerForme.nextDouble();

		lireAttributs(scannerForme);
	}

	public abstract void lireAttributs(Scanner scannerForme);
	
	public void afficher(Dessin dessin) {
		J.appel(this);
		
		dessin.changerCouleur(couleur);
		dessinerForme(dessin);
	}

	public abstract void dessinerForme(Dessin dessin);

}
