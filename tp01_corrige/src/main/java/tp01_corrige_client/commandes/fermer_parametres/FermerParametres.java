package tp01_corrige_client.commandes.fermer_parametres;

import commun_client.commandes.Commande;

public class FermerParametres extends Commande<FermerParametresPourEnvoi, 
                                               FermerParametresRecue>

							  implements FermerParametresPourEnvoi,
							             FermerParametresRecue {
}
