package formes;

import java.util.Scanner;

import commun.debogage.J;

public abstract class Forme<D extends Dessin>{
	
	protected String couleur;
	protected double centreX;
	protected double centreY;
	
	public void charger(Scanner scannerForme) {
		J.appel(this);
		
		couleur = scannerForme.next();
		centreX = scannerForme.nextDouble();
		centreY = scannerForme.nextDouble();

		lireAttributs(scannerForme);
	}

	public abstract void lireAttributs(Scanner scannerForme);
	
	public void afficher(D dessin) {
		J.appel(this);
		
		dessin.changerCouleur(couleur);
		dessinerForme(dessin);
	}

	public abstract void dessinerForme(D dessin);

}
