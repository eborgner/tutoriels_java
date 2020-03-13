package tp01_corrige_javafx_javafx.vues.composants;


import commun.debogage.J;

import commun_javafx.vues.composants.CanvasAjustable;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public abstract class CaseAjustable extends CanvasAjustable {
    
    private final double TAILLE_POURCENTAGE = 0.6;
    

    public CaseAjustable() {
        super();
        J.appel(this);

        initialiserPinceau();
        dessinerCase();
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
    
    protected void viderDessin() {
        J.appel(this);

        pinceau.clearRect(0, 0, getWidth(), getHeight());
    }
    
    protected void dessinerCase() {
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


    
}
