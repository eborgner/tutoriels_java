package tp01_pages_client.commandes.choisir_choix;

import commun_client.commandes.CommandePourEnvoi;
import tp01_pages.enumerations.Choix;

public interface ChoisirChoixPourEnvoi extends CommandePourEnvoi {
	
	void setChoix(Choix choix);

}
