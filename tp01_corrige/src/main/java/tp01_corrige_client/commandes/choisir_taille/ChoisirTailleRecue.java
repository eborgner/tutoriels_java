package tp01_corrige_client.commandes.choisir_taille;

import commun_client.commandes.CommandeRecue;
import tp01_corrige.enumerations.TailleGrille;

public interface ChoisirTailleRecue extends CommandeRecue {
	
	TailleGrille getTaille();

}
