package quatredesuite_client.commandes.nouvelle_partie_reseau;

import commun_client.commandes.Commande;

public class NouvellePartieReseau extends Commande<NouvellePartieReseauPourEnvoi, 
                                             NouvellePartieReseauRecue>

							implements NouvellePartieReseauPourEnvoi, 
							           NouvellePartieReseauRecue {
}
