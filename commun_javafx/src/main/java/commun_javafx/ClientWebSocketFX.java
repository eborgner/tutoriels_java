package commun_javafx;

import java.net.URI;

import commun.debogage.J;
import commun.messages.Canal;
import commun.messages.FabriqueMessage;
import commun_client.ClientWebSocket;
import javafx.application.Platform;

public abstract class ClientWebSocketFX extends ClientWebSocket {
	
	public ClientWebSocketFX(URI serverUri) {
		super(serverUri);
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
				
				FabriqueMessage.recevoirOuRelayerMessage(ClientWebSocketFX.this, chaineMessage);
			}
		});
	}
}
