package tp01_une_page_client.vues;

import commun_client.mvc.Vue;
import tp01_une_page.enumerations.Choix;

public interface VueParametres extends Vue {
	
	void afficherChoix(Choix choix);

}
