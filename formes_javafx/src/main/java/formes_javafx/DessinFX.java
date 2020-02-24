package formes_javafx;

import commun.debogage.J;
import formes.Dessin;
import formes.MonDessin;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class DessinFX extends Canvas implements MonDessin {
	
	private GraphicsContext pinceau;
	
	public DessinFX(double largeur, double hauteur) {
		super(largeur, hauteur);
		J.appel(this);
		
		pinceau = this.getGraphicsContext2D();
	}

	@Override
	public void changerCouleur(String couleur) {
		J.appel(this);
		
		pinceau.setFill(Color.valueOf(couleur));
	}

	@Override
	public void dessinerCarre(double centreX, double centreY, double taille) {
		J.appel(this);

        pinceau.fillRect(centreX-taille/2, 
                         centreY-taille/2, 
                         taille, 
                         taille);
	}

	@Override
	public void dessinerRectangle(double centreX, double centreY, double largeur, double hauteur) {
		J.appel(this);

        pinceau.fillRect(centreX-largeur/2, 
                         centreY-hauteur/2, 
                         largeur, 
                         hauteur);
	}

	@Override
	public void dessinerCercle(double centreX, double centreY, double rayon) {
		J.appel(this);

        pinceau.fillArc(centreX-rayon, 
                        centreY-rayon, 
                        rayon, 
                        rayon, 
                        0, 
                        360, 
                        ArcType.ROUND);
	}
}
