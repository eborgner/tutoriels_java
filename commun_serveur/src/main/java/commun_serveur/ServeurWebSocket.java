package commun_serveur;

import java.net.InetSocketAddress;

import java.util.HashSet;
import java.util.Set;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import commun.debogage.Erreur;
import commun.debogage.J;

public abstract class ServeurWebSocket extends WebSocketServer {
	
	protected Set<WebSocket> connexions = new HashSet<>();

    public ServeurWebSocket(int port) {
        super( new InetSocketAddress( port ) );
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
    	J.appel(this);

    	connexions.add(conn);
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    	J.appel(this);

    	connexions.remove(conn);
    }

    @Override
    public void onMessage(WebSocket socket, String chaineMessage) {
    	J.appel(this);

    	for(WebSocket connexion : connexions) {
    		if(!connexion.equals(socket)) {
    			connexion.send(chaineMessage);
    		}
    	}
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
    	J.appel(this);
    	
    	connexions.remove(conn);
    	Erreur.nonFatale("Déconnexion sur erreur", ex);
    }

    @Override
    public void onStart() {
        J.appel(this);
    }
}
