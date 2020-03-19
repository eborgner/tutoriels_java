package maliste_client.commandes.retirer_item;

import commun.debogage.J;
import commun_client.commandes.Commande;

public class RetirerItem extends Commande<RetirerItemPourEnvoi, RetirerItemRecue>
	   implements RetirerItemPourEnvoi, RetirerItemRecue {
	
	private String id;

	@Override
	public String getId() {
		J.appel(this);

		return id;
	}

	@Override
	public void setId(String id) {
		J.appel(this);
		
		this.id = id;
	}

}
