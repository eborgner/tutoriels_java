package maliste.messages.ajouter_item;

import commun.messages.MessagePourEnvoi;
import maliste.modeles.liste.Item;

public interface AjouterItemPourEnvoi extends MessagePourEnvoi {
	
	void setItem(Item item);
	
}
