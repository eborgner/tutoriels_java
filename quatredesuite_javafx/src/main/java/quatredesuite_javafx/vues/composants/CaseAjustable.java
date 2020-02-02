package quatredesuite_javafx.vues.composants;


import commun.debogage.J;
import commun_javafx.vues.composants.CanvasAjustable;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.event.Event;

public class CaseAjustable extends CanvasAjustable {
	
	private static final double TAILLE_PAR_DEFAUT_POURCENTAGE = 0.6;
	AnimationTimer animation;

	public CaseAjustable() {
		super();

		initialiserDessin();
		
		creerAnimation();

		installerListeners();
	}
	

	private void creerAnimation() {
		J.appel(this);

		animation = new AnimationTimer() {

			private long avant = System.nanoTime();
			private double tempsCycleSecondes = 0.5;
			private double facteurCourant = 0;
			private double facteurMin = 0;
			private double facteurMax = 1;
			private double directionIncrement = 1;

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
				
				double increment = ratioEcoule * (facteurMax - facteurMin);

				facteurCourant += directionIncrement * increment;
				
				if(facteurCourant > facteurMax) {

					facteurCourant = facteurMax;
					directionIncrement =  -1;

				}else if(facteurCourant < facteurMin) {

					facteurCourant = facteurMin;
					directionIncrement = 1;
				}
			}

			private void dessinerProchain() {
				J.appel(this);

				int prochainRGB = (int) (facteurCourant * 255);
				int incrementCouleur = (int) (facteurCourant * 35);
				int angleDepartDegre = (int) (facteurCourant * 360);
				
				reinitialiserDessin();
				
				dessinerPremierArc(prochainRGB, incrementCouleur, angleDepartDegre);
				dessinerDeuxiemeArc(prochainRGB, incrementCouleur, angleDepartDegre);
				dessinerTroisiemeArc(prochainRGB, incrementCouleur, angleDepartDegre);
			}

			private void dessinerPremierArc(int prochainRGB, int incrementCouleur, int angleDepartDegre) {
				J.appel(this);

				pinceau.setStroke(Color.rgb(220 + incrementCouleur, 220 + incrementCouleur, prochainRGB));
				pinceau.setLineWidth(0.02*getWidth());
				dessinerArc(0.8*TAILLE_PAR_DEFAUT_POURCENTAGE, angleDepartDegre);
			}

			private void dessinerDeuxiemeArc(int prochainRGB, int incrementCouleur, int angleDepartDegre) {
				J.appel(this);

				pinceau.setStroke(Color.rgb(220 + incrementCouleur, prochainRGB, 220 + incrementCouleur));
				pinceau.setLineWidth(0.015*getWidth());
				dessinerArc(0.6*TAILLE_PAR_DEFAUT_POURCENTAGE, (angleDepartDegre+90)%360);
			}

			private void dessinerTroisiemeArc(int prochainRGB, int incrementCouleur, int angleDepartDegre) {
				J.appel(this);

				pinceau.setStroke(Color.rgb(prochainRGB, 220 + incrementCouleur, 220 + incrementCouleur));
				pinceau.setLineWidth(0.010*getWidth());
				dessinerArc(0.4*TAILLE_PAR_DEFAUT_POURCENTAGE, (angleDepartDegre+180)%360);
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
				reinitialiserDessin();
			}

		});
	}

	@Override
	protected void reagirNouvelleLargeur(double ancienneLargeur, double nouvelleLargeur) {
		J.appel(this);
		
		reinitialiserDessin();
	}

	@Override
	protected void reagirNouvelleHauteur(double ancienneHauteur, double nouvelleHauteur) {
		J.appel(this);

		reinitialiserDessin();
	}

	private void initialiserDessin() {
		J.appel(this);

		initialiserPinceau();
		dessinerCase(TAILLE_PAR_DEFAUT_POURCENTAGE);
	}

	private void reinitialiserDessin() {
		J.appel(this);

		viderDessin();
		initialiserDessin();
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

	private class Case {
		public double caseHautGaucheX;
		public double caseHautGaucheY;
		public double tailleCase;
	}

	private void dessinerCase(double taillePourcentage) {
		J.appel(this);
		
		Case laCase = calculerCase(taillePourcentage);
		
		pinceau.fillArc(laCase.caseHautGaucheX, 
						laCase.caseHautGaucheY, 
						laCase.tailleCase, 
						laCase.tailleCase, 
						0, 
						360, 
						ArcType.ROUND);

		pinceau.strokeArc(laCase.caseHautGaucheX, 
						  laCase.caseHautGaucheY, 
						  laCase.tailleCase, 
						  laCase.tailleCase, 
						  0, 
						  360, 
						  ArcType.OPEN);
	}


	private void dessinerArc(double taillePourcentage, int angleDepartDegre) {
		J.appel(this);
		
		Case laCase = calculerCase(taillePourcentage);
		pinceau.strokeArc(laCase.caseHautGaucheX, 
						  laCase.caseHautGaucheY, 
						  laCase.tailleCase, 
						  laCase.tailleCase, 
						  angleDepartDegre, 
						  90, 
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

	
	
}
