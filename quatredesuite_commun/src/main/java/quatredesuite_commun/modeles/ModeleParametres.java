package quatredesuite.modeles;

import commun.debogage.J;
import commun.mvc.Modele;
import quatredesuite.Constantes;
import quatredesuite.enumerations.TailleGrille;

public class ModeleParametres extends Modele {

    // RAPPEL: gson a accès aux attributs private
    //         parce qu'on est en mode DEBUG
    //         dans le .jar/.apk de prod, il faut les setter/getter


    protected TailleGrille tailleGrille = Constantes.TAILLE_GRILLE_PAR_DEFAUT;
    
    public void choisirTaille(TailleGrille tailleGrille) {
        J.appel(this);

        this.tailleGrille = tailleGrille;
    }

    public boolean siTailleGrilleDejaChoisie(TailleGrille tailleGrille) {
        J.appel(this);

        return this.tailleGrille == tailleGrille;
    }
    
}
