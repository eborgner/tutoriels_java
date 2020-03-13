package tp01_corrige_client.commandes.choisir_choix;

import commun_client.commandes.CommandeRecue;
import tp01_corrige.enumerations.Choix;

public interface ChoisirChoixRecue extends CommandeRecue {
	
	Choix getChoix();

}
