package commun.messages;

import java.util.Collection;

import org.java_websocket.WebSocket;

import commun.debogage.J;
import commun.utiles.Json;

public class EnvoyeurMessage {

    public static void envoyerSur(WebSocket socket, Message message) {
    	J.appel(EnvoyeurMessage.class);
    	
    	if(socket.isOpen()) {
			socket.send(Json.versJson(message));
    	}
    }

    public static void diffuserSur(Collection<WebSocket> sockets, Message message) {
    	J.appel(EnvoyeurMessage.class);
    	
    	for(WebSocket socket : sockets) {

    		envoyerSur(socket, message);
    	}
    }

}
