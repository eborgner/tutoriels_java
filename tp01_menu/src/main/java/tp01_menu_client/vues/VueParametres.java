package tp01_menu_client.vues;

import commun_client.mvc.Vue;
import tp01_menu.enumerations.Choix;

public interface VueParametres extends Vue {
	
	void afficherChoix(Choix choix);

}
