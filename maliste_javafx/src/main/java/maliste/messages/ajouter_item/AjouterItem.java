package maliste.messages.ajouter_item;

import commun.debogage.J;
import commun.messages.Message;
import maliste.modeles.liste.Item;

public class AjouterItem extends Message<AjouterItemPourEnvoi, 
                                           AjouterItemRecu>

								   implements AjouterItemPourEnvoi, 
								   			  AjouterItemRecu {
	
	private Item item;
	
	@Override
	public Item getItem() {
		J.appel(this);
		
		return item;
	}

	@Override
	public void setItem(Item item) {
		J.appel(this);
		
		this.item = item;
	}


}
