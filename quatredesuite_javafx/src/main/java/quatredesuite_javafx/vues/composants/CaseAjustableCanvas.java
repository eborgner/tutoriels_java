package quatredesuite_javafx.vues.composants;


import commun.debogage.J;
import commun_javafx.vues.composants.CanvasAjustable;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class CaseAjustableCanvas extends CanvasAjustable {
	
	private final double TAILLE_POURCENTAGE = 0.6;

	public CaseAjustableCanvas() {
		super();
		
		this.getStyleClass().add("conteneurCase");

		initialiserPinceau();
		dessinerCase();
	}

	@Override
	protected void reagirLargeurInitiale(double largeurInitiale) {
		J.appel(this);
		
	}

	@Override
	protected void reagirHauteurInitiale(double hauteurInitiale) {
		J.appel(this);
		
		dessinerCase();
	}

	@Override
	protected void reagirNouvelleLargeur(double ancienneLargeur, double nouvelleLargeur) {
		J.appel(this);

		dessinerCase();
	}

	@Override
	protected void reagirNouvelleHauteur(double ancienneHauteur, double nouvelleHauteur) {
		J.appel(this);

	}

	private void initialiserPinceau() {
		J.appel(this);

	}
	
	private void viderDessin() {
		J.appel(this);

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

	}


	private void dessinerContour(Case laCase) {
		J.appel(this);

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
