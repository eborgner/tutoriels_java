package commun_javafx;

import java.net.URI;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import commun.debogage.Erreur;
import commun.debogage.J;
import javafx.application.Platform;

public class ClientWebSocket extends WebSocketClient {
	
	public ClientWebSocket(URI serverUri) {
		super(serverUri);
		J.appel(this);
		
		//EnvoyeurMessageClient.initialiser(this);
	}

	@Override
	public void onOpen(ServerHandshake handshakedata) {
		J.appel(this);
	}

	@Override
	public void onMessage(String chaineMessage) {
		J.appel(this);

		// XXX: pour que ça soit une événement JavaFX
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				J.appel(this);

				//RecepteurMessage.recevoirMessageSur(ClientWebSocket.this, chaineMessage);
			}
		});
	}

	@Override
	public void onClose(int code, String reason, boolean remote) {
		J.appel(this);
	}

	@Override
	public void onError(Exception ex) {
		J.appel(this);
		Erreur.nonFatale("connexion échouée");
	}
}
