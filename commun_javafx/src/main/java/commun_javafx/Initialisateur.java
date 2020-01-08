package commun_javafx;

import commun.debogage.J;
import commun.systeme.Quitteur;
import commun.systeme.Systeme;
import javafx.application.Platform;

public class Initialisateur {
	
	public static void initialiser() {

		J.initialiser(J.Contexte.JAVAFX);

		J.appel(Initialisateur.class);
		
		Systeme.installerQuitteur(new Quitteur() {
			@Override
			public void quitter() {
				Platform.exit();
				System.exit(0);
			}
		});
		
		
	}

}
