package commandes.nouvel_item;

import commun.debogage.J;
import commun_client.commandes.Commande;

public class NouvelItem 
       extends Commande<NouvelItemPourEnvoi, NouvelItemRecue>
       implements NouvelItemPourEnvoi, NouvelItemRecue {
	
	private String texte;

	@Override
	public String getTexte() {
		J.appel(this);

		return texte;
	}

	@Override
	public void setTexte(String texte) {
		J.appel(this);

		this.texte = texte;
	}
	
}
