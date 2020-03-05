package tp01_pages_client.commandes.retour_accueil;

import commun_client.commandes.Commande;

public class RetourAccueil extends Commande<RetourAccueilPourEnvoi, 
                                               RetourAccueilRecue>

							  implements RetourAccueilPourEnvoi,
							             RetourAccueilRecue {
}
