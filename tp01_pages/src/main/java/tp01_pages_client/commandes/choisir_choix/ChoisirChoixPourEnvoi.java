package tp01_une_page_client.commandes.choisir_choix;

import commun_client.commandes.CommandePourEnvoi;
import tp01_une_page.enumerations.Choix;

public interface ChoisirChoixPourEnvoi extends CommandePourEnvoi {
	
	void setChoix(Choix choix);

}
