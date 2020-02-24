package formes;

public interface MonDessin extends Dessin {

	void dessinerCarre(double centreX, double centreY, double taille);
	void dessinerRectangle(double centreX, double centreY, double largeur, double hauteur);
	void dessinerCercle(double centreX, double centreY, double rayon);

}
