package quatredesuite_javafx.vues.composants;


import commun.debogage.J;
import commun_javafx.vues.composants.CanvasAjustable;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.event.Event;

public class CaseAjustable extends CanvasAjustable {
	
	AnimationTimer animation;

	public CaseAjustable() {
		super();
		
		creerAnimation();
		
		installerListeners();
	}
	

	private void creerAnimation() {
		J.appel(this);

		animation = new AnimationTimer() {

			private long avant = System.nanoTime();
			private double tempsCycleSecondes = 0.5;
			private int rougeCourant = 0;
			private int directionIncrementRouge = 1;

			@Override
			public void handle(long maintenant) {
				J.setActif(false);
				J.appel(this);
				
				double secondesEcoulees = (maintenant - avant) / 1E9;
				
				double ratioEcoule = secondesEcoulees / tempsCycleSecondes;
				
				int incrementRouge = (int) (255.0 * ratioEcoule);

				int prochainRouge = rougeCourant + directionIncrementRouge * incrementRouge;

				if(prochainRouge > 255) {
					prochainRouge = 255;
					directionIncrementRouge =  -1;
				}else if(prochainRouge < 0) {
					prochainRouge = 0;
					directionIncrementRouge = 1;
				}
				
				pinceau.setFill(Color.rgb(prochainRouge, 255, 255));
				dessinerCase();

				rougeCourant = prochainRouge;
				avant = maintenant;

				J.setActif(true);
			}
		};
	}

	private void installerListeners() {
		J.appel(this);
		
		this.setOnMouseEntered(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);
				
				pinceau.setFill(Color.WHITE);
				animation.start();
			}
		});
		
		this.setOnMouseExited(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);
				
				animation.stop();
				pinceau.setFill(Color.WHITE);
				dessinerCase();
			}
		});
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
