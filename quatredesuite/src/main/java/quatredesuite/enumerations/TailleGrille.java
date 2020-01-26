package quatredesuite.enumerations;

import commun.debogage.J;
import quatredesuite.Constantes;

public enum TailleGrille {

    PETITE,
    MOYENNE,
    GRANDE;

    public int getHauteur(){
        J.appel(this);

        switch(this){
            case PETITE:

                return Constantes.HAUTEUR_PETITE_GRILLE;

            case MOYENNE:

                return Constantes.HAUTEUR_MOYENNE_GRILLE;

            case GRANDE:

                return Constantes.HAUTEUR_GRANDE_GRILLE;
        }

        throw new RuntimeException("Taille inconnue: " + this.name());

    }

    public int getLargeur(){
        J.appel(this);

        switch(this){

            case PETITE:

                return Constantes.LARGEUR_PETITE_GRILLE;

            case MOYENNE:

                return Constantes.LARGEUR_MOYENNE_GRILLE;

            case GRANDE:

                return Constantes.LARGEUR_GRANDE_GRILLE;
        }

        throw new RuntimeException("Taille inconnue: " + this.name());

    }

    public int getPourGagner(){
        J.appel(this);

        switch(this){
            case PETITE:

                return Constantes.POUR_GAGNER_PETIT;

            case MOYENNE:

                return Constantes.POUR_GAGNER_MOYEN;

            case GRANDE:

                return Constantes.POUR_GAGNER_GRAND;
        }

        throw new RuntimeException("Taille inconnue: " + this.name());

    }
}
