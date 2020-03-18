package commun_serveur;

import commun.debogage.J;
import commun.messages.Canal;
import commun.messages.Message;
import commun.utiles.Json;


import org.java_websocket.WebSocketImpl;
import org.java_websocket.WebSocketListener;
import org.java_websocket.drafts.Draft;

public class CanalWebSocket extends WebSocketImpl implements Canal {

	public CanalWebSocket(WebSocketListener listener, Draft draft) {
		super(listener, draft);
		J.appel(this);
	}

	@Override
	public boolean siOuvert() {
		J.appel(this);
		
		return isOpen();
	}

	@Override
	public void envoyer(Message message) {
		J.appel(this);
		
		send(Json.versJson(message));
	}
}
