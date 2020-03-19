package commun_client;

import java.net.URI;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import commun.debogage.Erreur;
import commun.debogage.J;
import commun.messages.Canal;
import commun.messages.Message;
import commun.utiles.Json;

@SuppressWarnings("rawtypes")
public abstract class ClientWebSocket extends WebSocketClient implements Canal {
	
	public ClientWebSocket(URI serverUri) {
		super(serverUri);
		J.appel(this);
	}

	@Override
	public void onOpen(ServerHandshake handshakedata) {
		J.appel(this);
	}

	@Override
	public void onMessage(String chaineMessage) {
		J.appel(this);
	}

	@Override
	public void onClose(int code, String reason, boolean remote) {
		J.appel(this);
	}

	@Override
	public void onError(Exception ex) {
		J.appel(this);

		Erreur.nonFatale("Connexion perdue sur erreur", ex);
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
		
		// XXX: sur le client, l'id n'est pas utile
		return 0;
	}
}
