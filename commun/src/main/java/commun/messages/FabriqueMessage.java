package commun.messages;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import commun.Fabrique;
import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun.utiles.Json;

@SuppressWarnings({"rawtypes", "unchecked"})
public class FabriqueMessage {

    private static final Pattern TYPE_PATTERN = Pattern.compile("_Type[\"']\\s*:\\s*[\"'](\\w+)[\"']");
    
    private static Map<String, Class<? extends Message>> classeParNom = new HashMap<>();
    private static Map<Class<? extends Message>, RecepteurMessage> recepteurs = new HashMap<>();
    
    private static Set<Canal> canauxPourRelais = new HashSet<>();
    private static Canal canalPourEnvoi;

    public static void memoriserCanalPourEnvoi(Canal canalPourEnvoi) {
    	J.appel(FabriqueMessage.class);
    	
    	FabriqueMessage.canalPourEnvoi = canalPourEnvoi;
    }
    
    public static void ajouterCanalPourRelais(Canal canalPourRelais) {
    	J.appel(FabriqueMessage.class);
    	
    	canauxPourRelais.add(canalPourRelais);
    }

    public static void retirerCanalPourRelais(Canal canalPourRelais) {
    	J.appel(FabriqueMessage.class);
    	
    	canauxPourRelais.add(canalPourRelais);
    }
    
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

	public static <M extends Message> M obtenirMessagePourEnvoi(Class<M> classeMessage) {
    	J.appel(FabriqueMessage.class);
    	
    	M message = Fabrique.nouvelleInstance(classeMessage);
    	
    	message.setCanalPourEnvoi(canalPourEnvoi);
    	
    	return message;
	}

	static <M extends Message> M obtenirMessagePourEnvoi(Class<M> classeMessage, Canal canalPourEnvoi) {
    	J.appel(FabriqueMessage.class);
    	
    	M message = Fabrique.nouvelleInstance(classeMessage);
    	
    	message.setCanalPourEnvoi(canalPourEnvoi);
    	
    	return message;
	}

	public static void recevoirMessage(Canal recuSur, String chaineMessage) {
		J.appel(FabriqueMessage.class);
		
		String nomClasseMessage = nomClasseMessage(chaineMessage);
		
		Class<? extends Message> classeMessage = classeParNom.get(nomClasseMessage);

		Set<Canal> canauxPourRelais = new HashSet<>();
		canauxPourRelais.addAll(canauxPourRelais);
		canauxPourRelais.remove(recuSur);
		
		if(classeMessage == null) {

			relayerMessage(canauxPourRelais, chaineMessage);

		}else {

			recevoirMessage(canauxPourRelais, classeMessage, chaineMessage);
		}
	}

	public static void relayerMessage(Set<Canal> canauxPourRelais, String chaineMessage) {
		J.appel(FabriqueMessage.class);
		
		for(Canal canalPourRelais : canauxPourRelais) {
			
			if(canalPourRelais.siOuvert()) {
				
				canalPourRelais.envoyer(chaineMessage);
			}
		}
	}

	public static void recevoirMessage(Set<Canal> canauxPourRelais, 
			                           Class<? extends Message> classeMessage, 
			                           String chaineMessage) {

		J.appel(FabriqueMessage.class);

		RecepteurMessage recepteur = recepteurs.get(classeMessage);
		
		if(recepteur == null) {
			
			relayerMessage(canauxPourRelais, chaineMessage);

		}else {

			recevoirMessage(canauxPourRelais, recepteur, classeMessage, chaineMessage);
		}
	}

	public static void recevoirMessage(Set<Canal> canauxPourRelais, 
									   RecepteurMessage recepteur,
			                           Class<? extends Message> classeMessage, 
			                           String chaineMessage) {

		Message message = aPartirChaineMessage(chaineMessage, classeMessage);
		message.setCanauxPourRelai(canauxPourRelais);
		recepteur.recevoirMessage(message);
	}
}
