package tp01_une_page_client.commandes.choisir_choix;

import commun_client.commandes.CommandeRecue;
import tp01_une_page.enumerations.Choix;

public interface ChoisirChoixRecue extends CommandeRecue {
	
	Choix getChoix();

}
