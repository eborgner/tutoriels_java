package tp01_menu_client.commandes.choisir_choix;

import commun_client.commandes.CommandePourEnvoi;
import tp01_menu.enumerations.Choix;

public interface ChoisirChoixPourEnvoi extends CommandePourEnvoi {
	
	void setChoix(Choix choix);

}
