package tp01_pages_client.commandes.choisir_choix;

import commun_client.commandes.CommandeRecue;
import tp01_pages.enumerations.Choix;

public interface ChoisirChoixRecue extends CommandeRecue {
	
	Choix getChoix();

}
