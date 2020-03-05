package tp01_temps_reel_client.vues;

import commun_client.mvc.Vue;
import tp01_temps_reel.modeles.monde2d.Dessin2D;

public interface VuePartieLocale extends Vue {
	
	void afficherNombreCoups(int nombreCoups);
	Dessin2D getDessin2D();

}
