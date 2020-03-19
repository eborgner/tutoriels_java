package maliste.messages.msg_nouvel_item;

import commun.debogage.J;
import commun.messages.Message;
import maliste.modeles.liste.Item;

public class MsgNouvelItem extends Message<MsgNouvelItemPourEnvoi, 
                                           MsgNouvelItemRecu>

								   implements MsgNouvelItemPourEnvoi, 
								   			  MsgNouvelItemRecu {
	
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
