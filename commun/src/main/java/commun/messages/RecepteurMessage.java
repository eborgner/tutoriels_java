package commun.messages;

import java.util.HashMap;
import java.util.Map;

import org.java_websocket.WebSocket;

import commun.debogage.J;

@SuppressWarnings({"rawtypes", "unchecked"})
public class RecepteurMessage {
	
	private static final Map<Class<? extends Message>, MessageRecu> recepteurs = new HashMap<>();
	
	public static <M extends Message> void preparerReception(Class<M> classeMessage, MessageRecu<M> recepteur) {
		J.appel(RecepteurMessage.class);
		
		FabriqueMessage.memoriserClasseMessage(classeMessage);

		recepteurs.put(classeMessage, recepteur);
		
	}
	
	public static void recevoirMessageSur(WebSocket socket, String chaineMessage) {
		J.appel(RecepteurMessage.class);
		
		Message messageRecu = FabriqueMessage.aPartirJson(chaineMessage);
		
		MessageRecu recepteur = recepteurs.get(messageRecu.getClass());
		
		recepteur.reagirMessageRecuSur(socket, messageRecu);
	}
	
	
	
	

}
