package commun_client.messages;

import org.java_websocket.WebSocket;

import commun.debogage.J;
import commun.messages.EnvoyeurMessage;
import commun.messages.Message;

public class EnvoyeurMessageClient {
	
	private static WebSocket socketClient;
	
	public static void initialiser(WebSocket socketClient) {
		J.appel(EnvoyeurMessageClient.class);
		
		EnvoyeurMessageClient.socketClient = socketClient;
	}
	
	public static void envoyer(Message message) {
		J.appel(EnvoyeurMessageClient.class);
		
		EnvoyeurMessage.envoyerSur(socketClient, message);
	}

}
