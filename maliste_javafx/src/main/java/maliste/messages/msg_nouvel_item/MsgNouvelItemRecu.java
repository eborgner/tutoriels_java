package maliste.messages.msg_nouvel_item;

import commun.messages.MessageRecu;
import maliste.modeles.liste.Item;

public interface MsgNouvelItemRecu extends MessageRecu {
	
	Item getItem();

}
