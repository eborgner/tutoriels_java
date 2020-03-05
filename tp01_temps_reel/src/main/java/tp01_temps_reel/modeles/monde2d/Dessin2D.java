package tp01_temps_reel.modeles.monde2d;

public interface Dessin2D {
	
	double getLargeurPixels();
	double getHauteurPixels();
	
	void dessinerCercle(double centreXPixels, double centreYPixels, double rayonPixels);
}
