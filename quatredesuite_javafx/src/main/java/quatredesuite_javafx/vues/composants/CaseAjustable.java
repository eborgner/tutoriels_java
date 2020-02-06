package quatredesuite_javafx.vues.composants;


import commun.debogage.J;
import commun_javafx.vues.composants.CanvasAjustable;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.event.Event;

public class CaseAjustable extends CanvasAjustable {
	
	private final double TAILLE_POURCENTAGE = 0.6;
	AnimationTimer animation;


	public CaseAjustable() {
		super();

		initialiserPinceau();
		dessinerCase();
		
		creerAnimation();

		installerListeners();
	}

	@Override
	protected void reagirLargeurInitiale(double largeurInitiale) {
		J.appel(this);
		
		dessinerCase();
	}

	@Override
	protected void reagirHauteurInitiale(double hauteurInitiale) {
		J.appel(this);

		dessinerCase();
	}

	@Override
	protected void reagirNouvelleLargeur(double ancienneLargeur, double nouvelleLargeur) {
		J.appel(this);

		viderDessin();

		dessinerCase();
	}

	@Override
	protected void reagirNouvelleHauteur(double ancienneHauteur, double nouvelleHauteur) {
		J.appel(this);

		viderDessin();

		dessinerCase();
	}

	private void initialiserPinceau() {
		J.appel(this);

		pinceau.setFill(Color.WHITE);
		pinceau.setStroke(Color.BLACK);
		pinceau.setLineWidth(0.01*getWidth());
	}
	
	private void viderDessin() {
		J.appel(this);

		pinceau.clearRect(0, 0, getWidth(), getHeight());
	}
	
	private void dessinerCase() {
		J.appel(this);
		
		dessinerCase(TAILLE_POURCENTAGE);
	}

	private class Case {
		public double caseHautGaucheX;
		public double caseHautGaucheY;
		public double tailleCase;
	}
	
	private void dessinerCase(double taillePourcentage) {
		J.appel(this);
		
		Case laCase = calculerCase(taillePourcentage);
		
		dessinerFond(laCase);
		dessinerContour(laCase);
	}

	private void dessinerFond(Case laCase) {
		J.appel(this);

		pinceau.fillArc(laCase.caseHautGaucheX, 
						laCase.caseHautGaucheY, 
						laCase.tailleCase, 
						laCase.tailleCase, 
						0, 
						360, 
						ArcType.ROUND);
	}

	private void dessinerContour(Case laCase) {
		J.appel(this);

		pinceau.strokeArc(laCase.caseHautGaucheX, 
						  laCase.caseHautGaucheY, 
						  laCase.tailleCase, 
						  laCase.tailleCase, 
						  0, 
						  360, 
						  ArcType.OPEN);
	}

	private Case calculerCase(double taillePourcentage) {
		J.appel(this);
		
		Case laCase = new Case();

		double largeurDessin = getWidth();
		double hauteurDessin = getHeight();
		
		laCase.tailleCase = largeurDessin * taillePourcentage;

		if(hauteurDessin < largeurDessin) {
			laCase.tailleCase = hauteurDessin * taillePourcentage;
		}
		
		laCase.caseHautGaucheX = (largeurDessin - laCase.tailleCase) / 2;
		laCase.caseHautGaucheY = (hauteurDessin - laCase.tailleCase) / 2;
		
		return laCase;
	}
	
	private void creerAnimation() {
		J.appel(this);

		animation = new AnimationTimer() {

			private long avant;
			private double tempsCycleSecondes = 2.5;
			
			@Override
			public void start() {
				J.appel(this);
				
				avant = System.nanoTime();

				super.start();
			}

			@Override
			public void handle(long maintenant) {
				J.setActif(true);
				J.appel(this);
				
				double secondesEcoulees = (maintenant - avant) / 1E9;

				double endroitDuCycle = calculerFacteurCourant(secondesEcoulees);
				
				J.valeurs(endroitDuCycle);
				
				dessinerProchain(endroitDuCycle);

				J.setActif(true);
			}

			private double calculerFacteurCourant(double secondesEcoulees) {
				J.appel(this);

				double tempsNormalise = secondesEcoulees / tempsCycleSecondes * Math.PI * 2;
				
				return Math.cos(tempsNormalise);
			}

			private void dessinerProchain(double endroitDuCycle) {
				J.appel(this);

				viderDessin();

				dessinerCase();
				dessinerImageCle(endroitDuCycle);
			}

			private void dessinerImageCle(double endroitDuCycle) {
				J.appel(this);
		
				dessinerCase(TAILLE_POURCENTAGE * Math.abs(endroitDuCycle));
			}
		};
	}

	
	
	
	
	
	
	private void installerListeners() {
		J.appel(this);
		
		this.setOnMouseEntered(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);

				animation.start();
			}
		});
		
		this.setOnMouseExited(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);
				
				animation.stop();

				viderDessin();

				dessinerCase();
			}
		});
	}
}
