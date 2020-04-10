package commun_serveur;

import java.net.InetSocketAddress;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import commun.debogage.Erreur;
import commun.debogage.J;
import commun.messages.Canal;
import commun.messages.FabriqueMessage;

public abstract class ServeurWebSocket extends WebSocketServer {

    public ServeurWebSocket(int port) {
        super( new InetSocketAddress( port ) );
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
    	J.appel(this);
    	
    	FabriqueMessage.ajouterCanalPourRelais(new CanalWebSocket(conn));
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    	J.appel(this);
    	
    	FabriqueMessage.retirerCanalPourRelais(new CanalWebSocket(conn));
    }

    @Override
    public void onMessage(WebSocket socket, String chaineMessage) {
    	J.appel(this);
    	
    	FabriqueMessage.recevoirMessage(new CanalWebSocket(socket), chaineMessage);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
    	J.appel(this);
    	
    	if(conn != null) {
			FabriqueMessage.retirerCanalPourRelais(new CanalWebSocket(conn));
    	}

    	Erreur.nonFatale("Déconnexion sur erreur", ex);
    }

    @Override
    public void onStart() {
        J.appel(this);
    }
}
