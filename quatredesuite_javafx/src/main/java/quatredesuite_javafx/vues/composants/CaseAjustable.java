package quatredesuite_javafx.vues.composants;


import commun.debogage.J;
import commun_javafx.vues.composants.CanvasAjustable;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import quatredesuite.enumerations.Couleur;


public class CaseAjustable extends CanvasAjustable {
	
	private final double TAILLE_POURCENTAGE = 0.6;
	
	private Color couleurRouge;
	private Color couleurJaune;

	private class Case {
		public double caseHautGaucheX;
		public double caseHautGaucheY;
		public double tailleCase;
	}

	public CaseAjustable(Color couleurRouge, Color couleurJaune) {
		super();
		
		this.couleurRouge = couleurRouge;
		this.couleurJaune = couleurJaune;
		

		initialiserPinceau();
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
		
		Case laCase = calculerCase();
		
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

	private Case calculerCase() {
		J.appel(this);
		
		Case laCase = new Case();

		double largeurDessin = getWidth();
		double hauteurDessin = getHeight();
		
		laCase.tailleCase = largeurDessin * TAILLE_POURCENTAGE;

		if(hauteurDessin < largeurDessin) {
			laCase.tailleCase = hauteurDessin * TAILLE_POURCENTAGE;
		}
		
		laCase.caseHautGaucheX = (largeurDessin - laCase.tailleCase) / 2;
		laCase.caseHautGaucheY = (hauteurDessin - laCase.tailleCase) / 2;
		
		return laCase;
	}

	public void afficherJeton(Couleur couleur) {
		J.appel(this);
		
		switch(couleur) {
		
			case ROUGE:
				pinceau.setFill(couleurRouge);
				dessinerCase();
			break;

			case JAUNE:
				pinceau.setFill(couleurJaune);
				dessinerCase();
			break;
		}
	}
}
