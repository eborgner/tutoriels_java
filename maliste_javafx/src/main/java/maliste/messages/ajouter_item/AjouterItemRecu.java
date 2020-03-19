package maliste.messages.ajouter_item;

import commun.messages.MessageRecu;
import maliste.modeles.liste.Item;

public interface AjouterItemRecu extends MessageRecu {
	
	Item getItem();

}
