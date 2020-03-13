package tp01_corrige_javafx_client.commandes.choisir_choix;

import commun_client.commandes.CommandePourEnvoi;
import tp01_corrige_javafx.enumerations.Choix;

public interface ChoisirChoixPourEnvoi extends CommandePourEnvoi {
	
	void setChoix(Choix choix);

}
