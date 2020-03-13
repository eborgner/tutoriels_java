package quatredesuite_javafx_client.commandes.choisir_choix;

import commun_client.commandes.CommandePourEnvoi;
import quatredesuite_javafx.enumerations.Choix;

public interface ChoisirChoixPourEnvoi extends CommandePourEnvoi {
	
	void setChoix(Choix choix);

}
