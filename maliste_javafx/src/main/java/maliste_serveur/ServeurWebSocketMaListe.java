package maliste_serveur;

import commun.debogage.J;
import commun.messages.Message;
import commun_serveur.ServeurWebSocket;

public class ServeurWebSocketMaListe extends ServeurWebSocket {

	public ServeurWebSocketMaListe(int port) {
		super(port);
		J.appel(this);
	}


}
