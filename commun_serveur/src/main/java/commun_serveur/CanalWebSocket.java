package commun_serveur;

import commun.debogage.J;
import commun.messages.Canal;
import commun.messages.Message;
import commun.utiles.Json;

import org.java_websocket.WebSocket;

@SuppressWarnings("rawtypes")
public class CanalWebSocket implements Canal {
	
	private WebSocket socket;

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

	protected WebSocket getSocket() {
		J.appel(this);
		
		return socket;
	}

	@Override 
	public int hashCode() {
		return socket.hashCode();
	}

	@Override 
	public boolean equals(Object autreObjet) {
		if(autreObjet instanceof CanalWebSocket) {

			return ((CanalWebSocket) autreObjet).getSocket().equals(socket);
		}

		return false;
	}

}
