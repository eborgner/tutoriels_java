package commun.debogage;

import java.util.Enumeration;

import commun.systeme.Systeme;

@SuppressWarnings({"rawtypes"})
public class DoitEtre {
	
	private static final int INCREMENT_PILE = 1;
	private static final String ECHEC = "ÉCHEC";
	
	public static void nonNul(Object valeur, String... messages) {
		if(valeur == null) {
			
			String message = "valeur nulle";
			
			if(messages.length > 0) {
				
				message = messages[0];
				
			}
				
			messagePuisQuitter(message);

		}
		
	}

	public static void nonVide(Enumeration enumeration, String... messages) {

		if(!enumeration.hasMoreElements()) {
			
			String message = "enumération vide";
			
			if(messages.length > 0) {
				
				message = messages[0];
				
			}
				
			messagePuisQuitter(message);

		}
		
	}

	private static void messagePuisQuitter(String message) {
		J.messageErreur(INCREMENT_PILE, ECHEC, message);
		Systeme.quitter();
	}
	
}
