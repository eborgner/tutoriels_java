package quatredesuite_client.vues;

import commun_client.mvc.Vue;
import quatredesuite.enumerations.Couleur;

public interface VuePartieLocale extends VuePartie {

	void creerGrille(int largeur, int hauteur);
	void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur);

}
