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

	private class Case {
		public double caseHautGaucheX;
		public double caseHautGaucheY;
		public double tailleCase;
	}

	public CaseAjustable() {
		super();

		initialiserPinceau();
		dessinerCase();
		
		creerAnimation();

		installerListeners();
	}

	private void creerAnimation() {
		J.appel(this);

		animation = new AnimationTimer() {

			private long avant = System.nanoTime();
			private double tempsCycleSecondes = 0.5;
			private double facteurMin = 0;
			private double facteurMax = 1;
			private double facteurCourant = facteurMax;

			@Override
			public void handle(long maintenant) {
				J.setActif(false);
				J.appel(this);
				
				double secondesEcoulees = (maintenant - avant) / 1E9;
				avant = maintenant;

				calculerFacteurCourant(secondesEcoulees);
				
				dessinerProchain();

				J.setActif(true);
			}

			private void calculerFacteurCourant(double secondesEcoulees) {
				J.appel(this);

				double ratioEcoule = secondesEcoulees / tempsCycleSecondes;
				
				facteurCourant = facteurCourant - ratioEcoule * facteurMax;
				
				if(facteurCourant < facteurMin) {

					facteurCourant = facteurMax;
				}
			}

			private void dessinerProchain() {
				J.appel(this);

				viderDessin();

				dessinerCase();
				dessinerImageCle(facteurCourant);
			}

			private void dessinerImageCle(double facteurCourant) {
				J.appel(this);
		
				dessinerCase(TAILLE_POURCENTAGE * facteurCourant);
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
}
