package commun.messages;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import commun.debogage.J;
import commun.utiles.Json;

public class FabriqueMessage {

    private static final Pattern TYPE_PATTERN = Pattern.compile("_Type[\"']\\s*:\\s*[\"'](\\w+)[\"']");
    
    private static Map<String, Class<? extends Message>> classesMessage = new HashMap<>();
    
    public static void memoriserClasseMessage( Class<? extends Message> classeMessage) {

        J.appel(Message.class);

        classesMessage.put(classeMessage.getSimpleName(), classeMessage);
    }

    public static Message aPartirJson(String json) {
        J.appel(Message.class);
        
        Message message = null;

        Matcher matcher = TYPE_PATTERN.matcher(json);
        
        if(matcher.find()) {
            
            String nomClasse = matcher.group(1);

            message = aPartirJson(json, nomClasse);
            
        }else {

            throw new RuntimeException("[FATAL] impossible d'analyser le message: " + json);

        }

        return message;
    }

    private static Message aPartirJson(String json, String nomClasse) {
        J.appel(Message.class);
        
        Message message = null;

		Class<? extends Message> classeMessage = classesMessage.get(nomClasse);
		
		if(classeMessage != null) {

			message = Json.aPartirJson(json, classeMessage);

		}else {
			
            throw new RuntimeException("[FATAL] impossible de trouver la classe: " + nomClasse);
			
		}

        return message;
    }
}
