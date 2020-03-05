package tp01_temps_reel_javafx.vues.composants;

import commun.debogage.J;
import commun_javafx.vues.composants.CanvasAjustable;
import javafx.scene.shape.ArcType;
import tp01_temps_reel.modeles.monde2d.Dessin2D;

public class MonDessin2D extends CanvasAjustable implements Dessin2D {

	@Override
	protected void reagirLargeurInitiale(double largeurInitiale) {
		J.appel(this);
	}

	@Override
	protected void reagirHauteurInitiale(double hauteurInitiale) {
		J.appel(this);
	}

	@Override
	protected void reagirNouvelleLargeur(double ancienneLargeur, double nouvelleLargeur) {
		J.appel(this);
	}

	@Override
	protected void reagirNouvelleHauteur(double ancienneHauteur, double nouvelleHauteur) {
		J.appel(this);
	}

	@Override
	public double getLargeurPixels() {
		J.appel(this);
		
		return getWidth();
	}

	@Override
	public double getHauteurPixels() {
		J.appel(this);
		
		return getHeight();
	}

	@Override
	public void dessinerCercle(double centreXPixels, double centreYPixels, double rayonPixels) {
		J.appel(this);
		
		pinceau.fillArc(centreXPixels - rayonPixels / 2,
			         	centreYPixels - rayonPixels / 2,
			         	rayonPixels, 
			         	rayonPixels, 
			         	0, 
			         	360, 
			         	ArcType.ROUND);
	}
	
	@Override
	public void viderDessin(){
		J.appel(this);
		
		pinceau.clearRect(0, 0, getWidth(), getHeight());
	}

		
}
