package formes;

public interface Dessin {
	
	void changerCouleur(String couleur);

	void dessinerCarre(double centreX, double centreY, double taille);
	void dessinerRectangle(double centreX, double centreY, double largeur, double hauteur);
	void dessinerCercle(double centreX, double centreY, double rayon);

}
