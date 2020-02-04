package quatredesuite_javafx.vues.composants;


import commun.debogage.J;
import commun_javafx.vues.composants.CanvasAjustable;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;


public class CaseAjustable extends CanvasAjustable {
	
	private static final double TAILLE_PAR_DEFAUT_POURCENTAGE = 0.6;

	private class Case {
		public double caseHautGaucheX;
		public double caseHautGaucheY;
		public double tailleCase;
	}

	public CaseAjustable() {
		super();

		initialiserDessin();
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
