package tp01_temps_reel_client.commandes.nouvelle_partie;

import commun_client.commandes.Commande;

public class NouvellePartie extends Commande<NouvellePartiePourEnvoi, 
                                             NouvellePartieRecue>

							implements NouvellePartiePourEnvoi, 
							           NouvellePartieRecue {
}
