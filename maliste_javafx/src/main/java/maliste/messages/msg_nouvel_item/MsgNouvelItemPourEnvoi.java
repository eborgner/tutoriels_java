package maliste.messages.msg_nouvel_item;

import commun.messages.MessagePourEnvoi;
import maliste.modeles.liste.Item;

public interface MsgNouvelItemPourEnvoi extends MessagePourEnvoi {
	
	void setItem(Item item);
	
}
