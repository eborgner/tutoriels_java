package tp01_corrige_client.vues;

import commun_client.mvc.Vue;
import tp01_corrige.enumerations.Couleur;

public interface VuePartieLocale extends Vue {

	void creerGrille(int largeur, int hauteur);
	void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur);
	void animerEntreeJeton(int indiceColonne, int indiceRangee);

}
