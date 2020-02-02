package pong_client.commandes.reagir_temps_qui_passe;

import commun_client.commandes.CommandePourEnvoi;

public interface ReagirTempsQuiPassePourEnvoi extends CommandePourEnvoi {
	
	void setTempsEcouleSecondes(double tempsEcouleSecondes);

}
