package pong_serveur;

import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import commun.debogage.J;

public class Serveur extends WebSocketServer {
	
	private Set<WebSocket> connexions = new HashSet<>();

    public Serveur(int port) {
        super( new InetSocketAddress( port ) );
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
    	J.appel(this);
    	
    	// TMP: simplement prendre en note
    	connexions.add(conn);
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    	J.appel(this);

    	// TMP: simplement prendre en note
    	connexions.remove(conn);
    }

    @Override
    public void onMessage(WebSocket socket, String chaineMessage) {
    	J.appel(this);

    	// TMP: simplement relayer le message
    	for(WebSocket connexion : connexions) {
    		
    		if(!connexion.equals(socket)) {
    			
    			connexion.send(chaineMessage);
    		}
    	}
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
    	J.appel(this);
    	ex.printStackTrace();
    }

    @Override
    public void onStart() {
        J.appel(this);
    }

}
