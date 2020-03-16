package tp01_corrige_client.vues;

import commun_client.mvc.Vue;
import tp01_corrige.enumerations.TailleGrille;

public interface VueParametres extends Vue {
	
	void afficherTaille(TailleGrille taille);
}
