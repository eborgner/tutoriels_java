package tp01_pages_client.vues;

import commun_client.mvc.Vue;
import tp01_pages.enumerations.Choix;

public interface VueParametres extends Vue {
	
	void afficherChoix(Choix choix);

}
