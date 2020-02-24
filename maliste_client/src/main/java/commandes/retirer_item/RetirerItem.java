package commandes.retirer_item;

import commun.debogage.J;
import commun_client.commandes.Commande;

public class RetirerItem extends Commande<RetirerItemPourEnvoi, RetirerItemRecue>
	   implements RetirerItemPourEnvoi, RetirerItemRecue {
	
	private int id;

	@Override
	public int getId() {
		J.appel(this);

		return id;
	}

	@Override
	public void setId(int id) {
		J.appel(this);
		
		this.id = id;
	}

}
