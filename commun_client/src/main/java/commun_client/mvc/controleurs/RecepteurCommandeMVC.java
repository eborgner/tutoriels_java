package commun_client.mvc.controleurs;

import commun.debogage.J;
import commun_client.commandes.CommandeRecue;
import commun_client.commandes.RecepteurCommande;

public abstract class RecepteurCommandeMVC<CR extends CommandeRecue> extends RecepteurCommande<CR>{

	@Override
	public void executerCommande(CR commande) {
		J.appel(this);

		executerCommandeMVC(commande);

		commande.notifierCommandeTraitee();
	}
	
	public abstract void executerCommandeMVC(CR commande);

}
