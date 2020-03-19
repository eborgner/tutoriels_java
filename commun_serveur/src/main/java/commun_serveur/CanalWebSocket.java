package commun_serveur;

import commun.debogage.J;
import commun.messages.Canal;
import commun.messages.Message;
import commun.utiles.Json;


import org.java_websocket.WebSocketImpl;
import org.java_websocket.WebSocketListener;
import org.java_websocket.drafts.Draft;

@SuppressWarnings("rawtypes")
public class CanalWebSocket extends WebSocketImpl implements Canal {
	
	private static long idCourant = 0;
	private long id = idCourant++;

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

	@Override
	public void envoyer(String chaineMessage) {
		J.appel(this);

		send(chaineMessage);
	}

	@Override
	public long getId() {
		J.appel(this);

		return id;
	}

}
