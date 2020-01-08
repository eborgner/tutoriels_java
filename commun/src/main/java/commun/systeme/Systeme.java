package commun.systeme;

import commun.debogage.Erreur;
import commun.debogage.J;

public class Systeme {
	
	private static Quitteur quitteur;
	
	public static void installerQuitteur(Quitteur quitteur) {
		J.appel(Systeme.class);
		Systeme.quitteur = quitteur;
	}

	public static void quitter() {
		if(quitteur != null) {
			quitteur.quitter();
		}else {
			Erreur.fatale("Systeme.quitteur n'a pas été installé");
			System.exit(0);
		}
	}

}
