package commun.debogage;

import commun.systeme.Systeme;

public class Erreur {
	
	private static final String FATAL = "FATAL";
	private static final String ERREUR = "ERREUR";
	private static final String AVERTISSEMENT = "AVERTISSEMENT";

	public static void avertissement(String message) {
		J.messageErreur(0, AVERTISSEMENT, message);
	}

	public static void nonFatale(String message, Exception... exceptions) {
		J.messageErreur(0, ERREUR, message);
		afficherExceptions(exceptions);
	}

	public static void fatale(String message, Exception... exceptions) {
		J.messageErreur(0, FATAL, message);
		afficherExceptions(exceptions);
		Systeme.quitter();
	}

	private static void afficherExceptions(Exception... exceptions) {
		for(Exception e : exceptions) {
			// FIXME: est-ce qu'on a besoin de plus??
			e.printStackTrace();
		}
	}

}
