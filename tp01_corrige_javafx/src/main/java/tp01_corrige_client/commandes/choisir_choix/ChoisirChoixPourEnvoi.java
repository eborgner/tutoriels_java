package tp01_corrige_client.commandes.choisir_choix;

import commun_client.commandes.CommandePourEnvoi;
import tp01_corrige.enumerations.Choix;

public interface ChoisirChoixPourEnvoi extends CommandePourEnvoi {
	
	void setChoix(Choix choix);

}
