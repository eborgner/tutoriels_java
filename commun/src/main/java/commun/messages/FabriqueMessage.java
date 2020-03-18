package commun.messages;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.java_websocket.WebSocket;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun.utiles.Json;

public class FabriqueMessage {

    private static final Pattern TYPE_PATTERN = Pattern.compile("_Type[\"']\\s*:\\s*[\"'](\\w+)[\"']");
    
    private static Map<String, Class<? extends Message>> classeParNom = new HashMap<>();
    private static Map<Class<? extends Message>, RecepteurMessage> recepteurs = new HashMap<>();
    
    private static Set<Canal> canaux = new HashSet<>();
    
    public static String nomClasseMessage(String chaineMessage) {
    	J.appel(FabriqueMessage.class);
    	
    	String nomClasseMessage = null;

        Matcher matcher = TYPE_PATTERN.matcher(chaineMessage);
        
        if(matcher.find()) {
            
            nomClasseMessage = matcher.group(1);

        }else {

            throw new RuntimeException("[FATAL] impossible d'analyser le message: " + chaineMessage);

        }
    	
    	return nomClasseMessage;
    }


    private static Message aPartirChaineMessage(String chaineMessage, Class<? extends Message> classeMessage) {
        J.appel(Message.class);

        return Json.aPartirJson(chaineMessage, classeMessage);
    }
    
    public static void installerRecepteur(Class<? extends Message> classeMessage, RecepteurMessage recepteur) {
    	J.appel(FabriqueMessage.class);
    	
    	recepteurs.put(classeMessage, recepteur);
    	classeParNom.put(classeMessage.getSimpleName(), classeMessage);
    }

	public static void recevoirMessage(Canal recuSur, String chaineMessage) {
		J.appel(FabriqueMessage.class);
		
		String nomClasseMessage = nomClasseMessage(chaineMessage);
		
		Class<? extends Message> classeMessage = classeParNom.get(nomClasseMessage);
		
		DoitEtre.nonNul(classeMessage, "Récepteur non-installé pour: " + nomClasseMessage);
		
		RecepteurMessage recepteur = recepteurs.get(classeMessage);
		
		DoitEtre.nonNul(recepteur, "Récepteur non-installé pour: " + nomClasseMessage);
		
		Message message = aPartirChaineMessage(chaineMessage, classeMessage);
		
		Set<Canal> connexionsPourRelais = new HashSet<>();
		connexionsPourRelais.addAll(canaux);
		connexionsPourRelais.remove(recuSur);
		
		message.setConnexionsPourRelai(connexionsPourRelais);
		
		recepteur.recevoirMessage(message);
	}
}
