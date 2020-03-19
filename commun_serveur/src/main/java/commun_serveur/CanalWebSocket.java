package commun_serveur;

import commun.debogage.J;
import commun.messages.Canal;
import commun.messages.Message;
import commun.utiles.Json;

import org.java_websocket.WebSocket;

@SuppressWarnings("rawtypes")
public class CanalWebSocket implements Canal {
	
	private WebSocket socket;
	
	private static long idCourant = 0;
	private long id = idCourant++;

	public CanalWebSocket(WebSocket socket) {
		J.appel(this);
		
		this.socket = socket;
	}

	@Override
	public boolean siOuvert() {
		J.appel(this);
		
		return socket.isOpen();
	}

	@Override
	public void envoyer(Message message) {
		J.appel(this);
		
		socket.send(Json.versJson(message));
	}

	@Override
	public void envoyer(String chaineMessage) {
		J.appel(this);

		socket.send(chaineMessage);
	}

	@Override
	public long getId() {
		J.appel(this);
		
		return id;
	}
	
	@Override 
	public int hashCode() {
		return socket.hashCode();
	}

	@Override 
	public boolean equals(Object other) {
		return socket.equals(other);
	}

}
