package tp01_une_page_client.commandes.nouvelle_partie;

import commun_client.commandes.Commande;

public class NouvellePartie extends Commande<NouvellePartiePourEnvoi, 
                                             NouvellePartieRecue>

							implements NouvellePartiePourEnvoi, 
							           NouvellePartieRecue {
}
