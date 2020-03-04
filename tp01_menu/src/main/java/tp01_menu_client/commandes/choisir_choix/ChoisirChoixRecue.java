package tp01_menu_client.commandes.choisir_choix;

import commun_client.commandes.CommandeRecue;
import tp01_menu.enumerations.Choix;

public interface ChoisirChoixRecue extends CommandeRecue {
	
	Choix getChoix();

}
