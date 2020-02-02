package quatredesuite_javafx.vues.composants;


import commun.debogage.J;
import commun_javafx.vues.composants.CanvasAjustable;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class CaseAjustable extends CanvasAjustable {

	@Override
	protected void reagirNouvelleLargeur(double ancienneLargeur, double nouvelleLargeur) {
		J.appel(this);
		
		dessinerCase();
	}

	@Override
	protected void reagirNouvelleHauteur(double ancienneHauteur, double nouvelleHauteur) {
		J.appel(this);

		dessinerCase();
	}

	private void dessinerCase() {
		J.appel(this);
		
		
		double largeurDessin = getWidth();
		double hauteurDessin = getHeight();
		
		pinceau.clearRect(0, 0, largeurDessin, hauteurDessin);
		
		double tailleCase = largeurDessin * 0.6;
		if(hauteurDessin < largeurDessin) {
			tailleCase = hauteurDessin * 0.6;
		}
		
		double caseHautGaucheX = (largeurDessin - tailleCase) / 2;
		double caseHautGaucheY = (hauteurDessin - tailleCase) / 2;
		
		pinceau.setFill(Color.WHITE);
		pinceau.fillArc(caseHautGaucheX, caseHautGaucheY, tailleCase, tailleCase, 0, 360, ArcType.ROUND);
		
	}
}
