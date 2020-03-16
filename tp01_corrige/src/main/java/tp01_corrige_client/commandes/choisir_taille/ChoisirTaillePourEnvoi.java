package tp01_corrige_client.commandes.choisir_taille;

import commun_client.commandes.CommandePourEnvoi;
import tp01_corrige.enumerations.TailleGrille;

public interface ChoisirTaillePourEnvoi extends CommandePourEnvoi {
	
	void setTaille(TailleGrille taille);

}
