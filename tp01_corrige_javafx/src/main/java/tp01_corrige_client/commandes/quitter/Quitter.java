package tp01_corrige_client.commandes.quitter;

import commun_client.commandes.Commande;

public class Quitter extends Commande<QuitterPourEnvoi, 
                                      QuitterRecue> 

					 implements QuitterPourEnvoi,
					            QuitterRecue {
}
