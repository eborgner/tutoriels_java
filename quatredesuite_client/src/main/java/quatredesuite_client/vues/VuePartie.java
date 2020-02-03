package quatredesuite_client.vues;

import commun_client.mvc.Vue;
import quatredesuite.enumerations.Couleur;

public interface VuePartie extends Vue {

	void creerGrille(int largeur, int hauteur);
	void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur);
	void colorerEntete(int indiceColonne, Couleur couleur);
	

}