package tp01_corrige_javafx_client.commandes.choisir_choix;

import commun_client.commandes.CommandeRecue;
import tp01_corrige_javafx.enumerations.Choix;

public interface ChoisirChoixRecue extends CommandeRecue {
	
	Choix getChoix();

}
