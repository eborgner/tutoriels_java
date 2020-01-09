package quatredesuite;

import quatredesuite.enumerations.Couleur;
import quatredesuite.enumerations.TailleGrille;

public class Constantes {

    public static final TailleGrille TAILLE_GRILLE_PAR_DEFAUT = TailleGrille.PETITE;
    public static final Boolean SI_CONTINUER_PARTIE_PAR_DEFAUT = true;

    public static final int HAUTEUR_PETITE_GRILLE = 4;
    public static final int HAUTEUR_MOYENNE_GRILLE = 6;
    public static final int HAUTEUR_GRANDE_GRILLE = 8;

    public static final int LARGEUR_PETITE_GRILLE = 4;
    public static final int LARGEUR_MOYENNE_GRILLE = 7;
    public static final int LARGEUR_GRANDE_GRILLE = 10;

    public static final Couleur COULEUR_QUI_COMMENCE = Couleur.ROUGE;

    public static final String ID_USAGER_PAR_DEFAUT = "defaut";

    public static final String ID_PARTIE_RESEAU = "defaut";

    public static final int POUR_GAGNER_PETIT = 3;
    public static final int POUR_GAGNER_MOYEN = 4;
    public static final int POUR_GAGNER_GRAND = 5;
}
