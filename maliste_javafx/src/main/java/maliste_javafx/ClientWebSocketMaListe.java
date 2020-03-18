package maliste_javafx;

import java.net.URI;

import commun.debogage.J;
import commun_javafx.ClientWebSocketFX;

public class ClientWebSocketMaListe extends ClientWebSocketFX {

	public ClientWebSocketMaListe(URI serverUri) {
		super(serverUri);
		J.appel(this);
	}

}
