package quatredesuite_javafx.vues.composants;


import commun.debogage.J;
import commun_javafx.vues.composants.CanvasAjustable;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import javafx.animation.AnimationTimer;

public class CaseAjustable extends CanvasAjustable {
	
	AnimationTimer animation;

	public CaseAjustable() {
		super();
		
		creerAnimation();
		
		animation.start();
	}
	
	private void creerAnimation() {
		J.appel(this);
		
		long depart = System.nanoTime();
		
		double tempsCycleSecondes = 1;
		
		animation = new AnimationTimer() {
			@Override
			public void handle(long maintenant) {
				J.appel(this);
				
				double secondesEcoulees = (maintenant - depart) / 1E9;
				
				double instantDansCycle = (secondesEcoulees % tempsCycleSecondes) / tempsCycleSecondes;
				
				int rouge = (int) (255.0 * instantDansCycle);
				
				pinceau.setFill(Color.rgb(rouge, 255, 255));
				dessinerCase();
				
			}
		};
	}

	@Override
	protected void reagirNouvelleLargeur(double ancienneLargeur, double nouvelleLargeur) {
		J.appel(this);
		
		pinceau.setFill(Color.WHITE);
		dessinerCase();
	}

	@Override
	protected void reagirNouvelleHauteur(double ancienneHauteur, double nouvelleHauteur) {
		J.appel(this);

		pinceau.setFill(Color.WHITE);
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
		
		pinceau.fillArc(caseHautGaucheX, caseHautGaucheY, tailleCase, tailleCase, 0, 360, ArcType.ROUND);
		
	}
}
