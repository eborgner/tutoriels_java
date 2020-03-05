package tp01_temps_reel_client.commandes.jouer_coup;

import commun_client.commandes.CommandePourEnvoi;

public interface JouerCoupPourEnvoi extends CommandePourEnvoi { 
	
	void setInfoCoup(int infoCoup);
	
}
